

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;



import component.Color_all;

import component.Button_;
import component.Font_all;

public class Menu extends JPanel {
    private JPanel Menu ;
    public Menu(CardLayout cardLayout, JPanel cardPanel){
        this.Menu = this;
        // =================================
        String path_image = "/image/mark2.png";
        // ===================== ประกาศ object ===================
        JFrame frame = new JFrame("PM2.5 version alpha");
        Color_all color = new Color_all();// สี
       
        Button_ bt_1 = new Button_("Organizer",400,70,color.cl_bg_white,20);
        Button_ bt_2 = new Button_("Exit",400,70,color.cl_bg_white,20);
        Font_all font = new Font_all();
        Label label = new Label();

        // =====================  Panel ==================================


        // ==================== panel 1 ==================================

        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pn1.setPreferredSize(new Dimension(1300,750));
        pn1.setBackground(color.cl_bg);

        // ==================== panel 2 ==================================
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        
        pn2.setPreferredSize(new Dimension(500,700));
        pn2.setBackground(null);

        // ====================== Image Pm2.5 =============================
        // JPanel image_Label = new JPanel(new GridBagLayout());
        ImageIcon image_ = new ImageIcon(Menu.class.getResource(path_image));
        Image image_2 = image_.getImage();
        Image scaled = image_2.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        image_ = new ImageIcon(scaled);
        JLabel lable = new JLabel(image_);

        // image.setPreferredSize(new Dimension(200,200));
        pn2.add(lable);

        // ====================== Start Program =============================
        Button_ bt = new Button_("Start Program",400,70,color.cl_bg_white,20);
        bt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main"); // แสดง Card 1
            }

        });
        
        pn2.add(bt);


        // ====================== Organizer =============================
        bt_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardPanel.setVisible(true);
                cardLayout.show(cardPanel, "Organizer"); // แสดง Card 2
                Menu.setVisible(false);
            }

        });
        pn2.add(bt_1);


        // ====================== Exit =============================
        bt_2.addActionListener(e -> System.exit(0));
        pn2.add(bt_2);


        pn1.add(pn2);
        setLayout(new FlowLayout());

        // =======================================================
        // ===================== Setting_app =====================
        setPreferredSize(new Dimension(1300,750));
        add(pn1);
        //=============================================
        
    }
}

