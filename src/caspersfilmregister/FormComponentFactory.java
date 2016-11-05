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
 * <h1>A factory to define form Objects </h1>
 * <p>This factory is designed to short down the code and make it easier to navigate. All the methods define something that is used in a form. 
 * The size of the components are set during construction </p>
 * @author Casper Björk
 */
public class FormComponentFactory {

    private Dimension D = null;

    /**
     * <h1>Construction of FCF </h1>
     * @param D
     */
    public FormComponentFactory(Dimension D) {
        this.D = D;
    }

    /**
     * <h1>Defines a label object</h1>
     * <p>Defines the JLabel object and creates a label with the text sent in to the method </p>
     * @param variName
     * @param labletxt
     * @return a defiend JLabel object
     */
    public JLabel CreateLable(JLabel variName, String labletxt) {
        variName = new JLabel(labletxt);
        variName.setPreferredSize(D);
        variName.setVisible(true);
        return variName;
    }

    /**
     * <h1>Defines a textfield object </h1>
     * <p>Defines the JTextField and sets the right size </p>
     * @param variName
     * @return a defiend JTextField Object
     */
    public JTextField CreateTextField(JTextField variName) {
        variName = new JTextField("");
        variName.setPreferredSize(D);
        variName.setEditable(true);
        variName.setVisible(true);
        return variName;
    }

    /**
     * <h1>Defines a Combobox object </h1>
     * <p>Defines the JComboBox and set the right data in it with the ArrayList </p>
     * @param variName
     * @param DataList
     * @return a defiend JComboBox Object.
     */
    public JComboBox CreateComboBox(JComboBox variName, ArrayList DataList) {
        variName = new JComboBox(DataList.toArray());
        variName.setPreferredSize(D);
        variName.setVisible(true);
        return variName;
    }

}
