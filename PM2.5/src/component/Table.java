package component;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;


public class Table extends JPanel {
    JPanel container = new JPanel(new GridLayout(10,20,2,2));
   

    public Table(){
        container.setPreferredSize(new Dimension(700,450));

        for(int i=0;i<200;i++){
            JButton bt =new JButton("test");
            container.add(bt);
        }
    }
}
