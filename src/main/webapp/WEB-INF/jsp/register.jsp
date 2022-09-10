<%-- 
    Document   : register
    Created on : Aug 7, 2022, 8:32:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/register" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/admin/adminPage">Trở về</a></button>

<h1 class="text-center text-danger">Thêm tài khoản</h1>
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <div class="container-fluid"/>

    <div class="mb-3">
        <label for="fullname" class="form-label">Họ và Tên:</label>
        <form:input type="text" class="form-control" id="pwd" placeholder="" path="fullname" />
    </div>

    <label for="email" class="form-label">Email:</label>
    <form:input type="email" class="form-control" id="email" placeholder="" path="email" />

    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Tên người dùng:</label>
        <form:input type="text" class="form-control" id="name" placeholder="" path="username"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="pwd" class="form-label">Mật khẩu:</label>
        <form:input type="password" class="form-control" id="pwd" placeholder="" path="password"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Nhập lại Mật khẩu:</label>
        <form:input type="password" class="form-control" id="cf-pwd" placeholder="" path="confirmPassword"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Avatar:</label> 
        <form:input type="file" class="form-control" id="avt" placeholder=" " path="file"/>
    </div


    <label for="pwd" class="form-label">Vai trò:</label>
    <div class="form-floating" style="width: 300px; height: 80px"  >Chọn vai trò
        <form:select path="userRole" class="form-select" id="userrole" name="userrole" >
            <option style="padding: 50px 70px 40px" >ROLE_GiaoVu</option>
            <option style="padding: 50px 70px 40px" >ROLE_GiangVien</option>
            <option style="padding: 50px 70px 40px">ROLE_SinhVien</option>
        </form:select>
    </div>



    <div class="form-floating"style="width: 300px; height: 80px" > Chọn ngành:
        <form:select path="facultyId" class="form-select" id="user" name="user" >
            <c:forEach var="f" items="${faculty}">
                <option value="${f.id}" >${f.name}</option>
            </c:forEach>
        </form:select>
    </div>
    
     <div class="text-center">
        <button type="button" class="btn btn-danger" style="width: 100px; height: 50px">
            <input type="submit" value="Thêm" onclick="return ConfirmDelete();" class="btn btn-danger"/>
        </button>
    </div>


<!--    <div>
        <br>
        <input type="submit" value="Thêm" class="btn btn-danger"/>
    </div>-->
</div>
</form:form>

<script>
    function ConfirmDelete() {
        var result = confirm("Bạn có muốn lưu không?");
        if (result == true) {
            alert('Lưu thành công');
            return true;
        } else {
            return false;
        }
    }
</script>  
