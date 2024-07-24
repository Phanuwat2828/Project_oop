package component;


import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;

public class middle {

//ช่องใหญ่
    public static JPanel big(){
        JPanel pn1 = new JPanel();
        pn1.setBounds(25, 30, 400, 410);
        pn1.setBackground(new Color(255, 200, 150));
        return pn1;
    }

//กลาง
    public JPanel middlerect(){
        JPanel pn2 = new JPanel();
        pn2.setBounds(45, 60, 360, 350);
        pn2.setBackground(new Color(255, 128, 0));
        return pn2;
    }

//5 ช่่อง
    public JPanel[] smallrect(){
        JPanel[] pn3A = new JPanel[5];
        int yPosition = 80;

        for (int i = 0; i < 5; i++) {
            JPanel pn3 = new JPanel();
            pn3.setBounds(65, yPosition, 320, 50);
            pn3.setBackground(new Color(255, 255, 255));
            pn3A[i] = pn3;
            yPosition += 65;
        }
        return pn3A;
    } 

    //JLayeredPane ช่วยจัดตำแหน่ง
    public JLayeredPane manageRect_all() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(450, 500));
        
        JPanel bigPanel = big();
        JPanel middlePanel = middlerect();
        JPanel[] smallPanels = smallrect();
        
//set positiion of rect
        layeredPane.add(bigPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(middlePanel, JLayeredPane.PALETTE_LAYER);

// loop smallpanel จนครบ
        for (JPanel smallPanel : smallPanels) {
            layeredPane.add(smallPanel, JLayeredPane.MODAL_LAYER);
        }
        return layeredPane;
    }
}
