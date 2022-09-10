<%-- 
    Document   : adminPage
    Created on : Aug 8, 2022, 5:29:33 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <h1 class="text-center text-danger" style="font-size: 50px">Quản trị</h1>
        <br>
        <br>
        <div class="container-fluid">
            <button type="button" class="btn btn-primary" style="height:200px;width:350px">
                <a class="navbar-brand" style="color: white; font-size: 35px" href="<c:url value="/admin/userManager"/>"/>Quản lý người dùng</a>      
            </button>
            <button type="button" class="btn btn-secondary" style="height:200px;width:350px">
                 <a class="navbar-brand" style="color: white; font-size: 29px" href="<c:url value="/admin/register"/>"/> Tạo tài khoản người dùng</a>  
            </button>
            <button type="button" class="btn btn-success" style="height:200px;width:350px">
                <a class="navbar-brand" style="color: white; font-size: 35px" href="<c:url value="/admin/statistical"/>"/> Thống kê</a>
            </button>
           
        </div>
        <br>
        <br>
        <br>
    </body>
</html>
