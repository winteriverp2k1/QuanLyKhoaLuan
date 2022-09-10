<%-- 
    Document   : Teacher
    Created on : Aug 31, 2022, 2:37:38 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-danger">Quản lý công việc</h1>


<div class="container md">
    <h2 class="text-center text-danger">Danh sách hội đồng bạn đang tham gia</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Tên hội đồng</th>
                <th>Vị trí trong hội đồng</th>
                <th>Ngày tạo hội đồng</th>
                <th></th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${councilPosition}">

                <tr class="table-success">
                    <td>${u.councilId.name}</</td>
                    <td>${u.positionId.name}</td>
                    <td>${u.councilId.createdDate}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/Teacher/Council/${u.councilId.id}"/>">Xem chi tiết</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="container md">
    <h2 class="text-center text-danger">Danh sách khóa luận bạn đang tham gia</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Tên khóa luận</th>
                <th>Vị trí trong khóa luận</th>
                <th>Ngày tạo khóa luận</th>
                <th></th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${thesisPosition}">

                <tr class="table-success">
                    <td>${u.thesisId.name}</</td>
                    <td>${u.thesisPosition.name}</td>
                    <td>${u.thesisId.year}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/Teacher/DetailThesis/${u.id}"/>">Chi tiết</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


