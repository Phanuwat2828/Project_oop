
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
import java.awt.FlowLayout;
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

public class Menu extends JPanel {
    public Menu(){
        // =================================
        String path_image = "/image/mark2.png";
        // ===================== ประกาศ object ===================
        JFrame frame = new JFrame("PM2.5 version alpha");
        Color_all color = new Color_all();// สี
        Button_ bt = new Button_("Start Program",400,70,color.cl_bg_white,20);
        Button_ bt_1 = new Button_("Organizer",400,70,color.cl_bg_white,20);
        Button_ bt_2 = new Button_("Exit",400,70,color.cl_bg_white,20);
        Font_all font = new Font_all();
        Label label = new Label();


        // =====================  Panel ==================================


         // ==================== panel 1 ==================================

        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pn1.setPreferredSize(new Dimension(1300,750));
        pn1.setBackground(color.cl_bg);

        // ==================== panel 2 ==================================
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        
        pn2.setPreferredSize(new Dimension(500,700));
        pn2.setBackground(null);

        // ====================== Image Pm2.5 =============================
        // JPanel image_Label = new JPanel(new GridBagLayout());
        ImageIcon image_ = new ImageIcon(Menu.class.getResource(path_image));
        Image image_2 = image_.getImage();
        Image scaled = image_2.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        image_ = new ImageIcon(scaled);
        JLabel lable = new JLabel(image_);

        // image.setPreferredSize(new Dimension(200,200));
        pn2.add(lable);

        // ====================== Start Program =============================
        pn2.add(bt);


        // ====================== Organizer =============================
        pn2.add(bt_1);


        // ====================== Exit =============================
        pn2.add(bt_2);


        pn1.add(pn2);
        setLayout(new FlowLayout());

        // =======================================================
        // ===================== Setting_app =====================
        setPreferredSize(new Dimension(1300,750));
        add(pn1);
        
    }
}

