import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayGUI extends JFrame {
    private JButton[][] buttons = new JButton[10][10];
    private double[][] array = new double[10][10];

    public ArrayGUI() {
        // ตั้งค่าเริ่มต้นของ Array
        initializeArray();

        setTitle("Array GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 10));

        // สร้างปุ่มและเพิ่ม ActionListener
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton(String.format("%.2f", array[i][j]));
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                int row = i;
                int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateArray(row, col);
                        updateButtons();
                    }
                });
                add(buttons[i][j]);
            }
        }
    }

    private void initializeArray() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = 1.0; // กำหนดค่าเริ่มต้นเป็น 1.0
            }
        }
    }

    private void updateArray(int row, int col) {
        array[row][col] *= 0.5; // ลดค่าในช่องที่กดลง 50%

        // ลดค่ารอบข้างลง 30%
        // 0,6 => -1,1 5,7
        // -1 5 6 7
        // -1,5 flase
        // 0,5 true
        // 0,6 flase
        // 0,7
        // 1,

        // 5,7 row,col

        // i 4 <= 6
        // j 6 <= 8
        // 4,6
        // 4,6 4,7 4,8
        // 5,6 5,7 5,8
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 20 && !(i == row && j == col)) {
                    array[i][j] *= 0.7;
                }
            }
        }
    }

    private void updateButtons() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setText(String.format("%.2f", array[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArrayGUI().setVisible(true);
            }
        });
    }
}
