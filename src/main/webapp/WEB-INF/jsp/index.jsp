<%--
    Document   : index
    Created on : Aug 3, 2022, 1:27:22 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<sec:authorize access="hasRole('ROLE_ADMIN')"> 
    <link href="<c:url value="/css/index.css"/>" rel="stylesheet" />

    <div class="parent">     
        <div class="child"> 
            <h2 class="text-center">Chào ${pageContext.request.userPrincipal.name}! Bạn là người quản trị</h2>
            <div class="center">
                <button type="button" class="btn btn-success">
                    <a style="color: black" href="<c:url value="/admin/adminPage" />">Click để vào trang quản trị</a>
                </button>
            </div>           
        </div>
    </div>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_GiaoVu')"> 
    <link href="<c:url value="/css/index.css"/>" rel="stylesheet" />

    <div class="parent">     
        <div class="child"> 
            <h2 class="text-center">Chào ${pageContext.request.userPrincipal.name}!Bạn là Giáo Vụ</h2>
            <div class="center">
                <button type="button" class="btn btn-success">
                    <a style="color: black" href="<c:url value="/academic/manager" />">Click để vào trang giáo vụ</a>
                </button>
            </div>           
        </div>
    </div>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_GiangVien')"> 
    <link href="<c:url value="/css/index.css"/>" rel="stylesheet" />

    <div class="parent">     
        <div class="child"> 
            <h2 class="text-center">Chào ${pageContext.request.userPrincipal.name}!Bạn là Giảng viên</h2>
            <div class="center">
                <button type="button" class="btn btn-success">
                    <a style="color: black" href="<c:url value="/Teacher/Manager/${currentUser.id}" />">Click để vào trang Giảng viên</a>
                </button>
            </div>           
        </div>
    </div>
</sec:authorize>

<br>
<br>
