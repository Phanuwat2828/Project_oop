package component;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
        JTextField input_count = new JTextField("5000"); //people
        JPanel input_bt = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 17));
        JButton bt_select_file = new JButton("Select File"); //select file
        JLabel Label = new JLabel(); //name file
        // =====================================================
        
        // =================== set ==============================
        input_bt.setPreferredSize(new Dimension(800, 80));
        bt_select_file.setPreferredSize(new Dimension(100, 35));
        bt_count.setPreferredSize(new Dimension(100, 35));
        input_count.setPreferredSize(new Dimension(200, 35));
        Label.setPreferredSize(new Dimension(300, 35));

        Label.setFont(new Font_all().font_Tahoma(17));
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
                if (returnValue == JFileChooser.APPROVE_OPTION) { //ture or false
                    File selectfile = fileChooser.getSelectedFile();// !ดึงค่าในไฟล์ที่เลือกมาเก็บไว้ในตัวแปร
                    Label.setText(selectfile.getName());// !แสดงชื่อไฟล์ที่เลือก
                    try {
                        // #ไม่เข้าใจ Methode ไหนให้ CTRL ค้าง และคลิกที่ Methode นั้น
                        readFile(selectfile);//! ส่งค่าไฟล์ที่เลือกมาไปยัง methode อ่านไฟล์
                        reset_status();// !เปลี่ยนค่ากลับไป default
                        updateTable();// !อัพเดทค่าไหม่ที่ส่งไฟล์เข้ามา
                    } catch (IOException ex) {
                       System.out.println(ex);
                    }
                }
            }
        });
        // Button Enter send count people to class Data
        bt_count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == bt_count) {
                    String data = input_count.getText();
                    if(data!=null){
                        input_count.setText(null);
                        data_tr.setPeople_str(data); 
                        updateTable();
                        reset_status();
                    }else{
                        alert.Error_alert("!People is null", "Error People");
                    }
                   
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
        btn.setFont(new Font_all().font_Tahoma(20));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn) {
                    for (int i = 0; i < data_tr.getPm25().size(); i++) {
                        for (int j = 0; j < data_tr.getPm25().get(i).size(); j++) {
                            if(data_tr.getFile()){
                                if(data_tr.getPeople(i,j)>=0){
                                    int pm25_rain = data_tr.getPm25(i, j)-50; // !ดึงค่าออกมาลบ 50
                                    if(pm25_rain>=0 ){ // !แล้วถามว่าที่ลบไปติดลบไหม ถ้าไม่ติดให้ update ค่าไปเลย แต่ถ้าติด - 
                                        data_tr.setPm25(i, j, (int) pm25_rain);
                                    }else if(data_tr.getPm25(i, j)>=0){
                                        data_tr.setPm25(i, j, (int) 0);
                                    }
                                }else{
                                    // !Alert
                                    alert.Error_alert("Check People StatusError: ["+Integer.toString(data_tr.getPeople(i,j))+"]  !Please enter people again  ", "Error People");
                                    return;
                                }
                            }else{
                                alert.Error_alert("You forgot to enter the file.", "Alert Files!");
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
        btn2.setFont(new Font_all().font_Tahoma(20));

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(data_tr.getFile()){
                    data_tr.setRain(!data_tr.getRain());// !เปลี่ยน สถานะเป็นtrue เพื่อเปิดโหมดฝนเทียม
                    // updateTable();
                    btn2.setText(data_tr.getRain() ? "Stop": "Atificial Rain"); // !เปลี่ยนคำเมื่อกด ปุ่ม
                    btn2.setBackground(data_tr.getRain() ? new Color_all().cl_bg_red:new Color(215, 156, 229));
                }else{
                    alert.Error_alert("You forgot to enter the file.", "Alert Files!");
                }
            }
        });
        return btn2;
    }

    // ================== Back ==================== กลับไป menu
    public JButton back() {
        JButton btn2 = new JButton("Back to Manu");
        btn2.setBounds(20, 150, 170, 40);
        btn2.setBackground(new Color_all().cl_bg_red);
        btn2.setFont(new Font_all().font_Tahoma(20));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data_tr.getCardLayout().show(data_tr.getMainPanel(), "Menu");
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
        tablePanel.repaint(); // !รีค่าใน panel ไหม่
    }

    // =================== Read ================ อ่าน ไฟล์
    public void readFile(File file) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            data_tr.setFile(true);
            int count =0;
            ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>() ;
            while ((line = br.readLine()) != null) { // !อ่านไฟล์ไปที่ละแถว เช่น 12 34 56 78 90 จน กว่าแถวจะเป็น null
                StringTokenizer tk = new StringTokenizer(line); // !เก็บ ค่าแถวแล้วนำไป แยกเป็น เลขออกทีละตัว 
                ArrayList<Integer> data_pm = new ArrayList<>() ;
                for (; tk.hasMoreTokens();) {// !เช็คว่าเป็นตัวต่อไปเป็น null ไหม
                    String data_str = tk.nextToken(); // !แยกตัวเลขออกจากแถวทีละตัว
                    count+=1;
                    if(data_tr.check_data(data_str)){// !ส่งค่าที่แยกออกไปเช็ค ว่ามี text
                        int data = Integer.parseInt(data_str); // !แปลงเป็น int
                        // สุ่มความผิดพลาด 5% pm =50
                        if(Data.randomTrueWith5PercentChance(0.05)){ // !โอกาสความผิดพลาด 5%
                            data = data + (int) (Math.random() * (-data)+(int)data/2); //! สุ่มค่าความผิดพลาด เช่น pm 50  จะสุ่มตั้งแต่ -50 ถึง 50/2 แล้วเก็บลง data 
                        }
                        data_pm.add(data); // !add ลง datapm
                    }else{ // !ถ้ามี text ให้เช็ด pm25 = -1 เพื่อแสดง error
                        data_pm.add(-1);
                    }
                }
                pm25.add(data_pm);
            }
            if(count>200){// !เช็คว่าเกิน 200 สถานีไหม
                alert.Error_alert("Error Station are more than 200 Check Your File or change File", "Alert Error Station");
                data_tr.setDefault_Data();
            }else{// !ไม่เกิน ให้โยนค่าไปเก็บเลย
                data_tr.setPm25(pm25); 
            }  
        } catch (IOException e) {
        }
    }
}