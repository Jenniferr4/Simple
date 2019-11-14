<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "h" uri = "http://tomcat.apache.org/hello-taglib" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

    <head>
        <title>Application</title>
        <style type ="text/css">
        .error{border: 1px solid red;}
        </style>
    </head>


    <body >
        <img  src="/static/avengers.png"  alt="" height="100px" width="100px" >
        <h:hello name="${name}"/>
        <h3> ${friend} said:</h3>
        <p id="row">Everything is awesome!</p>

        </br>
        </br>

        <c:forEach items= "${books}" var= "book">
            <i> ${book.getTitle()} </i> by ${book.getAuthor()} </br>
        </c:forEach>

        <form:form action="/add" modelAttribute="book">
            <form:input path="title" placeholder="title" cssErrorClass="error" />
            <form:errors path="title" cssErrorClass="errorMessage" />
            <form:input path="author" placeholder="author" cssErrorClass="error" />
            <form:errors path="author" cssErrorClass="error" />
            <input type="submit" value="Add Book">
        </form:form>

    </body>


</html>