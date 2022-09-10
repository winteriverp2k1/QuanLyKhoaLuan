<%-- 
    Document   : performThesis
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
<c:url value="/academic/performThesis" var="action"/>
<form:form method="post" action="${action}" modelAttribute="thesis_position" name="choice" >
    <form:input cssClass="hidden" name="thesisId" path="thesisId" value="${thesis.id}"></form:input>
        <div  class="form-group">
            <label for="position" class="form-label">Chọn vai trò:</label>
        <form:select id="choose" path="thesisPosition" cssClass="form-select">
            <option> Chọn vai trò </option>
            
            <option value="ROLE_GiangVien">Giảng viên hướng dẫn</option>
            <option value="ROLE_SinhVien">Sinh viên</option>
        </form:select>
    </div>
    <div id="result1" class="form-group">
        <label for="teachers" class="form-label">Chọn giảng viên:</label>
        <form:select id="userId" path="userId" cssClass="form-select">           
        </form:select>
    </div>
    <br/>
    <div class="container-fluid">
        <h2 class="text-center text-danger">
            Số sinh viên thực hiện khóa luận có thể thêm còn lại: ${2 - count_students}
        </h2>
        <br/>
        <h2 class="text-center text-danger">
            Số giảng viên hướng dẫn khóa luận có thể thêm còn lại: ${2 - count_teachers}
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