<%-- 
    Document   : login
    Created on : Aug 7, 2022, 3:15:54 PM
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
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Tên người dùng hoặc Mật khẩu không hợp lệ!
            </div>
        </c:if>
        <c:if test="${param.accessDenied != null}">
            <div class="alert alert-danger">
                Không có quyền truy cập!
            </div>
        </c:if>
        <c:url value="/login" var="action"/>
        <div class="container" style="height: 250px; width: 400px">
            <form method="post" action="${action}" class="container">
                <div class="mb-3 mt-3">
                    <label for="email" class="form-label text-center">Tên người dùng:</label>
                    <input type="text" name="username" class="form-control" id="email" placeholder="Nhập tên người dùng..." name="email">
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label text-center">Mật khẩu:</label>
                    <input type="password" name="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu..." name="pswd">
                </div>
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
            </form>
        </div>
    </body>
</html>
