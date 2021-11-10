/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Services;

import BUS.Models.ValidConstrainModel;

public class ValidateService {
    public static boolean isEmpty(ValidConstrainModel... arguments) {
        for (ValidConstrainModel argument : arguments) {
            if (argument.getjTextField() != null) {
                if (argument.getjTextField().getText().trim().isEmpty()) {
                    argument.getjTextField().requestFocus();
                    MessageService.alert(null, "Bạn chưa nhập " + argument.getAlert());
                    return true;
                }
            } else if (argument.getjPasswordField() != null) {
                if (argument.getjPasswordField().getText().trim().isEmpty()) {
                    argument.getjPasswordField().requestFocus();
                    MessageService.alert(null, "Bạn chưa nhập " + argument.getAlert());
                    return true;
                }
            } else if (argument.getLabel() != null) {
                if (null == argument.getLabel().getToolTipText()) {
                    argument.getLabel().requestFocus();
                    MessageService.alert(null, "Bạn chưa chọn " + argument.getAlert());
                    return true;
                }
            } else if (argument.getjTextArea() != null) {
                if (argument.getjTextArea().getText().trim().isEmpty()) {
                    argument.getjTextArea().requestFocus();
                    MessageService.alert(null, "Bạn chưa nhập " + argument.getAlert());
                    return true;
                }
            }
        }
        return false;
    }
}
