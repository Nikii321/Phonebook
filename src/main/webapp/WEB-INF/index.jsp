<%--
  Created by IntelliJ IDEA.
  User: nikolajvereschagin
  Date: 30.03.2022
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/resources/image/aa.jpg");
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<div>
    <h3 style="color: #f1f1f1;text-decoration: none">Welcome</h3>
    <h3 style="color: #f1f1f1;text-decoration: none">${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4 style="color: #f1f1f1"><a href="/login" style="color: #f1f1f1">log in</a></h4>
        <h4 style="color: #f1f1f1"><a href="/registration" style="color: #f1f1f1">Registration</a></h4>
    </sec:authorize>


    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout" style="color: #f1f1f1">Log out</a></h4>
    </sec:authorize>
        <h4><a href="/number" style="color: #f1f1f1">number</a></h4>



</div>
</body>
</html>
