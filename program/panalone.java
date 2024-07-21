import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class panalone {
    public static void main(String[] args) {
        Frame frame = new Frame("Panal Rate  The Patient ");
        frame.setSize(400, 300); 
        frame.setLocationRelativeTo(null);

        Button button = new Button("   ");
        button.setSize(15, 20);
        


        frame.setLayout(new GridLayout(2, 2));
        frame.add(button);


//กดออกได้
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
