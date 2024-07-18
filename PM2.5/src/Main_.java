
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import component.Color_all;

public class Main_ {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PM2.5 version alpha");
        JPanel panel_1 = new JPanel();
        JPanel content_1 = new JPanel();
        JPanel content_2 = new JPanel();
        // ======================= Panel_1 ===============================
        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel_1.setBackground(new Color_all().cl_bg);
        panel_1.setLayout(null);

        // ================== content_1 ===================
        JPanel Rain = new JPanel();
        JPanel Status = new JPanel();
        JPanel People = new JPanel();
        content_1.setSize(800,700);
        content_1.setBackground(new Color_all().cl_bg_red);


        // ================== content_2 ===================
        JPanel Tapbar = new JPanel();
        JPanel Table = new JPanel();
        JPanel Footerbar = new JPanel();
        content_2.setSize(500,700);
        content_2.setLocation(800,0);
        content_2.setBackground(new Color_all().cl_bg_white);
        
        // ====================== Add ===================================
        panel_1.add(content_1,gbc);
        gbc.gridx = 1;
        panel_1.add(content_2,gbc);
        // ==============================================================
        
        frame.setLayout(new GridLayout());
        // pn1.add();
        // frame.setBackground(color.cl_bg);

        frame.setSize(1300,700);
        // frame.add(dp.button_import());
        // frame.setBackground(195,179,238);
        frame.add(panel_1);
        // =======================================================
        

        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
