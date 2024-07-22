
import java.util.concurrent.CountedCompleter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.tools.Tool;
import javax.swing.JLabel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Image;



import component.Color_all;

import component.Button_;
import component.Font_all;

public class App {
    public static void main(String[] args){
        // =================================
        String path_image = "/image/mark2.png";
        // ===================== ประกาศ object ===================
        JFrame frame = new JFrame("PM2.5 version alpha");
        Color_all color = new Color_all();// สี
        Button_ bt = new Button_();
        Button_ bt_1 = new Button_();
        Button_ bt_2 = new Button_();
        Font_all font = new Font_all();
        Label label = new Label();



        // =====================  Panel ==================================

        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);

         // ==================== panel 1 ==================================

        JPanel pn1 = new JPanel(new GridBagLayout());
        pn1.setSize(1300,700);
        pn1.setBackground(color.cl_bg);

        // ==================== panel 2 ==================================
        JPanel pn2 = new JPanel(new GridBagLayout());
        
        pn2.setSize(800,700);
        pn2.setBackground(color.cl_bg);
        // ====================== Image Pm2.5 =============================
        // JPanel image_Label = new JPanel(new GridBagLayout());
        ImageIcon image_ = new ImageIcon(App.class.getResource(path_image));
        Image image_2 = image_.getImage();
        Image scaled = image_2.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        image_ = new ImageIcon(scaled);
        JLabel lable = new JLabel(image_);
        // image.setPreferredSize(new Dimension(200,200));
        pn2.add(lable,gbc);
        gbc.gridy = 1;
      


        // ====================== Start Program =============================
        pn2.add(bt.bt_1("Start Program",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy = 2;


        // ====================== Organizer =============================
        pn2.add(bt_1.bt_1("Organizer",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy = 3;


        // ====================== Exit =============================
        pn2.add(bt_2.bt_1("Exit",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy =4;
        pn1.add(pn2);


        // =======================================================
        // ===================== Setting_app =====================
        frame.setIconImage(new ImageIcon(App.class.getResource(path_image)).getImage());
        frame.setLayout(null);
        frame.setSize(1300,700);


        // =======================================================
        frame.add(pn1);
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
        
    }
}

