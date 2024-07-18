package component;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;




public class Button_all{

    public JPanel button(){
         
         JPanel panel = new JPanel(new GridBagLayout());
         Color_all color = new Color_all();
         panel.setSize(200,200);
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.anchor = GridBagConstraints.CENTER;
         gbc.gridx = 0;
         gbc.gridy = 0;
         
         // สร้าง JButton สำหรับเลือกไฟล์
         JButton openButton = new JButton("Select File");
         gbc.gridx = 0;
         gbc.gridy = 0;
         openButton.setBackground(color.cl_bg);
         panel.add(openButton, gbc);
         // สร้าง JLabel สำหรับแสดงชื่อไฟล์ที่ถูกเลือก
        //  JLabel fileNameLabel = new JLabel("No file selected");
        //  gbc.gridx = 0;
        //  gbc.gridy = 1;
        //  panel.add(fileNameLabel, gbc);
         



        //  // เพิ่ม ActionListener ให้กับปุ่ม openButton
        // //  openButton.addActionListener(new ActionListener() {
        // //      public void actionPerformed(ActionEvent e) {
        // //          JFileChooser fileChooser = new JFileChooser();
        // //          int returnValue = fileChooser.showOpenDialog(null);
        // //          if (returnValue == JFileChooser.APPROVE_OPTION) {
        // //              // ดึงชื่อไฟล์และตั้งค่าให้กับ JLabel
        // //              fileNameLabel.setText(fileChooser.getSelectedFile().getName());
        // //          }
        // //      }
        // //  });
        
        return panel;
    }
    public JPanel button_radius (){
        JPanel frame = new JPanel();


        return frame;
        
    }

   
}
