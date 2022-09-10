<%-- 
    Document   : checkPoint
    Created on : Aug 8, 2022, 10:18:22 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/Teacher/points" var="action" />
<!--<div class="container-fluid">
    <div>
        <p>Qúa trình thực hiện đồ án:</p>
        <input type="text" class="form-control" id="pwd" placeholder="" />
        <p>Hình thức trình bày báo cáo:</p>
        <input type="text" class="form-control" id="pwd" placeholder="" />
        <p>Nội dung báo cáo:</p>
        <input type="text" class="form-control" id="pwd" placeholder="" />
        <p>Kết quả đạt được của đồ án:</p>
        <input type="text" class="form-control" id="pwd" placeholder="" />
    </div>      
</div>-->
<h1 class="text-center text-danger">Chấm điểm</h1>
<form:form method="post" action="${action}" modelAttribute="point" enctype="multipart/form-data">
    <div class="container-fluid"/>
    <div class="mb-3">
        <label for="fullname" class="form-label">ID:</label>
        <form:input type="text" class="form-control" id="pwd" placeholder="" path="scoreId" />
    </div>
    <div class="mb-3">
        <label for="fullname" class="form-label">Qúa trình thực hiện đồ án:</label>
        <form:input type="text" class="form-control" id="pwd" placeholder="" path="score1" />
    </div>
    <label for="email" class="form-label">Hình thức trình bày báo cáo:</label>
    <form:input type="text" class="form-control" id="email" placeholder="" path="score2" />

    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Nội dung báo cáo::</label>
        <form:input type="text" class="form-control" id="name" placeholder="" path="score3"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="pwd" class="form-label">Kết quả đạt được của đồ án:</label>
        <form:input type="text" class="form-control" id="pwd" placeholder="" path="score4"/>
    </div>
    <div>
        <br>
        <input type="submit" value="Lưu" class="btn btn-danger"/>
    </div>
</div>
</form:form>
