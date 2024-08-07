package component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class alert {

    // เมธอดสำหรับแสดงข้อความแจ้งเตือนข้อผิดพลาด
    public static void showErrorDialog(String message, String title) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setLocation(400,300);  // Set the position of the dialog
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
        System.out.print( JOptionPane.OK_OPTION);
        dialog.setVisible(true);
    }

    public static void checkConditionAndShowError(boolean condition) {
        if (condition) {
            showErrorDialog("An unexpected error occurred.", "Error"); // Position at (500, 300)
        }
    }
}
