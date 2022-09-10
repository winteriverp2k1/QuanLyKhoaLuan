<%-- 
    Document   : councilDetail
    Created on : Aug 10, 2022, 4:38:02 PM
    Author     : Admin
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!--<h1 class="text-center text-danger">Chi tiết hội đồng</h1>-->

<!--<div class="row">
    <div class="col-md-12">
        <h3>Tên hội đồng: ${council.name}</h3>
        <h4>Thời gian bắt đầu thực hiện: ${council.createdDate}</h4>  
        <h4>Tên khoa: ${council.facultyId.name}</h4>
    </div>
    <br/>
    <div class="col-md-12">
         <h2 id="name">Họ tên thành viên 1:</h2>
         <h2 id="name">Họ tên thành viên 2:</h2>
         <h2 id="name">Họ tên thành viên 3:</h2>
         <h2 id="name">Họ tên thành viên 4:</h2>
         <h2 id="name">Họ tên thành viên 5:</h2>
    </div>
</div>-->

<%-- 
    Document   : councilDetail
    Created on : Aug 10, 2022, 4:38:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h1 class="text-center text-danger">Chi tiết hội đồng</h1>

<div class="row">
    <div class="col-md-12">
        <h3>Tên hội đồng: ${council.name}</h3>
        <h4>Thời gian bắt đầu thực hiện: ${council.createdDate}</h4>  
        <h4>Tên khoa: ${council.facultyId.name}</h4>
    </div>
    <br/>
    <h1>Danh sách thành viên</h1>
    <br/>
    <div class="col-md-12">
        <c:forEach var="cms" items="${mem1}"> 
            <c:out value="Chủ tịch: ${cms.userId.fullname}" ></c:out>
        </c:forEach>
        <br/>
        <c:forEach var="cms" items="${mem2}"> 
            <c:out value="Thư ký: ${cms.userId.fullname}" ></c:out>
        </c:forEach>
        <br/>
        <c:forEach var="cms" items="${mem3}"> 
            <c:out value="Giảng viên phản biện: ${cms.userId.fullname}" ></c:out>
        </c:forEach>
        <br/>
        <c:forEach var="cms" items="${mem4}"> 
            <c:if test="${mem4.size() != null}">
                <c:out value="Thành viên: ${cms.userId.fullname}" ></c:out>
            </c:if>         
        </c:forEach>
        <br/>
        <c:forEach var="cms" items="${mem5}"> 
            <c:if test="${mem5.size() != null}">
                <c:out value="Thành viên: ${cms.userId.fullname}" ></c:out>
            </c:if>         
        </c:forEach>
    </div>
</div>