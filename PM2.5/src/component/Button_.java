package component;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Dimension;

public class Button_ extends Button{
   public Button bt_main =new Button();
   public Font_all font = new Font_all();
   

    public Button bt_1(String name,int s){
        bt_main.setLabel(name);
        return bt_main;
    }

    public Button bt_1(String name,int w,int h){
        bt_main.setLabel(name);
        bt_main.setPreferredSize(new Dimension(w,h));
        return bt_main;
    }
    public Button bt_1(String name,int w,int h,Color c){
        bt_main.setLabel(name);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setBackground(c);
        return bt_main;
    }

    public Button bt_1(String name,int w,int h,int x,int y){
        bt_main.setLabel(name);
        bt_main.setLocation(x, y);
        bt_main.setPreferredSize(new Dimension(w,h));
        return bt_main;
    }
    public Button bt_1(String name,int w,int h,int x,int y,Color c){
        bt_main.setLabel(name);
        bt_main.setLocation(x, y);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setBackground(c);
        return bt_main;
    }


}
