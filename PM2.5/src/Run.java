import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class App extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    App(){
        cardLayout =new CardLayout();
        mainPanel = new JPanel(cardLayout);
        String path_image = "/image/mark2.png";
        JFrame frame = new JFrame("PM2.5 version alpha");
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
        // Set up window listener to control closing behavior
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Check which panel is currently visible
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                JPanel currentPanel = (JPanel) mainPanel.getComponent(0);
                //===============สร้างวนลูปเพื่อเช็คว่าpanelปัจจุบันที่เปิดเป็น menuไหม===========
                for (int i = 0; i < mainPanel.getComponentCount(); i++) {
                    if (mainPanel.getComponent(i).isVisible()) {
                        currentPanel = (JPanel) mainPanel.getComponent(i);
                        break;
                    }
                }

                // =========Only allow closing if the current panel is the menu panel
                if (currentPanel == menu_panel) {
                    int response = JOptionPane.showConfirmDialog(App.this,
                            "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        dispose(); // Close the frame
                    }
                } else {
                    JOptionPane.showMessageDialog(App.this,
                            "You cannot close the application from this panel.",
                            "Action Not Allowed", JOptionPane.WARNING_MESSAGE);
                            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        setVisible(true);
        // =======================================================
    }
}


public class Run {
    public static void main(String[] args) {
        new App();
    }
}



