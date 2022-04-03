<%--
  Created by IntelliJ IDEA.
  User: nikolajvereschagin
  Date: 31.03.2022
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>


</head>
<body>
    <div class="top">
    <form:form method="POST" modelAttribute="numberForm">
        <h2 style="color: black;text-decoration: none"> Number</h2>
        <div>
            <form:input style="border-radius: 6.5px; height: 30px; width: 250px;background-color: seashell;"
                        name="number" type="text" path="number" placeholder="Number"
                        autofocus="true"></form:input>
            <form:errors path="number"></form:errors>
        </div>

        <form action="${pageContext.request.contextPath}" method="post">
            <input type="hidden" name="action" value="find"/>
            <button type="submit">find</button>
        </form>
    </form:form>
    </div>
    <p></p>
    <p></p>
    <p></p>
    <p></p>
    <c:forEach items="${NumberStartWith}" var="phoneList">
        <h4> Number: ${phoneList.number}           Count of comment: ${phoneList.list.size()}</h4>
        <p/>
    </c:forEach>
    <c:if test="${PhoneNotContains.equals('Phone Not Contains')}">
        <h style="color: red">${PhoneNotContains}</h>
        <form action="${pageContext.request.contextPath}" method="post">
            <input type="hidden" name="number" value="${phone.number}"/>

            <input type="hidden" name="action" value="add"/>
            <button type="submit">Add</button>
        </form>
    </c:if>

    <c:if test="${phoneModel.number!=null}">

    <h4>Number ${phoneModel.number}</h4>
    <p></p>
    <h4>Country ${phoneModel.country}</h4>
    <p></p>
    <h4></h4>
    <p></p>

        <a href="/addComment/${phoneModel.number}"> Add comment</a>
        <p/>





        <c:forEach items="${phoneModel.list}" var="list">
            <h>---------------------------------------------------------------------</h>
            <p/>
        <h> Author: ${list.nameAuthor}                   Grade: ${list.reting!=null ?list.reting:'Not Information'}   </h>
            <sec:authorize access="isAuthenticated()">
            <form method="post">
            <select name="grade" >
                <option value="1" label="1">1</option>
                <option value="2" label="2">2</option>
                <option value="3" label="3">3</option>
                <option value="4" label="4">4</option>
                <option value="5" label="5">5</option>
            </select>
                <input type="hidden" name="number" value="${list.id}"/>

                <input type="hidden" name="action" value="addGrade"/>
                <button type="submit" >Add</button>
            </form>
        </sec:authorize>

        <p/>
        <p/>
        <h>${list.text}</h>
            <p/>
        <h>---------------------------------------------------------------------</h>
            <p/>
            <p/>
            <p/>
            <p/>
    </c:forEach>


    </c:if>



    <a href="/">Main</a>


</body>
</html>
