<%-- 
    Document   : base
    Created on : Aug 4, 2022, 3:43:19 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" type="image/png" href="https://codetot.net/wp-content/uploads/2017/11/favicon-example-generator.png?fbclid=IwAR0NjD16Se0mNl7koScOXsezZXml14llFj-IJIjPn2j3t5nXp0syHj7froA"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <title>
            <tiles:insertAttribute name="title" />
        </title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        
        
        <div class="container">
             <tiles:insertAttribute name="content" />
        </div>
       
        
        <tiles:insertAttribute name="footer" />
    </body>
</html>
