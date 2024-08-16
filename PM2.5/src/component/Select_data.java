package component;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Select_data implements ActionListener {
    // ================ Attribute ======================== 
    private Data data_tr;
    private JButton bt_count = new JButton("Enter");
    private JPanel tablePanel;
    private JPanel status;
    private Alert alert = new Alert();

    // =================================================

    public JPanel button(JPanel panelTable, JPanel status,Data data_tr) {
        // ================ Setdata ==========
        this.tablePanel = panelTable;
        this.status = status;
        this.data_tr = data_tr;
        // ======================================

        // =================== Layout ============-=============
        JTextField input_count = new JTextField("5000");
        JPanel input_bt = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 17));
        JButton bt_select_file = new JButton("Select File");
        JLabel Label = new JLabel();
        // =====================================================
        
        // =================== set ==============================
        input_bt.setPreferredSize(new Dimension(800, 80));
        bt_select_file.setPreferredSize(new Dimension(100, 35));
        bt_count.setPreferredSize(new Dimension(100, 35));
        input_count.setPreferredSize(new Dimension(200, 35));
        Label.setPreferredSize(new Dimension(300, 35));

        Label.setFont(new Font_all().font_kanit(17, "Kanit-Bold.ttf"));
        bt_count.setBackground(new Color_all().cl_bg_bt);
        bt_select_file.setBackground(new Color_all().cl_bg_bt);
        input_bt.setBackground(null);
        // =========================================================

        // !Select Files Button Action
        bt_select_file.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Select File 
                // !เลือกไฟล์
                JFileChooser fileChooser = new JFileChooser();
                // !ใช้สำหรับคัดกลองว่าต้องเป็นไฟล์ txt เท่านั้น
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
                // !set ลงfile Chooser
                fileChooser.setFileFilter(filter);
                // !คือการเปิดให้เลือกไฟล์
                int returnValue = fileChooser.showOpenDialog(null);
                 // !เมื่อเปรียบเทียบ returnValue กับ JFileChooser.APPROVE_OPTION จะทำให้รู้ว่าเลือกไฟล์ไปแล้ว
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectfile = fileChooser.getSelectedFile();// !ดึงค่าไฟล์ที่เลือกมา
                    Label.setText(selectfile.getName());// !ชื่อไฟล์ที่เลือก
                    try {
                        readFile(selectfile);//! ส่งค่าไฟล์ที่เลือกมาไปยัง methode อ่านไฟล์
                        reset_status();// !เปลี่ยนค่ากลับไป default
                        updateTable();// !อัพเดทค่าไหม่ที่ส่งไฟล์เข้ามา
                    } catch (IOException ex) {
                       System.out.println(ex);
                    }
                }
            }
        });

        bt_count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == bt_count) {
                    String data = input_count.getText();
                    input_count.setText(null);
                    data_tr.setPeople_str(data);
                    // alert_text.showErrorDialog("ERROR_ONE", "ERROR_TWO");
                    

                    updateTable();
                    reset_status();
                }
            }

        });
        // ================== add ====================

        input_bt.add(bt_select_file);
        input_bt.add(Label);
        input_bt.add(bt_count);
        input_bt.add(input_count);

        return input_bt;
    }

    // ================== Rain ================= ฝนธรรมชาติ
    public JButton rain() {
        JButton btn = new JButton("RAIN");
        btn.setBounds(20, 20, 170, 70);
        btn.setBackground(new Color(215, 156, 229));
        btn.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn) {
                    for (int i = 0; i < data_tr.getPm25().size(); i++) {
                        for (int j = 0; j < data_tr.getPm25().get(i).size(); j++) {
                            if(data_tr.getPeople(i,j)>=0){
                                int pm25_rain = data_tr.getPm25(i, j)-50;
                                if(pm25_rain>=0 ){
                                    data_tr.setPm25(i, j, (int) pm25_rain);
                                }else if(data_tr.getPm25(i, j)>=0){
                                    data_tr.setPm25(i, j, (int) 0);
                                }
                            }else{
                                // !Alert
                                alert.Error_alert("Check People StatusError: ["+Integer.toString(data_tr.getPeople(i,j))+"]  !Please enter people again  ", "Error People");
                                return;
                            }
                        }
                    }
                    updateTable();
                    reset_status();

                }
            }
        });
        return btn;
    }

    // ==================== Rain ================ ฝนเทียม
    public JButton rain_two() {
        JButton btn2 = new JButton("Atificial Rain");
        btn2.setBounds(250, 20, 170, 70);
        btn2.setBackground(new Color(215, 156, 229));
        btn2.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data_tr.setRain(!data_tr.getRain());
                updateTable();
                btn2.setText(data_tr.getRain() ? "Stop": "Atificial Rain");
                btn2.setBackground(data_tr.getRain() ? new Color_all().cl_bg_red:new Color(215, 156, 229));
            }
        });
        return btn2;
    }

    // ================== Back ==================== กลับไป menu
    public JButton back() {
        JButton btn2 = new JButton("Back to Manu");
        btn2.setBounds(20, 150, 170, 40);
        btn2.setBackground(new Color_all().cl_bg_red);
        btn2.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Back");
            }
        });

        return btn2;
    }

    public void actionPerformed(ActionEvent e) {
       
    }


    // =================== Status =============== reset ค่าในstatus
    // !Reset ค่า Status ให้เป็น default ค่าเริ่มต้น
    public void reset_status() {
        this.status.removeAll();// !ลบค่าสถานะที่เคยค้างไว้ออก
        Color color_t[] = { new Color(135, 135, 135), new Color(215, 215, 215) };
        middle new_status = new middle(new int[6], color_t);// !ส่งค่าไปยัง Methode ที่สร้างกล่องบอกสถาณะ
        this.status.add(new_status);// !แล้วเพิ่ม Object jpanel เข้าไปไหม่

    }



    // ================== Udate ================== Upsate ค่า table
    // !Reset ค่า สถานี ให้เป็น ค่าไหม่ที่อัพเดทจากไฟล์ไหม่ ค่าเริ่มต้น
    private void updateTable() {
        tablePanel.removeAll();// !ลบค่าสถานีเก่าออก
        Panel_table newTable = new Panel_table(status, data_tr); //!สร้าง object และส่งพารามิเคอร์ object status และ data เข้าไป
        tablePanel.add(newTable);// !แล้วเพิ่ม Object jpanel เข้าไปไหม่
        tablePanel.revalidate();
        tablePanel.repaint(); // !รีค่าไหม่ panel ไหม่
    }

    // =================== Read ================ อ่าน ไฟล์
    public void readFile(File file) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            data_tr.setFile(true);
            int count =0;
            ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>() ;
            while ((line = br.readLine()) != null) {

                StringTokenizer tk = new StringTokenizer(line);

                ArrayList<Integer> data_pm = new ArrayList<>() ;
                for (; tk.hasMoreTokens();) {
                    String data_str = tk.nextToken();
                    count+=1;
                    if(check_data(data_str)){
                        int data = Integer.parseInt(data_str);
                        System.out.print(data + " ");
                        // สุ่มความผิดพลาด 5%
                        if(Data.randomTrueWith5PercentChance(0.05)){
                            data =data + (int) (Math.random() * (-data)+(int)data/2);  
                        }
                        data_pm.add(data);
                    }else{
                        System.out.print(data_str + " ");
                        data_pm.add(-1);
                    }
                }
                pm25.add(data_pm);
                System.out.print("|" + "\n");
            }
            if(count>200){
                data_tr.setDefault_Data();
            }else{
                data_tr.setPm25(pm25);
            }  
        } catch (IOException e) {
            
        }
    } 

    // ==================== Check_data Pm2.5 ========= เช็ค ว่ามี text ใน file txt
    public Boolean check_data(String data){
        Boolean check_str = false;
        for(int i=0;i<data.length();i++){
            if(Character.isDigit(data.charAt(i)) || data.charAt(i)=='-'){
                check_str = true;
            }else{
                check_str = false;
                break;
            }
        }
        return check_str;

    }
}