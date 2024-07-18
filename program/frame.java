import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frame {
    public static void main(String[] args) {
        Frame frame = new Frame("SSS");
        frame.setSize(400, 300); 
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridLayout(10, 20));

        Button[][] bt = new Button[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                bt[i][j] = new Button();
                frame.add(bt[i][j]);
            }
        }


//กดออกได้
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
