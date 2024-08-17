package component;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ColorPanel extends JPanel {
    Color color;
    Color rectColor;
    String txt2;

    public ColorPanel(Color rectColor, Color color, String txt2) {
        this.rectColor = rectColor;
        this.setPreferredSize(new Dimension(180, 80));
        this.setBackground(color);
        this.txt2 = txt2;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        g.setFont(new Font_all().font_kanit(13, "Kanit-Bold.ttf"));
        
        ColorRectangle rectangle = new ColorRectangle(20, 10, 55, 50, rectColor, "จำนวนผู้ป๋วย", txt2);
        rectangle.draw(g);
    }
}
