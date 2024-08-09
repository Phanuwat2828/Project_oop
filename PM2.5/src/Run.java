import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class App extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Menu menu;
    private StudentIDCardLayout orgenizer;
    App(){
        cardLayout =new CardLayout();
        mainPanel = new JPanel(cardLayout);
        String path_image = "/image/mark2.png";
        //JFrame frame = new JFrame("PM2.5 version alpha");
        // =======================================================
        // ===================== Setting_app =====================
        setIconImage(new ImageIcon(App.class.getResource(path_image)).getImage());
        setLayout(new FlowLayout());
        setSize(1300,750);
        setTitle("Pm2.5 Version Beta");
        setResizable(false);
        Menu menu_panel = new Menu(cardLayout,mainPanel);
        // =======================================================
        mainPanel.add(menu_panel,"Menu");
        mainPanel.add(new Main_(cardLayout,mainPanel),"Main");
        mainPanel.add(new StudentIDCardLayout(cardLayout,mainPanel),"Organizer");
        // ================= menu ================================
        add(mainPanel);
        // =======================================================
        setVisible(true);
        // =======================================================
    }
}
public class Run {
    public static void main(String[] args) {
        new App();
    }
}
