

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.filechooser.FileNameExtensionFilter;

import component.Color_all;
import component.Font_all;
// import component.Button_input;
import component.ColorPanel;
import component.buttonRain;
import component.middle;
import component.read_data;

public class Main_ {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PM2.5 version alpha");
        Button_input bt_input = new Button_input();
        int data_start[] = {0,0,0,0,0};
        middle box_status = new middle(data_start);
        Panel_table panelTable = new Panel_table(new int[10][20] ,5000,box_status);
       
       
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
        JPanel content_1 = new JPanel();
        JPanel content_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // ======================= Panel_1 ===============================
        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel_1.setBackground(new Color_all().cl_bg);

        // ================== content_1 ===================
 
        content_1.setPreferredSize(new Dimension(800,700));
        content_1.setBackground(new Color_all().cl_bg);

        JPanel Tapbar = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        Tapbar.setPreferredSize(new Dimension(800,100));
        JPanel Table = new JPanel(new FlowLayout(FlowLayout.CENTER,0,40));

        Table.setPreferredSize(new Dimension(800,500));
        JPanel inputfile = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        inputfile.setPreferredSize(new Dimension(800,100));

        // ================== content_2 ===================
        JPanel Rain = new JPanel();
        JPanel Status = new JPanel();
        // middle manageRect = new middle();
        String data[] = {"1","2","3","4","5"};

        // JLayeredPane layeredPane = manageRect.manageRect_all(data);
        Status.add(box_status);

        
        Status.setPreferredSize(new Dimension(450,480));
        Status.setBackground(new Color_all().cl_bg_red);
        Rain.setPreferredSize(new Dimension(450,200));
        Rain.setBackground(new Color_all().cl_bg_gray);
        //Rain
        buttonRain btnRain = new buttonRain();
        JButton rainButton = btnRain.rain();
        Rain.setLayout(null); 
        Rain.add(rainButton);

        //Atificial Rain
        buttonRain btnRainTwo = new buttonRain();
        JButton rainButtonTwo = btnRainTwo.rain_two();
        Rain.setLayout(null); 
        Rain.add(rainButtonTwo);
        content_2.setPreferredSize(new Dimension(450,700));
        // content_2.setLocation(800,0);
        content_2.setBackground(new Color_all().cl_bg_white);
        content_2.add(Status);
        content_2.add(Rain);
        


        // ====================== Tabbar ==================
        // Create the panels that will draw rectangles with different background colors
        JPanel redPanel = new ColorPanel(Color.RED, new Color(255, 200, 200),"มากกว่า 30%");
        JPanel orangePanel = new ColorPanel(new Color(255, 125, 0), new Color(255, 200, 150),"ตั้งแต่ 20-29%");
        JPanel yellowPanel = new ColorPanel(Color.YELLOW, new Color(255, 255, 200),"ตั้งแต่ 10-19%");
        JPanel greenPanel = new ColorPanel(Color.GREEN, new Color(200, 255, 200),"ตั้งแต่ 0-9%");

        // Add the color panels to panel2
        Tapbar.add(redPanel);
        Tapbar.add(orangePanel);
        Tapbar.add(yellowPanel);
        Tapbar.add(greenPanel);

        // ====================== Table ================== <== work here
        Table.add(panelTable);
        

        // ====================== inputfile ==================
        inputfile.add(bt_input.button(panelTable,box_status));
        inputfile.setBackground(new Color_all().cl_bg_white);
        
         // ========================= add panel ===============================
         GridBagConstraints gbc2 = new GridBagConstraints();
         gbc2.gridx=0;
         gbc2.gridy=0;
         content_1.add(Tapbar);
         content_1.add(Table);
         content_1.add(inputfile);
        
        // ====================== Add ===================================
        panel_1.add(content_1);
        
        gbc.gridx = 1;
        panel_1.add(content_2);
       
        
        frame.setIconImage(new ImageIcon(Main_.class.getResource("/image/mark2.png")).getImage());
        
        // pn1.add();
        // frame.setBackground(color.cl_bg);

