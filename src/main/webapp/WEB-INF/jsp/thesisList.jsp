<%-- 
    Document   : thesisList
    Created on : Aug 8, 2022, 9:01:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/academic/manager">Trở về</a></button>


<!--<h1 class="text-center text-danger">Danh sách khóa luận</h1>
<div class="container-fluid">
    <button type="button" class="btn btn-primary" style="height:50px;width:200px">
        <a class="navbar-brand" style="color: white" href="<c:url value="/academic/createThesis"/>">Thêm Khóa Luận</a>
    </button>
</div>
<br/>
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
<br>
<div class="container md">
    <table class="table">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên khóa luận</th>
                <th>Điểm</th>
                <th></th>


            </tr>
        </thead>
        <tbody>
            <c:forEach var="t" items="${thesis}">
                <tr class="table-success">
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.totalScore}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/academic/thesisDetail/${t.id}"/>">Chi tiết</a>
                    </td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/academic/performThesis/${t.id}"/>">Phân công thực hiện</a>
                    </td>

                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<br>
<br>-->

<h1 class="text-center text-danger">Danh sách khóa luận</h1>
<div class="container-fluid">
    <button type="button" class="btn btn-primary" style="height:50px;width:200px">
        <a class="navbar-brand" style="color: red" href="<c:url value="/academic/createThesis"/>">Thêm Khóa Luận</a>
    </button>
</div>
<br/>
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
<div>
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(count/8)}" var="i">
            <c:url value="/academic/thesisList" var="c">
                <c:param value="${i}" name="page"  />
            </c:url>
            <li class="page-item"><a  class="page-link" href="${c}">${i}</a></li>
            </c:forEach>
    </ul>
</div>
<br>
<div class="container md">
    <table class="table">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên khóa luận</th>
                <th>Điểm</th>
                <th></th>


            </tr>
        </thead>
        <tbody>
            <c:forEach var="t" items="${thesis}">
                <tr class="table-success">
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.totalScore}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/academic/thesisDetail/${t.id}"/>">Chi tiết</a>
                    </td>
                    <c:choose>
                        <c:when test="${t.totalScore != null}">
                            <td>
                                <a class="nav-link disabled" href="<c:url value="/academic/performThesis/${t.id}"/>">Phân công thực hiện</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <a class="nav-link text-danger" href="<c:url value="/academic/performThesis/${t.id}"/>">Phân công thực hiện</a>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a class="nav-link text-danger" onclick="return ConfirmDelete();" href="<c:url value="/academic/deleteThesis/${t.id}"/>">Xóa khóa luận</a>
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
        var result = confirm("Bạn có muốn xóa khóa luận hay không?");
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


