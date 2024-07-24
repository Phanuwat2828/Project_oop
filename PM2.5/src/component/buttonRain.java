package component;

import java.awt.Color;

import javax.swing.JButton;

public class buttonRain {
    public JButton rain(){
        JButton btn = new JButton("RAIN");
        btn.setBounds(20, 50, 170, 70);
        btn.setBackground(new Color(215,156,229));
        btn.setFont(new Font_all().font_kanit(20, "Bold"));
        return btn;
    }


    public JButton rain_two() {
            JButton btn2 = new JButton("Atificial Rain");
            btn2.setBounds(250, 50, 170, 70);
            btn2.setBackground(new Color(215, 156, 229));
            btn2.setFont(new Font_all().font_kanit(20, "Bold"));
            return btn2;
    }
    
}
  