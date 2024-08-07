package component;


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Alert {
    public static void Error_alert(String message, String title) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        });
    }
}
