<%-- 
    Document   : employeeList
    Created on : Nov 28, 2018, 6:19:50 PM
    Author     : alexis
--%>

<%@page import="com.employee.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.employee.model.User"%>
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
        <title>Employees</title>
    </head>
    <body>  
        <%
            ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("employees");
        %>
        <h2>Employees</h2>
        <table class="table table-striped">
            <thead>
              <tr> 
                <th scope="col">Name</th>
                <th scope="col">FirstName</th>
                <th scope="col">HouseNum</th>
                <th scope="col">MobileNum</th>
                <th scope="col">ProNum</th>
                <th scope="col">Adress</th>
                <th scope="col">Email</th>
              </tr>
            </thead>
            <tbody>
                <%
                int i;
                for(i=0;i<employees.size();i++) {%>
                    <tr> 
                        <td><% out.print(employees.get(i).getName()); %></td>
                        <td><% out.print(employees.get(i).getFirstname()); %></td>
                        <td><% out.print(employees.get(i).getHouseNum()); %></td>
                        <td><% out.print(employees.get(i).getMobileNum()); %></td>
                        <td><% out.print(employees.get(i).getProNum()); %></td>
                        <td><% out.print(employees.get(i).getAdress() + ", " + employees.get(i).getCity() + " " + employees.get(i).getPostalCode());%></td>
                        <td><% out.print(employees.get(i).getEmail()); %></td>
                    </tr>
                <%}%>   
            </tbody>
        </table>
            
        <a href="/GestionEmployeeProject/?action=disconnect">Disconnect</a>
    </body>
</html>
