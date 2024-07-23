import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pn1.setSize(1300,700);
        pn1.setBackground(color.cl_bg);
        frame.add(pn1);
        //===========image===================
        // Panel pn2 = new Panel();
        // String image = "/image/Night.jpg";
        // ImageIcon image_ = new ImageIcon(App.class.getResource(image));
        // Image image2 = image_.getImage();
        // Image scaled = image2.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        // image_ = new ImageIcon(scaled);
        // JLabel lable = new JLabel(image_);
        // image.setPreferredSize(new Dimension(200,200));
        //pn2.add(lable,gbc);
        //frame.setIconImage(new ImageIcon(App.class.getResource(image)).getImage());
        //frame.setLayout(null);
        //frame.setSize(1300,700);
        //=======================ชื่อ===========================
        // JPanel pn3 = new JPanel();
        // pn3.setSize(100,300);
        // JLabel label1 = new JLabel("jiratchaya phan-un\n"+"6601212079");
        // pn3.add(label1);
        // pn1.add(pn3);
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
