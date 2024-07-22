package component;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;




public class Button_input extends JPanel implements ActionListener{
    private int people = 5000;
    private int[][] pm25 = new int[10][20] ;
    private  JButton bt_count =new JButton("Select File");
    JTextField input_count = new JTextField(Integer.toString(this.people));

    public JPanel button(){
        JPanel input_bt = new JPanel(new FlowLayout(FlowLayout.CENTER,10,17));
        input_bt.setPreferredSize(new Dimension(800,80));
        input_bt.setBackground(null);
        
        JButton bt =new JButton("Select File");
        bt.setPreferredSize(new Dimension(100,35));
        bt.setBackground(new Color_all().cl_bg_bt);
        JLabel Label = new JLabel();
        Label.setFont(new Font_all().font_kanit(17, "Kanit-Bold.ttf"));

       
        bt_count.setPreferredSize(new Dimension(100,35));
        bt_count.setBackground(new Color_all().cl_bg_bt);
       
        input_count.setPreferredSize(new Dimension(200,35));

        Label.setPreferredSize(new Dimension(300,35));
        //  // เพิ่ม ActionListener ให้กับปุ่ม openButton
        bt.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
                fileChooser.setFileFilter(filter);

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                     // ดึงชื่อไฟล์และตั้งค่าให้กับ JLabel
                     File selectfile = fileChooser.getSelectedFile();
                     Label.setText(selectfile.getName());
                     try {
                        readFile(selectfile);
                        // JOptionPane.showMessageDialog(null, content, "File Content", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        // JOptionPane.showMessageDialog(null, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        bt_count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == bt_count){
                    setCount(Integer.parseInt(input_count.getText()));
                }
            }
            
        });

         input_bt.add(bt);
         input_bt.add(Label);
         input_bt.add(bt_count);
         input_bt.add(input_count);
        
        return input_bt;
    }
    public void actionPerformed(ActionEvent e) {
        // ไม่ได้ใช้ในโค้ดนี้ แต่ต้องมีเพราะ implements ActionListener
    }
    private void readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
       
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                int j=0;
                // content.append(line).append("\n");
                StringTokenizer tk = new StringTokenizer(line);
                
                for(;tk.hasMoreTokens();){
                    int data = Integer.parseInt(tk.nextToken());
                    System.out.print(data+" ");
                    this.pm25[i][j] = data;
                    j++;
                }
                System.out.print("|"+"\n");
                i++;
            }
        }
    }

    private void setCount(int num){
        this.people = num;
        System.out.print(this.people);
    }
    

    public int[][] getpm(){
        return this.pm25;
    }

    public int getcount(){
        return this.people;
    }

   
}
