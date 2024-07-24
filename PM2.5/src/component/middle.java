package component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;

public class middle extends JPanel {

    // ช่องใหญ่
    public static JPanel big(Color color) {
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        pn1.setPreferredSize(new Dimension(400, 450));
        pn1.setBackground(color);
        return pn1;
    }

    // กลาง
    public JPanel middlerect(Color color) {
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        pn2.setPreferredSize(new Dimension(360, 400));
        pn2.setBackground(color);
        return pn2;
    }

    // 5 ช่่อง
    public JPanel[] smallrect(int data[]) {
        String data_1[] = { "People : ", "Persen : ", "People Sick :", "People good: ", "Number : " };
        JPanel[] pn3A = new JPanel[5];
        int yPosition = 80;

        for (int i = 0; i < 5; i++) {
            JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
            JLabel lable = new JLabel();
            pn3.setPreferredSize(new Dimension(320, 50));
            pn3.setBackground(new Color(255, 255, 255));
            if (i != 1) {
                lable.setText(data_1[i] + " " + data[i]);
            } else {
                lable.setText(data_1[i] + " " + data[i] + " %");
            }
            lable.setFont(new Font_all().font_kanit(14, "Kanit-Bold.ttf"));

            pn3.add(lable);
            pn3A[i] = pn3;
        }
        return pn3A;
    }

    // JLayeredPane ช่วยจัดตำแหน่ง
    public middle(int data[], Color color[]) {
        // JLayeredPane layeredPane = new JLayeredPane();
        // layeredPane.setPreferredSize(new Dimension(450, 500));

        JPanel bigPanel = big(color[1]);
        JPanel middlePanel = middlerect(color[0]);
        JPanel[] smallPanels = smallrect(data);

        for (JPanel smallPanel : smallPanels) {
            middlePanel.add(smallPanel);
        }
        setBackground(null);
        bigPanel.add(middlePanel);
        add(bigPanel);
    }
}
