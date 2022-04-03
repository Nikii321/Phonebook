<%--
  Created by IntelliJ IDEA.
  User: nikolajvereschagin
  Date: 31.03.2022
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<form:form method="POST" modelAttribute="commentForm">
    <h2 style="color: #f1f1f1;text-decoration: none">Add comment</h2>
    <div>
        <form:input style="border-radius: 6.5px; height: 30px; width: 250px;background-color: seashell;" name="username"
                    type="text" path="text" placeholder="text"
                    autofocus="true"></form:input>
    </div>


    <button type="submit"
            style="width: 190px; height: 30px; background-color: skyblue; border-radius:6.5px;margin-left: 0px">
            Add
    </button>
    <p/>
    <h>${Thanks}</h>
    <p/>
    <a href="/number" > Number</a>
</form:form>
</body>
</html>
