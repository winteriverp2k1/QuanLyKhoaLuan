<%-- 
    Document   : statistical
    Created on : Aug 10, 2022, 4:00:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<button type="button" class="btn btn-dark"><a style="color: white" href="/QuanLyKhoaLuan/admin/adminPage">Trở về</a></button>

<h1 class="text-center text-danger">Thống kê</h1>
<br>
<br>
<br>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <h3 class="text-center text-danger">Tổng số lượng sinh viên từng khoa</h3>
        <table class="table">
            <tr>
                <th class="text-center">Mã Khoa</th>
                <th class="text-center">Tên Khoa</th>
                <th class="text-center">Số lượng sinh viên</th>
            </tr>
            <c:forEach items="${userFaculty}" var="s">
                <tr>
                    <td class="text-center">${s[0]}</td>
                    <td class="text-center">${s[1]}</td>
                    <td class="text-center">${s[2]}</td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="col-md-6 col-xs-12">
        <h3 class="text-center text-danger">Số lượng sinh viên tham gia khóa luận</h3>
        <table class="table">
            <tr>
                <th class="text-center">Mã Khoa</th>
                <th class="text-center">Tên Khoa</th>
                <th class="text-center">Số lượng</th>
            </tr>
            <c:forEach items="${userThesis}" var="s">
                <tr>
                    <td class="text-center">${s[0]}</td>
                    <td class="text-center">${s[1]}</td>
                    <td class="text-center">${s[2]}</td>    
                </tr>
            </c:forEach>

        </table>
        <!--<canvas id="myChart"></canvas>-->
    </div>
</div>
<br>



<div class="row" style="width: 90%; height: 50%; margin: auto">
    <div class="col-md-6 col-xs-12">
        <h3 class="text-center text-danger">Tần suất tham gia</h3>
        <p class="text-center text-danger">(SLSV tham gia khóa luận của khoa / SLSV trong khoa) * 100%</p>

        <table class="table">
            <tr>
                <th class="text-center">Tên Khoa</th>
                <th class="text-center">Tần suất(%)</th>
            </tr>
            <tr>
                <td class="text-center">
                    <c:forEach items="${userFaculty}" var="s">           
                        <c:forEach items="${userThesis}" var="u">
                            <c:if test="${s[0] == u[0]}">
                                <p>${u[1]}</p>  
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>
                <td class="text-center">
                    <c:forEach items="${userFaculty}" var="s">           
                        <c:forEach items="${userThesis}" var="u">
                            <c:if test="${s[0] == u[0]}">
                                <p>${(u[2] / s[2]) * 100}</p>  
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>

            </tr>

        </table>
    </div>
</div>
<br>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script src="<c:url value="/js/stats.js" />"></script>

<script>

    window.onload = function () {
        let data = [];
        let labels = [];

        let data2 = [];
        let labels2 = [];

    <c:forEach items="${stats}" var="c">
        data.push(${c[2]});
        labels.push('$${c[1]}');
    </c:forEach>

    <c:forEach items="${yearStats}" var="s">
        data2.push(${s[2]});
        labels2.push('$${s[1]}');
    </c:forEach>

        facultyStats(labels, data);

        YearStats(labels2, data2);
    }
</script>


<br>
<br>
<br>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <h3 class="text-center text-danger">Thống kế điểm khoá luận qua từng năm</h3>
        <table class="table">
            <tr>
                <th class="text-center">Khoa</th>
                <th class="text-center">Tên khóa luận</th>
                <th class="text-center">Điểm tổng</th>
                <th class="text-center">Năm</th>
            </tr>
            <c:forEach items="${yearStats}" var="c">
                <tr>
                    <td class="text-center">${c[0]}</td>
                    <td class="text-center">${c[1]}</td>
                    <td class="text-center">${c[2]}</td>
                    <td class="text-center">${c[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="col-md-6 col-xs-12">
        <c:url value="/admin/statistical" var="action" />
        <form action="${action}">
            <div class="mb-3">
                <input type="number" class="form-control" placeholder="Nhập năm..." name="year">
            </div>
            <button type="submit" class="btn btn-primary">Lọc dữ liệu</button>
        </form>
        <canvas id="myChart2"></canvas>
    </div>
</div>




