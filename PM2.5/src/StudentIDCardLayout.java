import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import component.Color_all;
import component.Font_all;

public class StudentIDCardLayout extends JFrame {

    public StudentIDCardLayout() {
        setTitle("Organizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);

        // Set the background color (light purple)
        Color_all color = new Color_all();
        getContentPane().setBackground(color.cl_bg);

        // Create a panel to hold the student cards
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cardPanel.setOpaque(false);
        // ===========================
        JButton button = new JButton("Back");
        button.setFont(new Font_all().font_kanit(18, "Kanit-Bold.ttf"));
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(color.cl_bg_gray);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("555555");
            }

        });
        // =====================================
        JPanel tobutton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tobutton.setBackground(color.cl_bg);
        tobutton.setPreferredSize(new Dimension(1000, 100));
        tobutton.add(button);

        // Add three student cards with example data
        // Replace these with actual file paths, names, and IDs
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Night.jpg"), "ภานุวัฒน์ คำทา",
                "66011212124"));
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Mark.png"), "นนทพัทธ์ กัตโร",
        "66011212106"));
        cardPanel.add(createStudentCard(StudentIDCardLayout.class.getResource("/image/Nate.jpg"), "จิรัชยา พันอุ่น",
        "66011212079"));

        // Add some padding around the card panel
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 80));
        mainPanel.setOpaque(false);
        mainPanel.add(cardPanel);
        mainPanel.add(tobutton);

        add(mainPanel);
    }

    private JPanel createStudentCard(URL url, String name, String studentId) {
        JPanel card = new JPanel(null);
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(300, 400));

        // Load and display the image with rounded corners
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        RoundedImageLabel imageLabel = new RoundedImageLabel(new ImageIcon(image), 30);
        imageLabel.setBounds(25, 0, 250, 250);

        // If image loading fails, display a placeholder
        if (imageIcon.getIconWidth() == -1) {
            imageLabel.setText("Picture");
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setForeground(Color.RED);
            imageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        }

        // Name and Student ID labels
        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        JLabel idLabel = new JLabel(studentId, JLabel.CENTER);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Position name and ID labels 50 pixels below the image
        nameLabel.setBounds(0, 300, 300, 25);
        idLabel.setBounds(0, 325, 300, 25);
        // ============================================

        // Add components to the card
        card.add(imageLabel);
        card.add(nameLabel);
        card.add(idLabel);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentIDCardLayout().setVisible(true);
        });
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
