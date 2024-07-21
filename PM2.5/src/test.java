

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image in JFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Set the frame icon
            frame.setIconImage(new ImageIcon("./image/mark2.png").getImage());

            // Load the image
            ImageIcon imageIcon = new ImageIcon("./image/mark2.png");
            Image image = imageIcon.getImage();

            // Create a label to display the image
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Create a panel to hold the image label
            JPanel panel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the scaled image
                    g.drawImage(image, 0, 0, 200, getHeight(), this);
                }
            };

            // Add the image label to the panel
            panel.add(imageLabel, BorderLayout.CENTER);

            // Resize the image when the frame is resized
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    // Scale the image to fit the frame
                    Image scaledImage = image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                }
            });

            // Add the panel to the frame
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
