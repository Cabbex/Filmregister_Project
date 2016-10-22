/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caspersfilmregister;


import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Casper
 */
public class Insert {

    public Insert() {
    }
    
    public void InsertMovie(){
        JDialog d = new JDialog();
        d.setVisible(true);
        d.setLayout(new FlowLayout(FlowLayout.CENTER, d.getWidth(), 10));
        d.setTitle("Test Dialog");
        d.setSize(300, 400);
        
        Dimension txtD = new Dimension((d.getWidth()-10), 30);
        
        JLabel lable1 = new JLabel("Filmens namn:");
        lable1.setSize(d.getWidth(), 50);
        lable1.setVisible(true);
        
        JLabel lable2 = new JLabel("Filmens genre:");
        lable1.setSize(d.getWidth(), 50);
        lable1.setVisible(true);
        
        JTextField txtNamn = new JTextField("");
        txtNamn.setPreferredSize(new Dimension(txtD));
        txtNamn.setEditable(true);
        txtNamn.setVisible(true);
        
        JTextField txtGenre = new JTextField("");
        txtNamn.setPreferredSize(new Dimension(txtD));
        txtNamn.setEditable(true);
        txtNamn.setVisible(true);
        
        JButton btn1 = new JButton("Lägg till film");
        btn1.setPreferredSize(new Dimension(d.getWidth(), 40));
        btn1.setVisible(true);
        
        d.add(lable1);
        d.add(txtNamn);
        d.add(lable2);
        d.add(txtGenre);
        d.add(btn1);       
    }
}
