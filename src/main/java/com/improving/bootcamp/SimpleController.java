package com.improving.bootcamp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Random;

@Controller
public class SimpleController {

    private BookRepository bookRepository ;

    public SimpleController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String home(ModelMap model, Principal principal){
        model.put("book", new Book("", ""));
        setCommonModelAttribute(model, principal);
        return "home";
    }

    private void setCommonModelAttribute(ModelMap model, Principal principal) {
        model.put("showForm", (principal != null && principal.getName().equalsIgnoreCase("admin")));
        model.put("message", getMessage());
        model.put("name", (principal != null) ? principal.getName() : "Boot Camp" ) ;
        model.put("friend", "Jennifer");
        model.put("books", bookRepository.getBooks());
    }

    @PostMapping("/add")
    public String add(ModelMap model ,
                      @Valid @ModelAttribute("book") Book book,
                      BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            setCommonModelAttribute(model, principal);
            return "home";
        }
        bookRepository.add(book);
        return "redirect:/home";
    }

    private String getMessage(){
        boolean morning = new Random().nextBoolean();
        return (morning) ? "Hello" : "Goodbye";

    }

    @GetMapping("/book")
    public String book(ModelMap model, @RequestParam Integer id){
        model.put("book", bookRepository.getBook(id));
        return "book" ;
    }

    @GetMapping("/bad")
    public String badRequest(){
        throw new RuntimeException("Something went wrong");
    }

    @GetMapping("/teapot")
    public String teapot(){
        throw new TeaPotException();
    }

}
