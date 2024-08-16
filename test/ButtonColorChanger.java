// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import java.util.Random;

// public class ButtonColorChanger {
//     private static final int ROWS = 10;
//     private static final int COLS = 20;
//     private static final Color ACTIVE_COLOR = Color.YELLOW;
//     private static final Color NEIGHBOR_COLOR = Color.GREEN;
//     private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;

//     private static JButton[][] buttons = new JButton[ROWS][COLS];
//     private static int[][] pm25Levels = new int[ROWS][COLS];
//     private static int[][] patientLevels = new int[ROWS][COLS];
//     private static boolean isSelecting = false;
//     private static boolean isRemoving = false;

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Button Color Changer with Rain and Remove");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new BorderLayout());

//         JPanel buttonPanel = new JPanel();
//         buttonPanel.setLayout(new GridLayout(ROWS, COLS));

//         Random rand = new Random();

//         for (int row = 0; row < ROWS; row++) {
//             for (int col = 0; col < COLS; col++) {
//                 pm25Levels[row][col] = rand.nextInt(301); // ค่า PM2.5 ระหว่าง 0 ถึง 300
//                 patientLevels[row][col] = rand.nextInt(101); // จำนวนผู้ป่วยระหว่าง 0 ถึง 100

//                 buttons[row][col] = new JButton(getButtonText(row, col));
//                 buttons[row][col].setPreferredSize(new Dimension(50, 50));
//                 buttons[row][col].setBackground(getButtonColor(patientLevels[row][col]));
//                 buttons[row][col].addMouseListener(new ButtonMouseListener(row, col));
//                 buttonPanel.add(buttons[row][col]);
//             }
//         }

//         JPanel controlPanel = new JPanel();
//         JButton rainButton = new JButton("Rain");
//         rainButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 isSelecting = !isSelecting; // Toggle selection mode
//                 isRemoving = false; // Ensure removing mode is off
//                 rainButton.setText(isSelecting ? "Select Area" : "Rain");
//             }
//         });

//         JButton removeButton = new JButton("Remove");
//         removeButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 isRemoving = !isRemoving; // Toggle removal mode
//                 isSelecting = false; // Ensure selecting mode is off
//                 removeButton.setText(isRemoving ? "Cancel Remove" : "Remove");
//                 rainButton.setText("Rain");
//             }
//         });

//         controlPanel.add(rainButton);
//         controlPanel.add(removeButton);

//         frame.add(controlPanel, BorderLayout.NORTH);
//         frame.add(buttonPanel, BorderLayout.CENTER);

//         frame.pack();
//         frame.setVisible(true);
//     }

//     private static String getButtonText(int row, int col) {
//         return "<html>PM2.5: " + pm25Levels[row][col] + "<br>Patients: " + patientLevels[row][col] + "%</html>";
//     }

//     private static Color getButtonColor(int patients) {
//         if (patients >= 30) {
//             return Color.RED;
//         } else if (patients >= 20) {
//             return Color.ORANGE;
//         } else if (patients >= 10) {
//             return Color.YELLOW;
//         } else {
//             return Color.GREEN;
//         }
//     }

//     private static class ButtonMouseListener extends MouseAdapter {
//         private int row;
//         private int col;

//         public ButtonMouseListener(int row, int col) {
//             this.row = row;
//             this.col = col;
//         }

//         @Override
//         public void mouseClicked(MouseEvent e) {
//             if (isSelecting) {

//                 // ลดฝุ่น 50% ที่ตำแหน่งที่ถูกกด
//                 pm25Levels[row][col] *= 0.5;
//                 buttons[row][col].setText(getButtonText(row, col));

//                 // ลดฝุ่น 30% ที่ตำแหน่งรอบข้างในวงกลม
//                 int[][] directions = {
//                         { -1, -1 }, { -1, 0 }, { -1, 1 }, // ทิศทางแนวบน
//                         { 0, -1 }, { 0, 1 }, // ทิศทางแนวนอน
//                         { 1, -1 }, { 1, 0 }, { 1, 1 } // ทิศทางแนวล่าง
//                 };

//                 for (int[] direction : directions) {
//                     int newRow = row + direction[0];
//                     int newCol = col + direction[1];
//                     if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
//                         pm25Levels[newRow][newCol] *= 0.7;
//                         buttons[newRow][newCol].setText(getButtonText(newRow, newCol));
//                         buttons[newRow][newCol].setBackground(getButtonColor(patientLevels[newRow][newCol])); // อัปเดตสีของปุ่มรอบข้าง
//                     }
//                 }

//                 buttons[row][col].setBackground(getButtonColor(patientLevels[row][col])); // อัปเดตสีของปุ่มที่ถูกกด
//                 isSelecting = true; // ปิดโหมดฝนหลังจากเลือกพื้นที่แล้ว

//             } else if (isRemoving) {
//                 // รีเซ็ตปุ่มที่ถูกกดเป็นสีเริ่มต้น
//                 buttons[row][col].setBackground(DEFAULT_COLOR);

//                 // รีเซ็ตปุ่มรอบข้างเป็นสีเริ่มต้น
//                 int[][] directions = {
//                         { -1, -1 }, { -1, 0 }, { -1, 1 }, // ทิศทางแนวบน
//                         { 0, -1 }, { 0, 1 }, // ทิศทางแนวนอน
//                         { 1, -1 }, { 1, 0 }, { 1, 1 } // ทิศทางแนวล่าง
//                 };

//                 for (int[] direction : directions) {
//                     int newRow = row + direction[0];
//                     int newCol = col + direction[1];
//                     if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
//                         buttons[newRow][newCol].setBackground(DEFAULT_COLOR);
//                     }
//                 }
//             }
//         }
//     }
// }
