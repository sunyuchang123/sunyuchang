/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yucha
 */
public class DatabaseConnector {

    private static Connection connection;
    private static String URL = "jdbc:derby://localhost:1527/sunyuchangdb";
    private static final String USER_NAME = "sunyuchang"; //your DB username
    private static final String PASSWORD = "20126270"; //your DB password

    public DatabaseConnector() {
        establishConnection();
    }

    public static void main(String[] args) {
        DatabaseConnector rpgDb = new DatabaseConnector();
        System.out.println(rpgDb.getConnection());
    }

    public Connection getConnection() {
        return this.connection;
    }

    //Establish connection
    public void establishConnection() {
        //Establish a connection to Database
         if (this.connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        
    }

    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.connection;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.connection;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
    
