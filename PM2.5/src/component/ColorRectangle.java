package component;

import java.awt.Color;
import java.awt.Graphics;

public class ColorRectangle {
    int x, y, width, height;
    Color rectColor;
    String text1, txt2;

    public ColorRectangle(int x, int y, int width, int height, Color rectColor, String text1, String txt2) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rectColor = rectColor;
        this.text1 = text1;
        this.txt2 = txt2;
    }

    public void draw(Graphics g) {
        g.setColor(rectColor);
        g.fillRect(x, y, width, height);
        
        g.setColor(Color.BLACK);
        g.drawString(text1, x + width + 20, y + 20);
        g.drawString(txt2, x + width + 20, y + 39);
    }
    
} 
