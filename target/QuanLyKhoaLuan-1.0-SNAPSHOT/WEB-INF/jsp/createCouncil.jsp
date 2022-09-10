<%-- 
    Document   : create_council
    Created on : Aug 7, 2022, 8:59:39 PM
    Author     : Admin
--%>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/academic/manager">Trở về</a></button>


<h1 class="text-center text-danger">Thêm hội đồng</h1>

<c:url value="/academic/createCouncil" var="action"/>


<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>


<form:form method="post" action="${action}" modelAttribute="council" >
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-group">
        <label for="name">Tên hội đồng</label>
        <form:input class="form-control" path="name" id="name" placeholder="Nhap tên hội đồng" />
        <form:errors path="name" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-group">
        <label for="faculty" class="form-label">Thuộc khoa</label>
        <form:select path="facultyId" class="form-select">
            <c:forEach items="${faculties}" var="f">
                <option value="${f.id}">${f.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <br/>
    <div class="form-group">
        <label for="year" class="form-label">Chọn thời gian</label>
        <input type="date" id="created_date" name="created_date"/>        
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm hội đồng" class="btn btn-primary"/>
    </div>
</form:form>