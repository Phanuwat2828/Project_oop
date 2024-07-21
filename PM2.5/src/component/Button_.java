package component;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

public class Button_ extends Button{
   public Button bt_main =new Button();
   
   public Font getFont(int s){
        return new Font_all().font_kanit(s,"Kanit-Bold.ttf");
   }
   

    public Button bt_1(String name,int s){
        bt_main.setLabel(name);
        bt_main.setFont(getFont(s));
        return bt_main;
    }

    public Button bt_1(String name,int w,int h,int s){
        bt_main.setLabel(name);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setFont(getFont(s));
        return bt_main;
    }
    public Button bt_1(String name,int w,int h,Color c,int s){
        bt_main.setLabel(name);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setBackground(c);
        bt_main.setFont(getFont(s));
        return bt_main;
    }

    public Button bt_1(String name,int w,int h,int x,int y,int s){
        bt_main.setLabel(name);
        bt_main.setLocation(x, y);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setFont(getFont(s));
        return bt_main;
    }
    public Button bt_1(String name,int w,int h,int x,int y,Color c,int s){
        bt_main.setLabel(name);
        bt_main.setLocation(x, y);
        bt_main.setPreferredSize(new Dimension(w,h));
        bt_main.setBackground(c);
        bt_main.setFont(getFont(s));
        return bt_main;
    }


}
