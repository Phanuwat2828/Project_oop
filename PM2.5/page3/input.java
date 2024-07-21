import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class input {
    public static void main(String[] args) {
        Frame frame = new Frame("Input Frame ");
        frame.setSize(1980,1080); 
        // frame.setLocationRelativeTo(null);

        Panel panel = new Panel();
        panel.setLayout(null);

        TextField tf = new TextField(); 
        tf.setBounds(1400, 920, 300, 35);

        Button bt = new Button("Calculate");
        bt.setFont(new Font("Tahoma", Font.BOLD, 15));
        bt.setBackground(new Color(215,156,229)); 
        // bt.setBounds(tf.getX() + tf.getWidth() + 10, tf.getY(), 100, 30);
        bt.setBounds(1700, 915, 190, 45);
        panel.add(bt);
        panel.add(tf);
        frame.add(panel);
        

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}