        frame.setSize(1300,750);
        // frame.add(dp.button_import());
        // frame.setBackground(195,179,238);
        frame.add(panel_1);
        
        // =======================================================
        

        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}

class Panel_table extends JPanel implements ActionListener {
    private int[][] pm25;
    private int people = 5000;

    
    public Panel_table(int[][] pm,int people,JPanel data) {
        this.pm25 = pm;
        this.people = people;
        setLayout(new FlowLayout(FlowLayout.LEFT,2,8));
        setPreferredSize(new Dimension(705,500));
        updateTable(data);
    }
  
    

    public void updateTable(JPanel status) {
        removeAll(); // ล้างคอมโพเนนต์เดิม
       int box_number=0;
        for (int i = 0; i < pm25.length; i++) {
            for (int j = 0; j < pm25[i].length; j++) {
                box_number+=1;
                int row = i,coloumn =j,people_in = this.people,number=box_number;
                JButton bt = new JButton();
                bt.setPreferredSize(new Dimension(33, 33));
                if (pm25[i][j] >= 0 && pm25[i][j] <= 50) {
                    bt.setBackground(Color.GREEN);
                } else if (pm25[i][j] >= 51 && pm25[i][j] <= 100) {
                    bt.setBackground(Color.YELLOW);
                } else if (pm25[i][j] >= 101 && pm25[i][j] <= 150) {
                    bt.setBackground(new Color(255, 125, 0));
                } else if (pm25[i][j] >= 151 && pm25[i][j] <= 250) {
                    bt.setBackground(Color.RED);
                }
            
                bt.addActionListener(new ActionListener() {
                    int data_1[] = new int[5];
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int data = pm25[row][coloumn];
                        float persen =0;
                        Random rn =new Random();
                        System.out.println(row+","+coloumn+" = "+data);
                        if(data>=0 && data<=50){
                            persen =  rn.nextInt(0,10);
                        }else if(data>=51 && data<=100){
                            persen =  rn.nextInt(11,20);
                        }else if(data>=101 && data<=150){
                            persen =  rn.nextInt(20,30);
                        }else if(data>=151 && data<=250){
                            persen =  rn.nextInt(30,51);
                        } 
                        persen*=0.01;
                        persen= formatFloat(persen, 2);
                        status.removeAll();
                        data_1[0] = people_in;
                        data_1[1] =(int)(persen*100);
                        data_1[2] =(int)(people_in*persen);
                        data_1[3] = (people_in-(int)(people_in*persen));
                        data_1[4] = number;
                        
                        middle re_status = new middle(data_1);
                        status.add(re_status);
                        status.revalidate();
                        status.repaint();
                        
                    }
                });
                add(bt);
            }
        }
        revalidate();
        repaint();
    }
    
    public static float formatFloat(float value, int decimalPlaces) {
        String formatString = String.format("%." + decimalPlaces + "f", value);
        return Float.parseFloat(formatString);
    }

    // public void setPm25(int[][] pm25) {
    //     this.pm25 = pm25;
    //     updateTable();
    // }


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}


class Button_input implements ActionListener{
    private int people = 5000;
    private int[][] pm25 = new int[10][20] ;
    private  JButton bt_count =new JButton("Select File");
    JTextField input_count = new JTextField(Integer.toString(this.people));
    private JPanel tablePanel;
    private JPanel status;
   
    

    public JPanel button(JPanel panelTable ,JPanel status){
        this.tablePanel = panelTable;
        this.status = status;
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
                       reset_status();
                        updateTable();
                        
                       
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
                    updateTable();
                    reset_status();
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
    public void reset_status(){
        this.status.removeAll();
        middle new_status = new middle(new int[5]);
        this.status.add(new_status);
        
    }
    private void updateTable() {
        // Remove old components and update the table with new data
        tablePanel.removeAll();
        Panel_table newTable = new Panel_table(pm25,people,status);
        tablePanel.add(newTable);
        tablePanel.revalidate();
        tablePanel.repaint();
    }
    public void readFile(File file) throws IOException {
        // StringBuilder content = new StringBuilder();
       
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