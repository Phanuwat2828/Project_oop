package component;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_all {

    public JPanel button_import(){
         
         JPanel panel = new JPanel(new GridBagLayout());
         panel.setSize(400,200);
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.anchor = GridBagConstraints.CENTER;
         gbc.gridx = 0;
         gbc.gridy = 0;
         
         // สร้าง JButton สำหรับเลือกไฟล์
         JButton openButton = new JButton("Select File");
         gbc.gridx = 0;
         gbc.gridy = 0;
         panel.add(openButton, gbc);
         
         // สร้าง JLabel สำหรับแสดงชื่อไฟล์ที่ถูกเลือก
         JLabel fileNameLabel = new JLabel("No file selected");
         gbc.gridx = 0;
         gbc.gridy = 1;
         panel.add(fileNameLabel, gbc);
         
         // เพิ่ม ActionListener ให้กับปุ่ม openButton
         openButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 JFileChooser fileChooser = new JFileChooser();
                 int returnValue = fileChooser.showOpenDialog(null);
                 if (returnValue == JFileChooser.APPROVE_OPTION) {
                     // ดึงชื่อไฟล์และตั้งค่าให้กับ JLabel
                     fileNameLabel.setText(fileChooser.getSelectedFile().getName());
                 }
             }
         });
        
        return panel;
    }
}
