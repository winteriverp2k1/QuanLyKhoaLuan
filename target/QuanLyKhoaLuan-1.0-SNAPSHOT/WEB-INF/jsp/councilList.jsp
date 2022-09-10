<%-- 
    Document   : councilList
    Created on : Aug 8, 2022, 8:52:08 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/academic/manager">Trở về</a></button>

<h1 class="text-center text-danger">Danh sách hội đồng</h1>

<div class="container-fluid">
    <button type="button" class="btn btn-primary" style="height:50px;width:200px">
        <a class="navbar-brand" style="color: white" href="<c:url value="/academic/createCouncil"/>">Thêm hội đồng</a>
    </button>
</div>
<br/>
<div>
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(count/8)}" var="i">
            <c:url value="/academic/councilList" var="c">
                <c:param value="${i}" name="page"  />
            </c:url>
            <li class="page-item"><a  class="page-link" href="${c}">${i}</a></li>
            </c:forEach>
    </ul>
</div>
<form action="">
    <div class="row">
        <div class="col-md-10">
            <input class="form-control" type="text" name="kw"  placeholder="nhập tên hội đồng"/>
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
                <th>STT</th>
                <th>Tên hội đồng</th>
                <th>Ngày tạo</th>
                <th>Hoạt động</th>  
                <th>Khoa</th>
                <th></th>


            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${council}">
                <tr class="table-success">
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.createdDate}</td>
                    <c:if test="${c.active == 1}">
                        <td>Có</td>
                    </c:if>
                    <c:if test="${c.active != 1}">
                        <td>Không</td>
                    </c:if>

<!--                    <td>${c.facultyId.name}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/academic/councilDetail/${c.id}"/>">Chi tiết</a>
                    </td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/"/>">Chấm khóa luận</a>
                    </td>-->
                    <td>${c.facultyId.name}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/academic/councilDetail/${c.id}"/>">Chi tiết</a>
                    </td>
                    <c:choose>
                        <c:when test="${c.active == 1}">
                            <td>
                                <a class="nav-link text-danger" href="<c:url value="/academic/performCouncil/${c.id}"/>">Phân công</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <a  class="nav-link disabled" href="<c:url value="/academic/performCouncil/${c.id}"/>">Phân công</a>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a class="nav-link text-danger" onclick="return ConfirmDelete();" href="<c:url value="/academic/deleteCouncil/${c.id}"/>">Xóa</a>
                    </td>

                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<br>
<br>


<script>
    function ConfirmDelete() {
        var result = confirm("Bạn có muốn xóa hội đồng hay không?");
        if (result == true) {
            alert('Xóa thành công');
            return true;
        } else {
            return false;
        }
    }
</script> 
<style>
    .disabled{
        pointer-events: none;
        cursor: default;
        color: #ccc;
    }
</style>

