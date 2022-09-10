<%-- 
    Document   : academic
    Created on : Aug 8, 2022, 6:47:03 PM
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
        <h1 class="text-center text-danger">Giáo vụ</h1>
        <br>
        <br>
        <div class="container-fluid">
            <button type="button" class="btn btn-primary" style="height:50px;width:500px">
                <a class="navbar-brand" style="color: white" href="<c:url value="/academic/createThesis"/>">Thêm Khóa Luận</a>
            </button>
           
            <button type="button" class="btn btn-success" style="height:50px;width:500px">
                <a class="navbar-brand" style="color: white" href="<c:url value="/academic/createCouncil"/>">Thành lập hôi đồng bảo vệ khoá luận</a>                
            </button>
        </div>
        <br><!-- comment -->
        <br>
        <div class="container-fluid">
            <button type="button" class="btn btn-primary" style="height:50px;width:350px">
                 <a class="navbar-brand" style="color: white" href="<c:url value="/academic/councilList"/>"> Danh sách hội đồng</a>           
            </button>
            <button type="button" class="btn btn-secondary" style="height:50px;width:350px">
                <a class="navbar-brand" style="color: white" href="<c:url value="/academic/thesisList"/>">Danh sách khóa luận</a>    
            </button>
            <button type="button" class="btn btn-success" style="height:50px;width:350px">
                <a class="navbar-brand" style="color: white" href="<c:url value="/academic/statistical"/>"> Thống kê</a>              
            </button>
        </div>
        <br><!-- comment -->
        <br>
        <br>
        <br>
        <br>
    </body>
</html>
