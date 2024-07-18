package component;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;

public class RoundedButton extends JButton {

    private int radius;
    private Color color ;
    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);

    }
    public RoundedButton(String text, int radius,Color color) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
        this.color = color;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // ใช้สีขอบเป็นสีพื้นหลัง
        g2.setColor(getForeground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // ใช้สีขอบเป็นสีขอบ
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        g2.dispose();
    }

    @Override
    public void setContentAreaFilled(boolean b) {
        // Do nothing to make the background transparent
    }
}
