/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Models;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class ValidConstrainModel {
    JTextField jTextField;
    JPasswordField jPasswordField;
    JTextArea jTextArea;
    JLabel jlabel;
    String alert;

    public ValidConstrainModel(JTextField jTextField, String alert) {
        this.jTextField = jTextField;
        this.alert = alert;
    }

    public ValidConstrainModel(JPasswordField jPasswordField, String alert) {
        this.jPasswordField = jPasswordField;
        this.alert = alert;
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public ValidConstrainModel(JLabel label, String alert) {
        this.jlabel = label;
        this.alert = alert;
    }

    public ValidConstrainModel(JTextArea jTextArea, String alert) {
        this.jTextArea = jTextArea;
        this.alert = alert;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JLabel getLabel() {
        return jlabel;
    }

    public void setLabel(JLabel label) {
        this.jlabel = label;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

    public void setjPasswordField(JPasswordField jPasswordField) {
        this.jPasswordField = jPasswordField;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }
    
    
    
}


