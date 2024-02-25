<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Books and Authors List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div style="width: 90%; alignment: center; padding-left: 50px"  class="inline-container">
    <%@include file="authheader.jsp" %>

    <form:form method="POST" class="form-horizontal">

        <label for="key">Key:</label>
        <input type="text" id="key" name="key">
        <br>
        <label for="searchPattern">Search Pattern:</label>
        <select id="searchPattern" name="searchPattern">
            <option value="author">By author</option>
            <option value="book">By book</option>
        </select>
        <br>
        <input type="submit" value="Search">

    </form:form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div style="width: 90%; overflow: hidden;" class="inline-container">


    <div style="width: 48%">

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Authors </span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Last name</th>
                    <th>Books</th>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                        <th width="100"></th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authors}" var="author">
                    <tr>
                        <td>${author.name}</td>
                        <td>${author.lastName}</td>
                        <td><c:forEach items="${author.books}" var="book">
                            ${book.name}
                            <br>
                        </c:forEach>
                        </td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='add-book-${author.id}' />" class="btn btn-success custom-width">+book</a>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='remove-book-${author.id}' />"
                                   class="btn btn-danger custom-width">-book</a>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='edit-author-${author.id}' />"
                                   class="btn btn-success custom-width">edit</a>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='delete-author-${author.id}' />"
                                   class="btn btn-danger custom-width">delete</a>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
                <a href="<c:url value='newauthor' />">Add New Author</a>
            </div>
        </sec:authorize>
    </div>
    <div style="width: 4%"></div>
    <div style="width: 48%">

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Books </span></div>
<%--            <form:form method="POST" class="form-horizontal">--%>
<%--                <div class="row">--%>
<%--                    <div class="form-group col-md-12">--%>
<%--                        <label class="col-md-3 control-lable" for="authorKey">Name</label>--%>
<%--                        <div class="col-md-7">--%>
<%--                            <form action="/SpringMVCHibernateWithSpringSecurityExample_war/authorsBooks/list" method="post">--%>
<%--                                <label for="authorKey">authorKey:</label><br>--%>
<%--                                <input type="text" id="authorKey" name="authorKey" value="" width=50%><br>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row">--%>
<%--                    <div class="form-actions floatRight">--%>
<%--                        <input type="submit" value="Find by author" class="btn btn-primary btn-sm"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </form:form>--%>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Pages</th>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                        <th width="100"></th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.category}</td>
                        <td>${book.pages}</td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='edit-office-${book.id}' />" class="btn btn-success custom-width">edit</a>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='delete-book-${book.id}' />" class="btn btn-danger custom-width">delete</a>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
                <a href="<c:url value='newbook' />">Add New Book</a>
            </div>
        </sec:authorize>

        <div class="well">
            <a href="<c:url value='/list' />">View users</a>
        </div>
        <div class="well">
            <a href="<c:url value='/offices/list' />">View offices</a>
        </div>

    </div>


</div>


</body>
</html>