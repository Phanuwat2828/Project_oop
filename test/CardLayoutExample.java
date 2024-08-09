import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        // สร้างเฟรมหลัก
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // สร้าง CardLayout และ JPanel ที่ใช้ CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // สร้างคอมโพเนนต์ต่างๆ ที่จะใช้ใน CardLayout
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        card1.setBackground(Color.RED);

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
        card2.setBackground(Color.GREEN);

        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        card3.setBackground(Color.BLUE);

        // เพิ่มคอมโพเนนต์ลงใน cardPanel
        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");
        cardPanel.add(card3, "Card 3");

        // สร้างปุ่มสำหรับการเปลี่ยน Card
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel); // ไปยังคอมโพเนนต์ถัดไป
            }
        });

        // เพิ่ม cardPanel และปุ่มลงในเฟรม
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
        frame.getContentPane().add(btnNext, BorderLayout.SOUTH);

        // แสดงเฟรม
        frame.setVisible(true);
    }
}
