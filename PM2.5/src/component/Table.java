package component;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class Table extends Button_input {
    JPanel container = new JPanel(new GridLayout(10,20,2,2));
    JPanel table_in = new JPanel(new FlowLayout(FlowLayout.LEFT,2,8));
   

    public JPanel getTable(){
        table_in.removeAll();
        table_in.setPreferredSize(new Dimension(700,500));
        for(int i=0;i<20;i++){
            for(int j=0;j<10;j++){
                JButton bt =new JButton();
                bt.setBackground(new Color_all().cl_bg_gray);
                bt.setPreferredSize(new Dimension(33,33));
                table_in.add(bt);
            }
            
        }
        
        table_in.revalidate();
        table_in.repaint();

        return table_in;
    }
}
