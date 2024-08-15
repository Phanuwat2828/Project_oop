package component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class buttonRain implements ActionListener {

    public JButton rain() {
        JButton btn = new JButton("RAIN");
        btn.setBounds(20, 50, 170, 70);
        btn.setBackground(new Color(215, 156, 229));
        btn.setFont(new Font_all().font_Tahoma(20));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn) {
                    System.out.println("");
                }
            }
        });
        return btn;
    }

    public JButton rain_two() {
        JButton btn2 = new JButton("Atificial Rain");
        btn2.setBounds(250, 50, 170, 70);
        btn2.setBackground(new Color(215, 156, 229));
        btn2.setFont(new Font_all().font_Tahoma(20));
        return btn2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
