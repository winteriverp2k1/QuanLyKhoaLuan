<%--
    Document   : AddScore
    Created on : Sep 1, 2022, 4:13:22 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/Teacher/score/${thesis.id}" var="action" />

<h1 class="text-center text-danger">Xác nhận thông tin</h1>
<form:form method="post" action="${action}" modelAttribute="score" >
    <div class="mb-3">
        <c:forEach var="u" items="${idthesis}">
            <tr class="table-success">
                <td>Thesis ID: ${u.id}</td>
                <form:input cssClass="hidden" name="thesisId" path="thesisId" value="${u.id}"></form:input>
            </tr>
        </c:forEach>
    </div>

    <div class="mb-3">
        <c:forEach items="${idcouncilpos}" var="a">
            <tr class="table-success">
                <c:if test="${a.userId.id == currentUser.id}">
                    <td>Council ID: ${a.id}</td>
                    <form:input cssClass="hidden" name="councilPositionId" path="councilPositionId" value="${a.id}"></form:input>
                </c:if>
            </tr>
        </c:forEach>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm" class="btn btn-primary"/>
    </div>
</form:form>



