/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author minoflaz
 */
public class DatabaseConnexion {
    String url = "jdbc:derby://localhost:1527/GestionEmployee";
    String utilisateur = "GestionEmployee";
    String motDePasse = "GestionEmployee";
    Connection connexion = null;
    Statement statement = null;
    ResultSet result = null;
    
    public DatabaseConnexion() {
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } 
        catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
        } 
    }
    
    public ResultSet query(String sql) throws SQLException {
        statement = connexion.createStatement();
        ResultSet result = null;
        
        if ( statement != null ) {
           result =  statement.executeQuery(sql);
        }
        
        return result;
    }
    
    public int update(String sql) throws SQLException {
        int statut = 0;
        
        if ( statement != null ) {
           statut =  statement.executeUpdate(sql);
        }
        
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            }
        }
        
        return statut;
    } 
    
    public void close() {
        if ( connexion != null ) {
            try {
                connexion.close();
                
            } catch ( SQLException ignore ) {
            }
        }
    }
}
