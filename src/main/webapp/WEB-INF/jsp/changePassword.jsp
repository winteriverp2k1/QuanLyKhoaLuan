<%-- 
    Document   : changePassword
    Created on : Aug 10, 2022, 12:47:36 PM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<h1 class="text-center text-danger">Thay đổi mật khẩu</h1>

<!--<br>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<br>
<div>
    <h2 class="text-center text-danger">Nhập mật khẩu mới </h2>
    <c:url value="/changePassword/${currentUser.id}" var="action" />
    <form action="${action}" method="post" modelAttribute="currentUser">
        <div class="mb-3 mt-3">
            <label for="pwd" class="form-label">Mật khẩu:</label>
            <input type="password" class="form-control" id="pwd" placeholder="" name="newPassword"/>
        </div>
        <div class="mb-3 mt-3">
            <label for="pwd" class="form-label">Xác nhận mật khẩu:</label>
            <input type="password" class="form-control" id="pwd" placeholder="" name="oldpassword"/>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>-->