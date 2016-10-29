/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caspersfilmregister;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Casper Björk
 */
public class FormComponentFactory {

    private Dimension D = null;

    public FormComponentFactory(Dimension D) {
        this.D = D;
    }

    public JLabel CreateLable(JLabel variName, String labletxt) {
        variName = new JLabel(labletxt);
        variName.setPreferredSize(D);
        variName.setVisible(true);
        return variName;
    }

    public JTextField CreateTextField(JTextField variName) {
        variName = new JTextField("");
        variName.setPreferredSize(D);
        variName.setEditable(true);
        variName.setVisible(true);
        return variName;
    }

    public JComboBox CreateComboBox(JComboBox variName, ArrayList DataList) {
        variName = new JComboBox(DataList.toArray());
        variName.setPreferredSize(D);
        variName.setVisible(true);
        return variName;
    }

}
