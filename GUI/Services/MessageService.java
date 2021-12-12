
package GUI.Services;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MessageService {
     
    public static void alert(Component currentParent, String message) {
     
        JOptionPane.showMessageDialog(
                currentParent, message, 
                "Hệ thống cửa hàng điện thoại", 
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static boolean confirm(Component currentParent, String message) {
   
        int result = JOptionPane.showConfirmDialog(
                currentParent, message, 
                "Hệ thống cửa hàng điện thoại", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component currentParent, String message) {
        return JOptionPane.showInputDialog(
                currentParent, message, 
                "Hệ thống cửa hàng điện thoại", 
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}

