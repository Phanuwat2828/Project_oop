import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Menu menu;
    private StudentIDCardLayout orgenizer;
    App(String t ){
        cardLayout =new CardLayout();
        mainPanel = new JPanel(cardLayout);
        String path_image = "/image/mark2.png";
        //JFrame frame = new JFrame("PM2.5 version alpha");
        // =======================================================
        // ===================== Setting_app =====================
        setIconImage(new ImageIcon(App.class.getResource(path_image)).getImage());
        setLayout(new GridLayout());
        setSize(1300,750);
        add(this.mainPanel);
        // =======================================================
        // =======================================================
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // =======================================================
    }
    void add(JPanel panel,String name){
        this.mainPanel.add(panel, name);
    }
    void show(String name){
        this.cardLayout.show(this.mainPanel,name);
    }
}
