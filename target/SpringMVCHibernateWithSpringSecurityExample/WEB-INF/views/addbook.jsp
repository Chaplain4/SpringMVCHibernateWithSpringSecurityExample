<%@ page import="com.websystique.springmvc.model.Office" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.websystique.springmvc.service.OfficeService" %>
<%@ page import="com.websystique.springmvc.service.OfficeServiceImpl" %>
<%@ page import="com.websystique.springmvc.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.websystique.springmvc.model.Book" %>
<%@ page import="com.websystique.springmvc.model.Author" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book list</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%@include file="authheader.jsp" %>

    <div class="well lead">Book list</div>
    <form:form method="POST" modelAttribute="author" class="form-horizontal">
        <div class="group">
            <select name="bookId">
                <%
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    Author author = (Author) request.getAttribute("author");
                    for (Book book : books) {
                     %>
                <option value='<%=book.getId()%>'><%=book.getName() + " - " + book.getCategory()%>
                </option>
                <%
                    }
                %>
            </select>
            <label>Book</label>
        </div>
        <button type="submit" class="button buttonBlue">Update
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form:form>
</div>
</body>
</html>