/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caspersfilmregister;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <h1>A class to delete data in the database </h1>
 * <p>This class contains a method to remove data from the database.</p>
 * @author Casper
 */
public class Delete {

    /**
     *  <h1>Basic construction, no value needed. </h1>
     */
    public Delete() {
    }
    
    /**
     * <h1>Removes a movie from the database </h1>
     * <p>Takes in the ID of the movie and then remove it from the database </p>
     * @param ID
     */
    public void RemoveData(int ID){
        Connection connect;
        PreparedStatement prepStmt = null;
        try {
            connect = ConnectDBFactory.getConnection();
            prepStmt = connect.prepareStatement("DELETE FROM `film` WHERE film.ID = ?");
            prepStmt.setInt(1, ID);
            prepStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Delete function " + ex);
        } finally {
            if (prepStmt != null) {
                try {
                    prepStmt.close();
                } catch (SQLException ex) {
                    System.out.println("Close prepStmt " + ex);
                }
            }
        }
    }
}
