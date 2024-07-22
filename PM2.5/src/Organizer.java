<<<<<<< HEAD
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import component.Color_all;
=======
>>>>>>> Phanuwat
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
        JPanel pn2=new JPanel();
        pn2.setSize(200,200);
        //ImageIcon imagenight=new ImageIcon("Night.jpg");
        //ImageIcon imagenate=new ImageIcon(nate);
        //ImageIcon imagemark=new ImageIcon(mark);
        JLabel label = new JLabel(new ImageIcon("./image/Night.jpg"));
        pn2.add(label);
        pn1.add(pn2);
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
