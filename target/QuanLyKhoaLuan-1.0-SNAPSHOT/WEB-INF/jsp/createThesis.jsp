<%-- 
    Document   : createThesis
    Created on : Aug 8, 2022, 9:20:06 AM
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

<h1 class="text-center text-danger">Thêm khóa luận</h1>

<c:url value="/academic/createThesis" var="action"/>


<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="thesis" >
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-group">
        <label for="name">Tên khóa luận</label>
        <form:input class="form-control" path="name" id="name" placeholder="Nhap ten khoa luan" />
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
        <label for="year" class="form-label">Chọn năm</label>
        <input type="number" id="year" name="year" min="2010" max="2030" />        
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm khóa luận" class="btn btn-primary"/>
    </div>
</form:form>


