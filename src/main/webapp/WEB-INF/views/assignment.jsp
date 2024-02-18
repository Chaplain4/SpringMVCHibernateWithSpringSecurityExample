<%@ page import="com.websystique.springmvc.model.Office" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.websystique.springmvc.service.OfficeService" %>
<%@ page import="com.websystique.springmvc.service.OfficeServiceImpl" %>
<%@ page import="com.websystique.springmvc.model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%@include file="authheader.jsp" %>

    <div class="well lead">User Assignment Form</div>
    <form:form method="POST" modelAttribute="user" class="form-horizontal">
            <div class="group">
                <select name="office">
                    <%
                        List<Office> offices = (List<Office>) request.getAttribute("offices");
                        User user = (User) request.getAttribute("user");
                        for (Office office : offices) {
                        if (office.equals(user.getOffice())) {%>
                    <option value='<%=office.getId()%>' selected><%=office.getId() + " - " + office.getTitle()%>
                                <%} else {%>
                    <option value='<%=office.getId()%>'><%=office.getId() + " - " + office.getTitle()%>
                    </option>
                    <%
                            }
                        }
                    %>
                </select>
                <label>Office</label>
            </div>
            <button type="submit" class="button buttonBlue">Assign
                <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
            </button>
    </form:form>
</div>
</body>
</html>