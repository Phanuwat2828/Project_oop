import javax.swing.*;
import java.awt.*;

public class assemble {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
        frame.setSize(1980, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setFont(new Font("Tahoma", Font.BOLD, 15));
                drawRectangles(g);
                drawAdditionalRectangles(g);
            }
        };
        
        panel.setLayout(null);

        TextField tf = new TextField();
        tf.setBounds(1400, 920, 300, 35);

        Button bt = new Button("Calculate");
        bt.setFont(new Font("Tahoma", Font.BOLD, 15));
        bt.setBackground(new Color(215, 156, 229));
        bt.setBounds(1700, 915, 190, 45);

        panel.add(bt);
        panel.add(tf);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void drawRectangles(Graphics g) {
        ColorRectangle redRect = new ColorRectangle(20, 15, 110, 100, Color.RED, "จำนวนผู้ป่วย", "มากกว่า30%");
        ColorRectangle orangeRect = new ColorRectangle(255, 15, 110, 100, new Color(255, 125, 0), "จำนวนผู้ป่วย", "มากกว่า30%");
        ColorRectangle yellowRect = new ColorRectangle(485, 15, 110, 100, Color.YELLOW, "จำนวนผู้ป่วย", "มากกว่า30%");
        ColorRectangle greenRect = new ColorRectangle(725, 15, 110, 100, Color.GREEN, "จำนวนผู้ป่วย", "มากกว่า30%");

        redRect.draw(g);
        orangeRect.draw(g);
        yellowRect.draw(g);
        greenRect.draw(g);
    }

    private static void drawAdditionalRectangles(Graphics g) {
        Rectangle rect = new Rectangle(1200, 230, 580, 600, Color.RED);
        Rectangle rectCalOne = new Rectangle(1240, 280, 500, 50, Color.WHITE);
        Rectangle rectCalTwo = new Rectangle(1240, 360, 500, 50, Color.WHITE);
        Rectangle rectCalThree = new Rectangle(1240, 440, 500, 50, Color.WHITE);
        Rectangle rectCalFour = new Rectangle(1240, 520, 500, 50, Color.WHITE);
        Rectangle rectCalFive = new Rectangle(1240, 600, 500, 50, Color.WHITE);

        rect.draw(g);
        rectCalOne.draw(g);
        rectCalTwo.draw(g);
        rectCalThree.draw(g);
        rectCalFour.draw(g);
        rectCalFive.draw(g);
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

class Rectangle {
    int x, y, width, height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
