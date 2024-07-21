import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
public class framethree {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
        frame.setSize(1980, 1080); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         JPanel panel = new JPanel() {
            /*----- method create rectangle set size and position --------*/
            protected void paintComponent(Graphics g) {
                g.setFont(new Font("Tahoma", Font.BOLD, 15)); 
                
                /*------- สร้าง object and กำหนด position and size of React  ----------*/
                Rectangle Rect = new Rectangle(1200, 230, 580, 600, Color.RED);
                Rectangle RectCal_one = new Rectangle(1240, 280, 500, 50, Color.WHITE);
                Rectangle RectCal_two = new Rectangle(1240, 360, 500, 50, Color.WHITE);
                Rectangle RectCal_three = new Rectangle(1240, 440, 500, 50, Color.WHITE);
                Rectangle RectCal_four = new Rectangle(1240, 520, 500, 50, Color.WHITE);
                Rectangle RectCal_five = new Rectangle(1240, 600, 500, 50, Color.WHITE);
                Rect.draw(g);
                RectCal_one.draw(g);
                RectCal_two.draw(g);
                RectCal_three.draw(g);
                RectCal_four.draw(g);
                RectCal_five.draw(g);
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

// method set size position and color 
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
    }
}

