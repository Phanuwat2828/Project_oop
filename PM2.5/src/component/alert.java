package component;
import javax.swing.JOptionPane;


public class Alert {
    public static void Error_alert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        
    }
}