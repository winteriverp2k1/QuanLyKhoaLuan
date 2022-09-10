<%-- 
    Document   : userManager
    Created on : Aug 8, 2022, 9:08:12 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/user/userId" var="action" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/admin/adminPage">Trở về</a></button>
<h1 class="text-center text-danger">Danh sách tài khoản</h1>

<div>
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(count/8)}" var="i">
            <c:url value="/admin/userManager" var="c">
                <c:param value="${i}" name="page"  />
            </c:url>
            <li class="page-item"><a  class="page-link" href="${c}">${i}</a></li>
            </c:forEach>
    </ul>
</div>

<%--<c:url value="/admin/userManager" />--%>
<form action="">
    <div class="row">
        <div class="col-md-10">
            <input class="form-control" type="text" name="kw"  placeholder="nhập tên khóa luận"/>
        </div>
        <div class="col-md-2">
            <input type="submit" value="Tìm kím" class="btn btn-danger"/>
        </div>
    </div>
</form>
<br>
<div class="container md">
    <table class="table">
        <thead>
            <tr>
                <th>Username</th>
                <th>Họ và Tên</th>
                <th>Chức vụ</th>
                <th>Ngày tạo</th>
                <th></th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${user}">
                <c:if test="${u.userRole != 'ROLE_ADMIN'}">
                    <tr class="table-success">
                        <td>${u.username}</td>
                        <td>${u.fullname}</td>
                        <td>
                            <c:choose>
                                <c:when test="${u.userRole == 'ROLE_GiaoVu'}">
                                    <c:out value="Giáo vụ"></c:out>
                                </c:when>
                                <c:when test="${u.userRole == 'ROLE_GiangVien'}">
                                    <c:out value="Giảng viên"></c:out>
                                </c:when>
                                <c:when test="${u.userRole == 'ROLE_SinhVien'}">
                                    <c:out value="Sinhh Viên"></c:out>
                                </c:when>
                            </c:choose>
                        </td>  

                        <td>${u.createdDate}</td>
                        <td>
                            <a class="nav-link text-danger" href="<c:url value="/user/${u.id}"/>">Xem chi tiết</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>

