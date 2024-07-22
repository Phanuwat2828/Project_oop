
package component;

import java.awt.Color;
import java.awt.Graphics;


public class ColorRectangle {
    int x, y, width, height;
    Color color;
    String text1, text2;

    public ColorRectangle(int x, int y, int width, int height, Color color, String text1, String text2) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.text1 = text1;
        this.text2 = text2;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawString(text1, x + width + 20, y + 20);
        g.drawString(text2, x + width + 20, y + 39);
    }
}