<%-- 
    Document   : header
    Created on : Aug 4, 2022, 3:43:46 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/" />">Quản Lý Khóa Luận</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>                  
        <ul class="navbar-nav me-auto">
            <c:forEach items="${cats}" var="c">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown" href="#" data-bs-toggle="dropdown">${c}</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Link</a></li>
                        <li><a class="dropdown-item" href="#">Another link</a></li>
                        <li><a class="dropdown-item" href="#">A third link</a></li>
                    </ul>
                </li>
            </c:forEach>

            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/login" />" >Đăng nhập</a>
                    </li>
                </c:when>

                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/detail" />" >
                            ${pageContext.request.userPrincipal.name}
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/logout" />" >Đăng xuất</a>
                    </li>
                </c:when>
            </c:choose>

        </ul>


    </div>
<!--        <c:url value="/" var="action" />
        <form method="get" action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Search">
            <button type="submit" class="btn btn-primary" type="button">Search</button>
        </form>-->


</div>

</nav>
