<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%@include file="authheader.jsp" %>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Offices </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Title</th>
                <th>Address</th>
                <th>Postal code</th>
                <th>Updated TS</th>
                <th>Created TS</th>
                <th>Phone 1</th>
                <th>Phone 2</th>
                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                    <th width="100"></th>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${offices}" var="office">
                <tr>
                    <td>${office.title}</td>
                    <td>${office.address}</td>
                    <td>${office.postalCode}</td>
                    <td>${office.updatedTS}</td>
                    <td>${office.createdTS}</td>
                    <td>${office.phone1}</td>
                    <td>${office.phone2}</td>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                        <td><a href="<c:url value='edit-office-${office.id}' />" class="btn btn-success custom-width">edit</a></td>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <td><a href="<c:url value='delete-office-${office.id}' />" class="btn btn-danger custom-width">delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
        <div class="well">
            <a href="<c:url value='newoffice' />">Add New Office</a>
        </div>
    </sec:authorize>
    <div class="well">
        <a href="<c:url value='/list' />">View users</a>
    </div>
    <div class="well">
        <a href="<c:url value='/authorsBooks/list' />">View authors and books</a>
    </div>
</div>
</body>
</html>