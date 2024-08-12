import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import component.Color_all;
import component.Font_all;

public class StudentIDCardLayout extends JPanel {

    public StudentIDCardLayout(CardLayout cardLayout, JPanel MainPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(1300,750));
        Color_all color = new Color_all();
        // Create a panel to hold the student cards
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel button_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,0));
        button_panel.setPreferredSize(new Dimension(1300,100));
        // cardPanel.setOpaque(false);
        // ===========================
        JButton button = new JButton("Back");
        button.setFont(new Font_all().font_Tahoma(18));
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(color.cl_bg_p);
        button.setForeground(color.cl_bg_white);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "Menu");
            }
            
        });
        // =====================================
        // JPanel tobutton = new JPanel(new FlowLayout(FlowLayout.LEADING));
        // tobutton.setBackground(color.cl_bg);
        // tobutton.setPreferredSize(new Dimension(1000, 100));
        // tobutton.add(button);
        cardPanel.add(title("ORGENIZER"));
        // Add three student cards with example data
        // Replace these with actual file paths, names, and IDs
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Night.jpg"), "ภานุวัฒน์ คำทา","66011212124","ORGENIZER"));
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Mark.png"), "นนทพัทธ์ กัตโร"  ,"66011212106",""));
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Nate.jpg"), "จิรัชยา พันอุ่น","66011212079",""));
        
        // Add some padding around the card panel
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,80));
        // mainPanel.setOpaque(false);
        mainPanel. setPreferredSize(new Dimension(1300,750));
        mainPanel.add(cardPanel);
        button_panel.add(button);
        cardPanel.setPreferredSize(new Dimension(1300, 400));
        button_panel.setBackground(null);
        cardPanel.setBackground(null);
        mainPanel.setBackground(null);
        mainPanel.add(button_panel);
        setBackground(color.cl_bg);
        add(mainPanel);
    }
    private JPanel title(String titel_ ){
        JPanel cardtt = new JPanel(new FlowLayout(FlowLayout.CENTER,50,80));
        cardtt.setOpaque(false);
        cardtt.setPreferredSize(new Dimension(300,400));
        JLabel ttLabel = new JLabel(titel_, JLabel.CENTER);
        ttLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        ttLabel.setForeground((new Color_all().cl_bg_bu));
        ttLabel.setBounds(0, 300, 300, 30);
        cardtt.add(ttLabel);

        return cardtt;
    }

    private JPanel createStudentCard(URL string, String name, String studentId,String titel_) {
        JPanel card = new JPanel(null);
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(300, 400));

        // Load and display the image with rounded corners
        ImageIcon imageIcon = new ImageIcon(string);
        Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        RoundedImageLabel imageLabel = new RoundedImageLabel(new ImageIcon(image), 30);
        imageLabel.setBounds(25, 0, 250, 250);

        // If image loading fails, display a placeholder
        if (imageIcon.getIconWidth() == -1) {
            imageLabel.setText("Picture");
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setForeground(Color.RED);
            imageLabel.setFont(new Font("Kanit", Font.BOLD, 24));
        }

        // Name and Student ID labels
        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        JLabel idLabel = new JLabel(studentId, JLabel.CENTER);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        nameLabel.setForeground((new Color_all().cl_bg_bu));
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        idLabel.setForeground((new Color_all().cl_bg_bu));
        

        // Position name and ID labels 50 pixels below the image
        nameLabel.setBounds(0, 300, 300, 30);
        idLabel.setBounds(0, 340, 300, 25);
        // ============================================

        // Add components to the card
        card.add(imageLabel);
        card.add(nameLabel);
        card.add(idLabel);

        return card;
    }
}

class RoundedImageLabel extends JLabel {
    private Shape shape;
    private int arcSize;

    public RoundedImageLabel(Icon image, int arcSize) {
        super(image);
        this.arcSize = arcSize;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
        g2.setClip(shape);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(shape);
        g2.dispose();
    }
}
