<%-- 
    Document   : userDetail
    Created on : Aug 8, 2022, 9:10:49 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<c:url value="/admin/user/delete/${userdetail.id}" var="action" />--%>

<div class="row">
    <div class="col-md-4 col-xs-12" >
        <div class="container" style="width:400px" >
            <img class="card-img-top rounded-circle" src="${userdetail.avatar}" alt="Card image">
            <h2 class="container" style="width:800px">${userdetail.fullname}</h2>
        </div>
    </div>

    <div class="col-md-8 col-xs-12">


        <div class="mb-3 mt-3">
            <label for="email" class="form-label">Tên tài khoản:    <b>${userdetail.username}</b></label>            
        </div>
        <div class="mb-3 mt-3">
            <label for="email" class="form-label">Email: <b>${userdetail.email}</b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Ngày tham gia:  <b>${userdetail.createdDate}</b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Vai trò:  <b>
                    <c:choose>
                        <c:when test="${userdetail.userRole == 'ROLE_GiaoVu'}">
                            <c:out value="Giáo vụ"></c:out>
                        </c:when>
                        <c:when test="${userdetail.userRole == 'ROLE_GiangVien'}">
                            <c:out value="Giảng viên"></c:out>
                        </c:when>
                        <c:when test="${userdetail.userRole == 'ROLE_SinhVien'}">
                            <c:out value="Sinhh Viên"></c:out>
                        </c:when>
                        <c:when test="${userdetail.userRole == 'ROLE_ADMIN'}">
                            <c:out value="Quản trị"></c:out>
                        </c:when>
                    </c:choose>
                </b></label>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Khoa:  <b>${userdetail.facultyId.name}</b></label>
        </div>
    </div>
    <%--<form:form method="get" action="${action}">--%>
    <!--        <div>
                <br>
                <input type="submit" value="Xóa" class="btn btn-danger"/>
            </div>-->
    <%--</form:form>--%>
    <div class="text-center">
        <button type="button" class="btn btn-danger" style="width: 100px; height: 50px">
            <a style="color: white" onclick="return ConfirmDelete();" href="<c:url value="/admin/user/delete/${userdetail.id}"/>">Xóa User</a>
        </button>
    </div>

</div>


<script>
    function ConfirmDelete() {
        var result = confirm("Bạn có muốn xóa khóa luận hay không?");
        if (result == true) {
            alert('Xóa thành công');
            return true;
        } else {
            return false;
        }
    }
</script>  

