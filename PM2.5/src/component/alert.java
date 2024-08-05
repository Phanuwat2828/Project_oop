package component;
import javax.swing.*;

public class alert {

    // เมธอดสำหรับแสดงข้อความแจ้งเตือนข้อผิดพลาด
    public static void showErrorDialog(String message, String title) {
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }
}
