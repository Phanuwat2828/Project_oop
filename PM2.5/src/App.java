import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        String path_image = "/image/mark2.png";
        JFrame frame = new JFrame("PM2.5 version alpha");
        // =======================================================
        // ===================== Setting_app =====================
        frame.setIconImage(new ImageIcon(menu.class.getResource(path_image)).getImage());
        frame.setLayout(null);
        frame.setSize(1300,700);


        // =======================================================
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
