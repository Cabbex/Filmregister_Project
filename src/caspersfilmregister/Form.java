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
 * <p>
 * This is a class for the creation of the form for the insertion of data. It
 * constructs a dialog window where you can put in data.
 * </p>
 *
 * @author Casper Björk
 */
public class Form {

    JDialog d = null;
    JTextField txt1 = null;
    JTextField txt2 = null;
    JComboBox CB1 = null;
    JComboBox CB2 = null;
    JComboBox CB3 = null;

    public Form() {
    }

    /**
     * <h1>Creates a form window for insertion of movies</h1>
     * <p>
     * The window contains input of name,date of release,genre,director and
     * rating from 0 to 10</p>
     */
    public void createMovieForm() {
        d = new JDialog();
        Dimension txtD = new Dimension(290, 30);
        FormComponentFactory FCF = new FormComponentFactory(txtD);
        String[] betygNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayList totGenre = new ArrayList();
        ArrayList totRegissor = new ArrayList();

        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
        d.setTitle("Lägg till Film");
        d.setSize(350, 487);
        d.setLocation(150, 150);

        //Creating all labels
        JLabel lbl1 = null;
        lbl1 = FCF.CreateLable(lbl1, "Filmens namn:");

        JLabel lbl2 = null;
        lbl2 = FCF.CreateLable(lbl2, "Filmens genre:");

        JLabel lbl3 = null;
        lbl3 = FCF.CreateLable(lbl3, "Filmens betyg:");

        JLabel lbl4 = null;
        lbl4 = FCF.CreateLable(lbl4, "Filmens regissör");

        JLabel lbl5 = null;
        lbl5 = FCF.CreateLable(lbl5, "Filmen släpptes:");
        //End lables
        //defining all txtinputs
        txt1 = FCF.CreateTextField(txt1);
        txt2 = FCF.CreateTextField(txt2);

        try {
            Connection connect = ConnectDBFactory.getConnection();
            Statement stmt = connect.createStatement();
            ResultSet data = stmt.executeQuery("SELECT genre.Namn_Genre FROM genre");
            while (data.next()) {
                totGenre.add(data.getString("Namn_Genre"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 1# " + e);
        }

        CB1 = FCF.CreateComboBox(CB1, totGenre);

        CB2 = new JComboBox(betygNum);
        CB2.setPreferredSize(txtD);
        CB2.setVisible(true);

        try {
            Connection connect2 = ConnectDBFactory.getConnection();
            Statement stmt2 = connect2.createStatement();
            ResultSet data2 = stmt2.executeQuery("SELECT regissor_Namn FROM regissor");
            while (data2.next()) {
                totRegissor.add(data2.getString("regissor_Namn"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 2# " + e);
        }

        CB3 = FCF.CreateComboBox(CB3, totRegissor);

        //Slut input
        //Skapar alla Buttons här
        JButton btn1 = new JButton("Lägg till film");
        btn1.setPreferredSize(new Dimension(d.getWidth(), 40));
        btn1.setVisible(true);
        btn1.setActionCommand("Insert");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertMovie();
                System.out.println("IT WORKS!!!");
                totGenre.clear();
                totRegissor.clear();
                d.dispose();
            }
        });

        //Slut Buttons
        //Lägger till alla här
        d.add(lbl1);
        d.add(txt1);
        d.add(lbl5);
        d.add(txt2);
        d.add(lbl2);
        d.add(CB1);
        d.add(lbl3);
        d.add(CB2);
        d.add(lbl4);
        d.add(CB3);
        d.add(btn1);

    }
    
    public void createGenreForm(){
        d = new JDialog();
        Dimension txtD = new Dimension(290, 30);
        FormComponentFactory FCF = new FormComponentFactory(txtD);
        
        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
        d.setTitle("Lägg till Genre");
        d.setSize(350, 253);
        d.setLocation(150, 150);
        
        JLabel lbl1 = null;
        lbl1 = FCF.CreateLable(lbl1, "Genres namn:");
        
        JLabel lbl2 = null;
        lbl2 = FCF.CreateLable(lbl2, "Genres beskrivning max 75 bokstäver:");
        
        txt1 = FCF.CreateTextField(txt1);
        txt2 = FCF.CreateTextField(txt2);
        
        JButton btn2 = new JButton("Lägg till Genre");
        btn2.setPreferredSize(new Dimension(290, 40));
        btn2.setVisible(true);
        btn2.setActionCommand("Insert");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertGenre();
                System.out.println("IT WORKS!!!");
                d.dispose();
            }
        });        
        
        d.add(lbl1);
        d.add(txt1);
        d.add(lbl2);
        d.add(txt2);
        d.add(btn2);
    }
    public void createRegissorForm(){
        d = new JDialog();
        Dimension txtD = new Dimension(290, 30);
        FormComponentFactory FCF = new FormComponentFactory(txtD);
        
        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
        d.setTitle("Lägg till Genre");
        d.setSize(350, 253);
        d.setLocation(150, 150);
        
        JLabel lbl1 = null;
        lbl1 = FCF.CreateLable(lbl1, "Regissörens namn:");
        
        JLabel lbl2 = null;
        lbl2 = FCF.CreateLable(lbl2, "Regissörens födelse år endast årtal:");
        
        txt1 = FCF.CreateTextField(txt1);
        txt2 = FCF.CreateTextField(txt2);
        
        JButton btn3 = new JButton("Lägg till Regissör");
        btn3.setPreferredSize(new Dimension(290, 40));
        btn3.setVisible(true);
        btn3.setActionCommand("Insert");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertRegissor();
                System.out.println("IT WORKS!!!");
                d.dispose();
            }
        });        
        
        d.add(lbl1);
        d.add(txt1);
        d.add(lbl2);
        d.add(txt2);
        d.add(btn3);
    }
    
    public void clearGUI(){
        txt1 = null;
        txt2 = null;
        CB1 = null;
        CB2 = null;
        CB3 = null;
        d = null;

    }

    private void insertMovie() {
        Connection connect;
        PreparedStatement prepStmt = null;
        try {
            connect = ConnectDBFactory.getConnection();
            prepStmt = connect.prepareStatement("INSERT INTO `film`(`ID`, `Titel`, `Betyg`, `Släpptes`, `Genre`, `Regissor`) VALUES (null,?,?,?,?,?)");
            prepStmt.setString(1, txt1.getText());
            prepStmt.setInt(2, CB2.getSelectedIndex() + 1);
            prepStmt.setInt(3, Integer.parseInt(txt2.getText()));
            prepStmt.setInt(4, CB1.getSelectedIndex() + 1);
            prepStmt.setInt(5, CB3.getSelectedIndex() + 1);
            prepStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Insert " + ex);
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
    private void insertGenre() {
        Connection connect;
        PreparedStatement prepStmt = null;
        try {
            connect = ConnectDBFactory.getConnection();
            prepStmt = connect.prepareStatement("INSERT INTO `genre`(`Genre_id`, `Namn_Genre`, `Beskrivning`) VALUES (null,?,?)");
            prepStmt.setString(1, txt1.getText());
            prepStmt.setString(2, txt2.getText());
            prepStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Genre " + ex);
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
    private void insertRegissor() {
        Connection connect;
        PreparedStatement prepStmt = null;
        try {
            connect = ConnectDBFactory.getConnection();
            prepStmt = connect.prepareStatement("INSERT INTO `regissor`(`regissor_id`, `regissor_Namn`, `Föddes`) VALUES (null,?,?)");
            prepStmt.setString(1, txt1.getText());
            prepStmt.setInt(2, Integer.parseInt(txt2.getText()));
            prepStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Genre " + ex);
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
