
import java.util.concurrent.CountedCompleter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Image;

import component.Button_all;
import component.Color_all;
import component.RoundedButton;
import component.Button_;
import component.Font_all;

public class App {
    public static void main(String[] args){
        // ===================== ประกาศ object ===================
        Button_all dp = new Button_all();
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
        JPanel pn1 = new JPanel(new GridBagLayout());
        
        pn1.setSize(1300,700);
        pn1.setBackground(color.cl_bg);

        JPanel pn2 = new JPanel(new GridBagLayout());
        
        pn2.setSize(800,700);
        pn2.setBackground(color.cl_bg);
        pn2.add(bt.bt_1("Start Program",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy = 1;
        pn2.add(bt_1.bt_1("Organizer",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy = 2;
        pn2.add(bt_2.bt_1("Exit",400,70,color.cl_bg_white,20),gbc);
        gbc.gridy =3;

        pn1.add(pn2);
        // =======================================================
        // ===================== Setting_app =====================
        frame.setLayout(null);
        // pn1.add();
        // frame.setBackground(color.cl_bg);
        frame.setIconImage(null);
        frame.setSize(1300,700);
        // frame.add(dp.button_import());
        // frame.setBackground(195,179,238);
        // =======================================================
        frame.add(pn1);
        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
        
    }
}

