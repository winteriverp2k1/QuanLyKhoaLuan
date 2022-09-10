<%-- 
    Document   : accountDetail
    Created on : Aug 10, 2022, 11:04:26 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-danger">Hồ sơ người dùng</h1>
<div class="row">
    <div class="col-md-4 col-xs-12" >
        <div class="container" style="width:400px" >
            <img class="card-img-top rounded-circle" src="${currentUser.avatar}" alt="Card image">
            <h2 class="container" style="width:800px">${currentUser.fullname}</h2>
        </div>
    </div>

    <div class="col-md-8 col-xs-12">


        <div class="mb-3 mt-3">
            <label for="email" class="form-label">Tên tài khoản:    <b>${currentUser.username}</b></label>            
        </div>
        <div class="mb-3 mt-3">
            <label for="email" class="form-label">Email: <b>${currentUser.email}</b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Ngày tham gia:  <b>${currentUser.createdDate}</b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Vai trò:  <b>
                    <c:choose>
                        <c:when test="${currentUser.userRole == 'ROLE_GiaoVu'}">
                            <c:out value="Giáo vụ"></c:out>
                        </c:when>
                        <c:when test="${currentUser.userRole == 'ROLE_GiangVien'}">
                            <c:out value="Giảng viên"></c:out>
                        </c:when>
                        <c:when test="${currentUser.userRole == 'ROLE_SinhVien'}">
                            <c:out value="Sinhh Viên"></c:out>
                        </c:when>
                        <c:when test="${currentUser.userRole == 'ROLE_ADMIN'}">
                            <c:out value="Quản trị"></c:out>
                        </c:when>
                    </c:choose>
                </b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Khoa:  <b>${currentUser.facultyId.name}</b></label>
        </div>
<!--        <div class="mb-3">
            <label for="email" class="form-label">pass:  <b>${currentUser.password}</b></label>
        </div>-->

<!--            <a class="nav-link text-danger" href="<c:url value="/changePassword"/>">
         <button type="submit" class="btn btn-primary">Thay đổi mật khẩu</button>
    </a>-->
            <!--modelAttribute="currentUser"-->
        <div>
            <h2 class="text-center text-danger">Nhập mật khẩu cũ trước khi bạn muốn thay đổi mật khẩu </h2>
            <c:url value="/detail/${currentUser.id}" var="action" />
            <form action="${action}" method="post" >
                 <div class="mb-3 mt-3">
                    <label for="pwd" class="form-label">Mật khẩu cũ:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="" name="old"/>
                </div>
                <div class="mb-3 mt-3">
                    <label for="pwd" class="form-label">Mật khẩu mới:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="" name="new"/>
                </div>
                
                <div class="mb-3">
                    <label for="pwd" class="form-label">Nhập lại mật khẩu mới:</label>
                    <input type="password" class="form-control" id="cf-pwd" placeholder="" name="confirmPassword"/>
                </div>
                 <button type="submit" onclick="return ConfirmDelete();" class="btn btn-primary">Lưu</button>
            </form>
        </div>
    </div>
</div>
<script>
    function ConfirmDelete() {
        var result = confirm("Bạn có muốn thay đổi mật khẩu hay không?");
        if (result == true) {
            alert('Thay đổi thành công');
            return true;
        } else {
            return false;
        }
    }
</script>  

