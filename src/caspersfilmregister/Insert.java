
package caspersfilmregister;


import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
/**
 * <h1>Creates a form in a dialog</h1>
 * <p>This is a class for the creation of the form for the insertion of data.
 * It constructs a dialog window where you can put in data.
 * </p>
 * @author Casper Björk
 */
public class Insert {
    JDialog d = new JDialog();
    JTextField txtNamn = new JTextField("");
    JTextField txtSläpptes = new JTextField("");
    JComboBox CBGenre;
    JComboBox CBBetyg;
    JComboBox CBRegissor;
    public Insert() {
    }
    
    
    /**
     * <h1>Creates a form window for insertion of movies</h1>
     * <p>The window contains input of name,date of release,genre,director and rating from 0 to 10</p>
     */
    public void InsertMovie(){
        String[] betygNum = {"1","2","3","4","5","6","7","8","9","10"};
        ArrayList totGenre = new ArrayList();
        ArrayList totRegissor = new ArrayList();
        
        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, d.getWidth(), 10));
        d.setTitle("Test Dialog");
        d.setSize(300, 415);
        d.setLocation(150, 150);
        
        Dimension txtD = new Dimension((d.getWidth()-10), 30);
        
        //Creating all labels
        
        JLabel lable1 = new JLabel("Filmens namn:");
        lable1.setSize(d.getWidth(), 50);
        lable1.setVisible(true);
        
        JLabel lable2 = new JLabel("Filmens genre:");
        lable2.setSize(d.getWidth(), 50);
        lable2.setVisible(true);
        
        JLabel lable3 = new JLabel("Filmens betyg:");
        lable3.setSize(d.getWidth(), 50);
        lable3.setVisible(true);
        
        JLabel lable4 = new JLabel("Filmens regissor:");
        lable4.setSize(d.getWidth(), 50);
        lable4.setVisible(true);
        
        JLabel lable5 = new JLabel("Filmen släpptes:");
        lable5.setSize(d.getWidth(), 50);
        lable5.setVisible(true);
        
        //End lables
        
        //defining all txtinputs
        
        txtNamn.setPreferredSize(txtD);
        txtNamn.setEditable(true);
        txtNamn.setVisible(true);
        
        txtSläpptes.setPreferredSize(txtD);
        txtSläpptes.setEditable(true);
        txtSläpptes.setVisible(true);
        
        try {
            Connection connect = ConnectDB.getConnection();
            Statement stmt = connect.createStatement();
            ResultSet data = stmt.executeQuery("SELECT genre.Namn_Genre FROM genre");
            while(data.next()){
                totGenre.add(data.getString("Namn_Genre"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 1# "+ e);
        }
        
        CBGenre = new JComboBox(totGenre.toArray());
        CBGenre.setPreferredSize(txtD);
        CBGenre.setVisible(true);
        
        CBBetyg = new JComboBox(betygNum);
        CBBetyg.setPreferredSize(txtD);
        CBBetyg.setVisible(true);
        
        try {
            Connection connect2 = ConnectDB.getConnection();
            Statement stmt2 = connect2.createStatement();
            ResultSet data2 = stmt2.executeQuery("SELECT regissor_Namn FROM regissor");
            while(data2.next()){
                totRegissor.add(data2.getString("regissor_Namn"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 2# "+ e);
        }
        
        
        CBRegissor = new JComboBox(totRegissor.toArray());
        CBRegissor.setPreferredSize(txtD);
        CBRegissor.setVisible(true);
        
        //Slut input
        
        //Skapar alla Buttons här
        JButton btn1 = new JButton("Lägg till film");
        btn1.setPreferredSize(new Dimension(d.getWidth(), 40));
        btn1.setVisible(true);
        btn1.setActionCommand("Insert");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertmovie();
                System.out.println("IT WORKS!!!");
                totGenre.clear();
                totRegissor.clear();
            }
        });
        
        //Slut Buttons
        
        //Lägger till alla här
        d.add(lable1);
        d.add(txtNamn);
        d.add(lable5);
        d.add(txtSläpptes);
        d.add(lable2);
        d.add(CBGenre);
        d.add(lable3);
        d.add(CBBetyg);
        d.add(lable4);
        d.add(CBRegissor);
        d.add(btn1);    
        
    }

    private void insertmovie() {
        Connection connect;
        PreparedStatement prepStmt = null;
        try {
            connect = ConnectDB.getConnection();
            prepStmt = connect.prepareStatement("INSERT INTO `film`(`ID`, `Titel`, `Betyg`, `Släpptes`, `Genre`, `Regissor`) VALUES (null,?,?,?,?,?)");
            prepStmt.setString(1, txtNamn.getText());
            prepStmt.setInt(2, CBBetyg.getSelectedIndex()+1);
            prepStmt.setInt(3, Integer.parseInt(txtSläpptes.getText()));
            prepStmt.setInt(4, CBGenre.getSelectedIndex()+1);
            prepStmt.setInt(5, CBRegissor.getSelectedIndex()+1);
            prepStmt.executeUpdate();
           
        } catch (Exception ex) {
            System.out.println("Insert "+ex);
        } finally {
            if (prepStmt != null) {
                try {
                    prepStmt.close();
                } catch (SQLException ex) {
                    System.out.println("Close prepStmt "+ex);
                }
            }

        }
    }       
 }
