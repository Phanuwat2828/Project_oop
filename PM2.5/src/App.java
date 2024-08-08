import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        String path_image = "/image/mark2.png";
        JFrame frame = new JFrame("PM2.5 version alpha");
        // =======================================================
        // ===================== Setting_app =====================
        frame.setIconImage(new ImageIcon(App.class.getResource(path_image)).getImage());
        frame.setLayout(new GridLayout());
        frame.setSize(1300,750);
        //frame.add(new Main_());
        frame.add(new StudentIDCardLayout());
        // =======================================================
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
