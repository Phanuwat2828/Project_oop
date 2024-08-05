package component;
import javax.swing.*;

public class alert {

    // เมธอดสำหรับแสดงข้อความแจ้งเตือนข้อผิดพลาด
    public static void showErrorDialog(String message, String title) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setLocation(400,300);  // Set the position of the dialog
        dialog.setVisible(true);
    }

    public static void checkConditionAndShowError(boolean condition) {
        if (condition) {
            showErrorDialog("An unexpected error occurred.", "Error"); // Position at (500, 300)
        }
    }
}
