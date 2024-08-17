package component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class middle extends JPanel {

    // ช่องใหญ่
    public static JPanel big(Color color) {
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 18));
        pn1.setPreferredSize(new Dimension(400, 450));
        pn1.setBackground(color);
        return pn1;
    }

    // กลาง
    public JPanel middlerect(Color color) {
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        pn2.setPreferredSize(new Dimension(360, 420));
        pn2.setBackground(color);
        return pn2;
    }

    // 5 ช่่อง
    public JPanel[] smallrect(int data[]) {
        String name[] = { "PM2.5 : ","Total people : ", "Percent : ", "Sick people:", "Healthy people: ", "Station number: " };
        JPanel[] pn3A = new JPanel[6];
        for (int i = 0; i < 6; i++) {
            JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
            JLabel lable = new JLabel();
            pn3.setPreferredSize(new Dimension(320, 50));
            pn3.setBackground(new Color(255, 255, 255));
            // ================== Error Color ================
            if (i == 1 || i == 4) {
                if (data[1] == -200) {
                    lable.setText(name[i] + " !Example 10-20 No -500");
                    lable.setForeground(new Color_all().cl_bg_red);
                } else if (data[1] == -300) {
                    lable.setText(name[i] + " !Please Integer");
                    lable.setForeground(new Color_all().cl_bg_red);
                } else {
                    lable.setText(name[i] + " " + data[i]);
                }
            } else {
                if (i != 2) {
                    lable.setText(name[i] + " " + data[i]);
                } else {
                    lable.setText(name[i] + " " + data[i] + " %");
                }
                if(data[1] <-100 && i==0){
                    lable.setText(name[i] + "\"People Count\" Error ");
                    lable.setForeground(new Color_all().cl_bg_red);
                }else if (data[i] < 0 || data[i]>250 && i == 0 ) {
                    lable.setText(name[i] + " Error Pm2.5 " + data[i]);
                    lable.setForeground(new Color_all().cl_bg_red);
                }
            }
            
            lable.setFont(i==0?new Font_all().font_Tahoma(20):new Font_all().font_Tahoma(14) );
            pn3.add(lable);
            pn3A[i] = pn3;
        }
        pn3A[0].setBackground(null);
        return pn3A;
    }


    public middle(int data[], Color color[]) {
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
