/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import com.employee.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.DatabaseConnexion;


/**
 *
 * @author minoflaz
 */
public class EmployeeRepository {
    String url = "jdbc:mysql://gestionemployee.cfcrtek2s05x.eu-west-3.rds.amazonaws.com:3306/gestionemployee";
    String utilisateur = "minoflaz";
    String motDePasse = DatabaseConnexion.pass;
    Connection connexion = null;
    Statement statement = null;
    ResultSet result = null;
    
    public EmployeeRepository() {
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
            } 
            catch ( SQLException e ) {
            }
    }
    
    
    public int addEmployee(Employee employee) throws SQLException {
         statement = connexion.createStatement();
         
         int statut = statement.executeUpdate(employee.getInsertQuery());
         
         this.endResult();
         
         return 1;
    }
    
    public Employee getEmployee(int id) throws SQLException {
        statement = connexion.createStatement();
        
        ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYES WHERE ID = " + id);
        Employee employee = new Employee();
        
        if (result.next()) {
            employee.setId(result.getInt(1));
            employee.setName(result.getString(2));
            employee.setFirstname(result.getString(3));
            employee.setHouseNum(result.getString(4));
            employee.setMobileNum(result.getString(5));
            employee.setProNum(result.getString(6));
            employee.setAdress(result.getString(7));
            employee.setCity(result.getString(8));
            employee.setPostalCode(result.getString(9));
            employee.setEmail(result.getString(10));
        }
        
        this.endResult();
        
        return employee;
    }
    
    public ArrayList<Employee> getAllEmployees() throws SQLException {
        statement = connexion.createStatement();
        
        ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYES");
        ArrayList<Employee> allEmployees = new ArrayList<>();
        
        while(result.next()) {
            allEmployees.add(this.getEmployee(result.getInt(1)));
        }
        
        this.endResult();
        
        return allEmployees;
    }
    
    public int modifyEmployee(Employee employeeToModify) throws SQLException {
        Employee employee = this.getEmployee(employeeToModify.getId());
        
        statement = connexion.createStatement();
        
        int statut = statement.executeUpdate(employee.getUpdateQuery());
         
        this.endResult();
         
        return 1; 
    }
    
    private void endResult() {
         if ( result != null ) {
            try {
                result.close();
            } catch ( SQLException ignore ) {
            }
        }
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            }
        }
    }
}
