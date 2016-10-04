/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caspersfilmregister;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  <h1>Methods for connection to a DB </h1>
 * @author Casper Björk
 */
public class ConnectDB {
    
    /** 
     * <h1>Creates a connection to the DB </h1>
     * <p>This will create a connection to the DB. Can currently throw a <b>SQLexception.</b></p>
     * @return Connection to the DB.
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost/Filmregister";
        String user = "root";
        String password = "";
        Connection connection =  (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, password);
        return connection;
    }
}
