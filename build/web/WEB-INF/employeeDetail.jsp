<%-- 
    Document   : employeeDetail
    Created on : 6 déc. 2018, 11:21:51
    Author     : minoflaz
--%>

<%@page import="com.employee.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <%
            Employee employee = (Employee) request.getAttribute("employee");
        %>
        <form action="" method="post" class="form-horizontal" role="form">
            <h2 class="form-signin-heading col-lg-offset-5">Employee</h2>
            <div class="col-lg-4 col-lg-offset-4">
                <p><input class="form-control" type="text" name="name" id="name" value="<% out.print(employee.getName()); %>"></p>
                <p><input class="form-control" type="text" name="firstname" id="firstname" value="<% out.print(employee.getFirstname()); %>"></p>
                <p><input class="form-control" type="text" name="houseNum" id="houseNum" value="<% out.print(employee.getHouseNum()); %><"></p>
                <p><input class="form-control" type="text" name="mobileNum" id="mobileNum" value="<% out.print(employee.getMobileNum()); %>"></p>
                <p><input class="form-control" type="text" name="proNum" id="proNum" value="<% out.print(employee.getProNum()); %>"></p>
                <p><input class="form-control" type="text" name="adress" id="adress" value="<% out.print(employee.getAdress()); %>"></p>
                <p><input class="form-control" type="text" name="postalCode" id="postalCode" value="<% out.print(employee.getPostalCode()); %>"></p>
                <p><input class="form-control" type="text" name="city" id="city" value="<% out.print(employee.getCity()); %>"></p>
                <p><input class="form-control" type="text" name="email" id="email" value="<% out.print(employee.getEmail()); %>"></p>
                <p><input class="btn btn-primary" type="submit" value="Login" ></p>
                <p>${ message }</p>
            </div>
        </form>
    </body>
</html>
