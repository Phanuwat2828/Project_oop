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
        this.color = color;
        this.setPreferredSize(new Dimension(180, 80));
        this.setBackground(color);
        this.txt2 = txt2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure proper rendering
        g.setFont(new Font_all().font_Tahoma(12) );
        ColorRectangle rectangle = new ColorRectangle(18, 10, 55, 50, rectColor, "จำนวนผู้ป๋วย", txt2);
        rectangle.draw(g);
    }
}

