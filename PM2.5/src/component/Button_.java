package component;
import java.awt.Color;

import javax.swing.JButton;;

public class Button_ extends JButton{
    private String name_bt ;
    private Color color ;
    private int[] size =new int[2];
    private int[] position = new int[2];
    private JButton bt_main = new JButton();
    

    public JButton bt_1(String name){
        bt_main.setText(name);
        return bt_main;
    }

    public JButton bt_1(String name,int w,int h,int x,int y){
        bt_main.setText(name);
        bt_main.setBounds(x, y, w, h);
        return bt_main;
    }
    public JButton bt_1(String name,int w,int h,int x,int y,Color c){
        bt_main.setText(name);
        bt_main.setBounds(x, y, w, h);
        bt_main.setBackground(c);
        return bt_main;
    }

}
