import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.GridLayout;
public class frametwo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Frame");
<<<<<<< HEAD
        frame.setSize(1300, 700); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


=======
<<<<<<< HEAD
        frame.setSize(1980, 1080); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
=======
        frame.setSize(1000, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

>>>>>>> main
>>>>>>> f7b9cfd32387614283ee3b0753924af3e20cf7ff
        JPanel panel = new JPanel() {
            /*----- method create rectangle set size and position --------*/
            protected void paintComponent(Graphics g) {
        
                g.setFont(new Font("Tahoma", Font.BOLD, 15)); 
<<<<<<< HEAD
                  /*------- สร้าง object and กำหนด position and size of React  ----------*/
<<<<<<< HEAD
                ColorRectangle redRect = new ColorRectangle(20, 15, 50, 100, Color.RED, "จำนวนผู้ป่วย", "มากกว่า30%");
=======
                ColorRectangle redRect = new ColorRectangle(20, 15, 110, 100, Color.RED, "จำนวนผู้ป่วย", "มากกว่า30%");
=======

                ColorRectangle redRect = new ColorRectangle(20, 15, 95, 90, Color.RED, "จำนวนผู้ป่วย", "มากกว่า30%");
>>>>>>> main
>>>>>>> f7b9cfd32387614283ee3b0753924af3e20cf7ff
                ColorRectangle orangeRect = new ColorRectangle(255, 15, 110, 100, new Color(255, 125, 0), "จำนวนผู้ป่วย", "มากกว่า30%");
                ColorRectangle yellowRect = new ColorRectangle(485, 15, 110, 100, Color.YELLOW, "จำนวนผู้ป่วย", "มากกว่า30%");
                ColorRectangle greenRect = new ColorRectangle(725, 15, 110, 100, Color.GREEN, "จำนวนผู้ป่วย", "มากกว่า30%");
                
                redRect.draw(g);
                orangeRect.draw(g);
                yellowRect.draw(g);
                greenRect.draw(g);
            }
        };
<<<<<<< HEAD
         

        frame.add(panel);
=======
        JPanel pn2 = new JPanel();
        pn2.add(panel);
        
        frame.add(pn2);
>>>>>>> f7b9cfd32387614283ee3b0753924af3e20cf7ff
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

