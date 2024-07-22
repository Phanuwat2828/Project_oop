import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.GridLayout;
public class frametwo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
        frame.setSize(1000, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {

                g.setFont(new Font("Tahoma", Font.BOLD, 15)); 

                ColorRectangle redRect = new ColorRectangle(20, 15, 95, 90, Color.RED, "จำนวนผู้ป่วย", "มากกว่า30%");
                ColorRectangle orangeRect = new ColorRectangle(255, 15, 110, 100, new Color(255, 125, 0), "จำนวนผู้ป่วย", "มากกว่า30%");
                ColorRectangle yellowRect = new ColorRectangle(485, 15, 110, 100, Color.YELLOW, "จำนวนผู้ป่วย", "มากกว่า30%");
                ColorRectangle greenRect = new ColorRectangle(725, 15, 110, 100, Color.GREEN, "จำนวนผู้ป่วย", "มากกว่า30%");

                redRect.draw(g);
                orangeRect.draw(g);
                yellowRect.draw(g);
                greenRect.draw(g);
            }
        };
        JPanel pn2 = new JPanel();
        pn2.add(panel);
        
        frame.add(pn2);
        frame.setVisible(true);
    }
}

class ColorRectangle {
    int x, y, width, height;         //สร้างตัวแปร รับแกรน x,y ยาว สูง
    Color color;             //ตัวแปรมารับสี
    String text1, text2;          //มาใส่ข้อความ


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

