<%-- 
    Document   : detailThesis
    Created on : Sep 4, 2022, 2:08:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<h1 class="text-center text-danger">Chi tiết khóa luận</h1>


<div class="container md">
    <table class="table">
        <thead>
            <tr>
                <th>Họ và Tên</th>
                <th>Chức vụ</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${detailthesis}">
                <tr class="table-success">
                    <td>${u.userId.fullname}</td>
                    <td>${u.thesisPosition.name}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
     <c:forEach var="u" items="${idcouncilpos}">
                <tr class="table-success">
                    <td>${u.id}</td>
                    

                </tr>
    </c:forEach>
</div>