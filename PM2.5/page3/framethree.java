import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import javafx.scene.control.TextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
public class framethree {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
        frame.setSize(1980, 1080); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setFont(new Font("Tahoma", Font.BOLD, 15)); 
                Rectangle Rect = new Rectangle(1200, 230, 585, 574, Color.RED);
                Rect.draw(g);
                
            }
        };
        
        frame.add(panel);
        frame.setVisible(true);
    }
}


class Rectangle {
    int x, y, width, height;         //สร้างตัวแปร รับแกรน x,y ยาว สูง
    Color color;             //ตัวแปรมารับสี
    String text1, text2;          //มาใส่ข้อความ

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        // this.text1 = text1;
        // this.text2 = text2;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
    }
}

