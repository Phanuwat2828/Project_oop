import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel (panel2) with a grid layout
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        panel2.setPreferredSize(new Dimension(800,200));

        // Create the panels that will draw rectangles with different background colors
        JPanel redPanel = new ColorPanel(Color.RED, new Color(255, 200, 200),"มากกว่า 30%");
        JPanel orangePanel = new ColorPanel(new Color(255, 125, 0), new Color(255, 200, 150),"ตั้งแต่ 20-29%");
        JPanel yellowPanel = new ColorPanel(Color.YELLOW, new Color(255, 255, 200),"ตั้งแต่ 10-19%");
        JPanel greenPanel = new ColorPanel(Color.GREEN, new Color(200, 255, 200),"ตั้งแต่ 0-9%");

        // Add the color panels to panel2
        panel2.add(redPanel);
        panel2.add(orangePanel);
        panel2.add(yellowPanel);
        panel2.add(greenPanel);

        // Add panel2 to the frame
        frame.add(panel2);
        frame.setVisible(true);
    }
}

class ColorPanel extends JPanel {
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

class ColorRectangle {
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
        g.drawString(text1, x + width + 20, y + 55);
        g.drawString(text2, x + width + 20, y + 70);
    }
}

