
import java.util.concurrent.CountedCompleter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import component.Button_all;
import component.Color_all;
import component.RoundedButton;
import component.Button_;

public class App {
    public static void main(String[] args){
        // ===================== ประกาศ object ===================
        Button_all dp = new Button_all();
        JFrame frame = new JFrame("PM2.5 version alpha");
        Color_all color = new Color_all();// สี
        Button_ bt = new Button_();
        // =====================  Panel ==================================
        JPanel pn1 = new JPanel();
        pn1.setSize(1300,700);
        // =======================================================
    

        // ===================== Setting_app =====================
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        // pn1.add();
        // frame.setBackground(color.cl_bg);
        frame.setSize(1300,700);
        // frame.add(dp.button_import());
        // frame.setBackground(195,179,238);
        // =======================================================
       

        frame.add(bt.bt_1("buttom",100,200,200,200,color.cl_bg));




        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
        

    }
}

