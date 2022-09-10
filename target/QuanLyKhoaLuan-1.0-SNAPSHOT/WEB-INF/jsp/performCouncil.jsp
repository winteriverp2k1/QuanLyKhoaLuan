<%-- 
    Document   : performCouncil
    Created on : Aug 24, 2022, 11:06:31 AM
    Author     : huynh
--%>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="appContext" value="/"/>
<c:url value="/academic/performCouncil" var="action"/>
<form:form method="post" action="${action}" modelAttribute="council_position" name="choice" >
    <form:input cssClass="hidden" name="councildId" path="councilId" value="${council.id}"></form:input>
        <div  class="form-group">
            <label for="position" class="form-label">Chọn vai trò:</label>
        <form:select id="positionId" path="positionId" cssClass="form-select">
            <option> Chọn vai trò </option>
            <%--<c:forEach items="${position}" var="p">--%>
                <!--<option value="${p.id}">${p.name}</option>-->
            <%--</c:forEach>--%>
            <option value="1">Chủ tịch</option>
            <option value="2">Thư ký</option>
            <option value="3">Giáo viên phản biện</option>
            <option value="4">Thành viên 1(nếu có)</option>
            <option value="5">Thành viên 2(nếu có)</option>
        </form:select>
    </div>
    <div id="result1" class="form-group">
        <label for="teachers" class="form-label">Chọn giảng viên:</label>
        <form:select id="userId" path="userId" cssClass="form-select">
            <c:forEach items="${teachers}" var="t">
                <option value="${t.id}">${t.fullname}</option>
            </c:forEach>
        </form:select>
    </div>
    <br/>
    <div class="container-fluid">
        <br/>
        <h2 class="text-center text-danger">
            Số giảng viên tham gia hội đồng có thể thêm còn lại: ${5 - count_teachers}
        </h2>
    </div>
    <br/>
    <div class="form-group">
        <input type="submit" value="Phân công" class="btn btn-primary"/>
    </div>
</form:form>

<script src="<c:url value="/resources/js/thesis.js"/> "></script>
<style>
    .hidden{
        visibility: hidden;
    }
</style>