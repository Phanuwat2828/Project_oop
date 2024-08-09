package component;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;

public class Button_ extends JButton{
   
    public Font getFont(int s){
            return new Font_all().font_kanit(s,"Kanit-Bold.ttf");
    }
   
    public Button_(String name,int s){
        setText(name);
        setFont(getFont(s)) ;
    }

    public Button_(String name,int w,int h,int s){
        setText(name);
        setPreferredSize(new Dimension(w,h));
        setFont(getFont(s));
    }

    public Button_(String name,int w,int h,Color c,int s){
        setText(name);
        setPreferredSize(new Dimension(w,h));
        setFont(getFont(s));
        setBackground(c);
    }

    public Button_(String name,int w,int h,int x,int y,int s){
        setText(name);
        setPreferredSize(new Dimension(w,h));
        setFont(getFont(s));
        setLocation(x, y);
    }
    public Button_(String name,int w,int h,int x,int y,Color c,int s){
        setText(name);
        setPreferredSize(new Dimension(w,h));
        setFont(getFont(s));
        setBackground(c);
        setLocation(x, y);
    }


}
