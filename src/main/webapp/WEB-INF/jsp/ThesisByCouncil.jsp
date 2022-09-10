<%-- 
    Document   : ThesisByCouncil
    Created on : Sep 1, 2022, 1:57:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container md">
    <h2 class="text-center text-danger">Danh sách khóa luận trong hội đồng</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Tên khóa luận</th>
                <th>Khoa</th>
                <th>Năm</th>
                <th></th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${thesisbycouncil}">

                <tr class="table-success">
                   
                    <td>${u.name}</</td>
                    <td>${u.year}</td>
                    <td>${u.facultyId.name}</td>
                    <td>
                        <a class="nav-link text-danger" href="<c:url value="/Teacher/score/${u.id}"/>">Chấm điểm</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
