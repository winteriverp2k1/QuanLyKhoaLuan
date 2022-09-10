<%-- 
    Document   : thesisDetail
    Created on : Aug 23, 2022, 8:32:45 PM
    Author     : huynh
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--<h1 class="text-center text-danger">Chi tiết khóa luận</h1>

<div class="row">
    <div class="col-md-12">
        <h3>Ten khoa luan: ${thesis.name}</h3>
        <h4>Nam thuc hien: ${thesis.year}</h4>  
        <h4>Tên khoa: ${thesis.facultyId.name}</h4>
    </div>
    <br/>
    <div class="col-md-12">
        <h2>Danh sách sinh viên thực hiện:</h2>

    </div>
    <br/>
    <div class="col-md-12">
        <h2>Danh sách giảng viên hướng dẫn:</h2>

    </div>
    
</div>-->

<h1 class="text-center text-danger">Chi tiết khóa luận</h1>

<div class="row">
    <div class="col-md-12">
        <h3>Tên khóa luận: ${thesis.name}</h3>
        <h4>Năm thực hiện: ${thesis.year}</h4>  
        <h4>Tên khoa: ${thesis.facultyId.name}</h4>
        <h4>Điểm: ${thesis.totalScore}</h4>
    </div>
    <br/>
    <div class="col-md-12">
        <h2>Danh sách sinh viên thực hiện:</h2>
        <c:forEach var="stds" items="${students}">
            <c:out value="- ${stds.userId.fullname} "></c:out>
        </c:forEach>
    </div>
    <br/>
    <div class="col-md-12">
        <h2>Danh sách giảng viên hướng dẫn:</h2>
        <c:forEach var="tchs" items="${teachers}">
            <c:out value="- ${tchs.userId.fullname} "></c:out>    
        </c:forEach>
    </div>

</div>