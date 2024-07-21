import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import component.Color_all;
public class Organizer {
    public static void main(String[] args) {
        //============สร้างobject==================================
        JFrame frame= new JFrame("Organizer");
        Color_all color=new Color_all();
        //============Frame==================================
        frame.setLayout(null);
        frame.setSize(1300,700);
        //==========blackgroud============================
        JPanel pn1 = new JPanel(new GridBagLayout());
        pn1.setSize(1300,700);
        pn1.setBackground(color.cl_bg);
        frame.add(pn1);
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
