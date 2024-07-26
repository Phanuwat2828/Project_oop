

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

            JTextField input = new JTextField("-5000");
            String data[] = new String[2];
            if(input.getText().contains("-")){
                data = input.getText().split("[-]");
            }else if(input.getText().matches("\\d+")){
                data[0]= input.getText();
            }else{
                System.out.print("Error");
            }
            System.out.print(data.length);
            frame.setVisible(true);
        });
    }
}
