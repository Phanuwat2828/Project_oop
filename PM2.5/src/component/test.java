package component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;


public class ColorPanel extends JPanel {
    Color rectColor;
    Color bgColor;
    String txt1;    

    public ColorPanel(Color rectColor, Color bgColor,String txt1) {
        this.rectColor = rectColor;
        this.bgColor = bgColor;
        this.setPreferredSize(new Dimension(175, 125)); // Set the preferred size to 200x200
        this.setBackground(bgColor);
        this.txt1 = txt1;
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure proper rendering


        g.setFont(new Font("Tahoma", Font.BOLD, 13));

        ColorRectangle rectangle = new ColorRectangle(20, 15, 95, 90, rectColor, "จำนวนผู้ป๋วย", txt1);
        rectangle.draw(g);
    }
}