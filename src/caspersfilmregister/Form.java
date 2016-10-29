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

    JDialog d = new JDialog();
    JTextField txtNamn = null;
    JTextField txtSläpptes = null;
    JComboBox CBGenre = null;
    JComboBox CBBetyg = null;
    JComboBox CBRegissor = null;

    public Form() {
    }

    /**
     * <h1>Creates a form window for insertion of movies</h1>
     * <p>
     * The window contains input of name,date of release,genre,director and
     * rating from 0 to 10</p>
     */
    public void CreateMovieForm() {
        Dimension txtD = new Dimension(290, 30);
        FormComponentFactory FCF = new FormComponentFactory(txtD);
        String[] betygNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayList totGenre = new ArrayList();
        ArrayList totRegissor = new ArrayList();

        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
        d.setTitle("Test Dialog");
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
        txtNamn = FCF.CreateTextField(txtNamn);
        txtSläpptes = FCF.CreateTextField(txtSläpptes);

        try {
            Connection connect = ConnectDB.getConnection();
            Statement stmt = connect.createStatement();
            ResultSet data = stmt.executeQuery("SELECT genre.Namn_Genre FROM genre");
            while (data.next()) {
                totGenre.add(data.getString("Namn_Genre"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 1# " + e);
        }

        CBGenre = FCF.CreateComboBox(CBGenre, totGenre);

        CBBetyg = new JComboBox(betygNum);
        CBBetyg.setPreferredSize(txtD);
        CBBetyg.setVisible(true);

        try {
            Connection connect2 = ConnectDB.getConnection();
            Statement stmt2 = connect2.createStatement();
            ResultSet data2 = stmt2.executeQuery("SELECT regissor_Namn FROM regissor");
            while (data2.next()) {
                totRegissor.add(data2.getString("regissor_Namn"));
            }
        } catch (Exception e) {
            System.out.println("Dropdown meny 2# " + e);
        }

        CBRegissor = FCF.CreateComboBox(CBRegissor, totRegissor);

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
        d.add(lbl1);
        d.add(txtNamn);
        d.add(lbl5);
        d.add(txtSläpptes);
        d.add(lbl2);
        d.add(CBGenre);
        d.add(lbl3);
        d.add(CBBetyg);
        d.add(lbl4);
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
            prepStmt.setInt(2, CBBetyg.getSelectedIndex() + 1);
            prepStmt.setInt(3, Integer.parseInt(txtSläpptes.getText()));
            prepStmt.setInt(4, CBGenre.getSelectedIndex() + 1);
            prepStmt.setInt(5, CBRegissor.getSelectedIndex() + 1);
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
}
