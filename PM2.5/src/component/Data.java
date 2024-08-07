package component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;



public class Data {
    // Atribute Main Data
    private ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>() ; // !เก็บค่า pm2.5
    private ArrayList<ArrayList<Integer>> people = new ArrayList<>() ;// !เก็บจำนวณคน
    private ArrayList<ArrayList<Float>> percent = new ArrayList<>() ;// !เก็บค่าอัตราการป๋วยของผู้คน
    
    // Atribute Status and default Data
    private Boolean status_rain = false; // !สถานะการกดปุ่มฝนเทียมว่าทำงานอยู่หรือไม่
    private Boolean status_file = false;// !สถานะว่าไฟล์เข้ามาทำงานหรือยัง
    private Color_all cl_all = new Color_all(); // !class ของสีที่เก็บไว้ใน project
    private String people_string  = "5000"; // !ขอมูลจำนวณคนเริ่มแรก

    // Panel Table Atribute 
    // !สำหรับทำงานกับ Class panel table

    private Color color_status[] = new Color[2]; // !เก็บสีของสถานะบอกผู้ป๋วย pm จำนวณคนทั้งหมด
    private Color color_bt ; // !สีของสถานนี 10X20

    // ====================== Alert ======================



    // ==================== Default Data ======================= 

    public Data(){
        setDefault_Data();
    }
    // Mutetor Mothode
    // *================= set Methode ===============*
    // !Array ปกติ data[1][1] = Array List data.get(1).get(1) เรียกค่า
    // !Array ปกติ data[1][1] = 13 = Array List data.get(1).set(1,13) setค่าตามตำแหน่ง
    // !Array ปกติ data[1][1] = 13 = Array List data.add(13) setค่าตามตำแหน่ง ถ้าไม่มีค่าใน array list

    public void setPeople(int x,int y,int data){
        this.people.get(x).set(y,data);
    }
    public void setPm25(ArrayList<ArrayList<Integer>> data){
        this.pm25.clear();
        this.pm25 = data;
    }
    public void setPm25(int i,int j ,int data){
        this.pm25.get(i).set(j, data); 
    }
    public void setRain(Boolean data){
        this.status_rain = data;
    }
    public void setFile(Boolean data){
        this.status_file = data;
    }
    public void setPeople_str(String data){
        this.people_string = data;
        int result = formatPeople();
        if (result < 0) {
            Alert.Error_alert("Check People StatusError: ["+Integer.toString(result)+"]  !Please enter people again ", "Error People");
        } else {
            people();
        }
    }
    // Default_Data Methode 
    // ! เมื่อเปิดโปรแกรม constructor จะเรียก Methode นี้เพื่อกำหนดข้อมูล
    // ! ที่เป็นข้อมูลเริ่มต้น pm จะถูกกำหนดที่ 0 percent ก็เช่นเดียวกัน แต่ people จะถูกเช็ตที่ 5000
    // * Array ขนาด 10X20 
    public void setDefault_Data(){
        // & ล้างข้อมูลที่อยู่ใน array ทั้งหมดเพื่อเข้า mode Default
        this.people.clear();
        this.pm25.clear();
        this.percent.clear();

        // ! Set ค่าไฟล์ว่ายังไม่มีไฟล์เข้ามาทำงาน
        this.status_file = false;

        for(int i=0;i<10;i++){
            ArrayList<Integer> people = new ArrayList<>() ;
            ArrayList<Integer> pm25 = new ArrayList<>() ;
            ArrayList<Float> percent = new ArrayList<>() ;
            for(int j=0;j<20;j++){
                people.add(5000);
                pm25.add(0);
                percent.add((float) 0);
            }
            this.people.add(people);
            this.pm25.add(pm25);
            this.percent.add(percent);
        }
    }

    //*================= get Methode ===============*
    // !Array ปกติ data[1][1] = Array List data.get(1).get(1) เรียกค่า
    // !Array ปกติ data[1][1] = 13 = Array List data.get(1).set(1,13) setค่าตามตำแหน่ง
    // !Array ปกติ data[1][1] = 13 = Array List data.add(13) setค่าตามตำแหน่ง ถ้าไม่มีค่าใน array list
    public ArrayList<ArrayList<Integer>> getPeople(){
        return this.people;
    }
    public ArrayList<ArrayList<Integer>> getPm25(){
        return this.pm25;
    }
    public int getPeople(int row,int col){
        return this.people.get(row).get(col);
    }
    public int getPm25(int row,int col){
        return this.pm25.get(row).get(col);
    }
    public Boolean getRain(){
        return this.status_rain;
    }
    public Boolean getFile(){
        return this.status_file;
    }
    public String getDefualt_data(){
        return "5000";
    }
    public Color[] getColor_status(){
        return this.color_status;
    }
    public float getPersen(int row,int col){
        return this.percent.get(row).get(col);
    }
    public Color getColorbt(){
        return this.color_bt;
    }
    // Get Status Data of Station
    // !ดึงข้อมูล ที่ต้องการโชว์เพื่องบ่งบอกค่าสถานี
    // * เช่น pm: 45 people:5000 percent:5.5 Sick People:550 Healty people: 4450 Station Number:45
    // #ไม่เข้าใจ Methode ไหนให้ CTRL ค้าง และคลิกที่ Methode นั้น
    public int[] getStatusData(int row,int col,int number_box){
        int data_people =getPeople(row, col);
        int data_pm =getPm25(row, col);
        float data_percent =getPersen(row, col);
        int[] data = new int[6];
        data[0] = data_pm;
        data[1] = data_people;
        data[2] = (int) (data_percent  * 100); // !คูณ 100 เพื่อเปลงค่าจำนวณ
        data[3] = (int) (data_people *data_percent );
        data[4] = (data_people - (int) (data[3] ));
        data[5] = number_box;
        return data;
    }

    // =============== Create Data ================
    // !สร้างข้อมูล หรือ process ข้อมูล


    public Boolean Mistake(){
        return false;
    }

    // Random_Mistake Methode
    // !สุ่มความผิดพลาด ตาม ค่าที่ส่งเข้ามา 
    // *ค่าที่ส่งเข้ามาคือ % ที่จะเกิดความผิดพลาด
    public static boolean randomTrueWith5PercentChance(Double random_) {
        Random random = new Random();
        // &return True or False
        return random.nextDouble() < random_;
    }

    // Status Color Methode
    // !Set ค่าสีของสถานี และ เก็บค่าสี กล่องบอกสถาณะของสถานี เช่นถ้า pm2.5 
    // !มี 101 จะเก็บสีส้มไว้ใน Atribute bt และ status ก็เช่นเดียวกันแต่เก็บสองสี
    // *ค่าที่ส่งเข้ามาคือ ตำแหน่งของ array หรือว่าง่ายๆคือ ตำแหน่งของสถาณี ย้ำว่าตำแหน่งไม่ไช่ลำดับของสถานี
    public void setStatus_all(int row,int colunm){
        int data_people = getPeople(row, colunm);
        int data_pm = getPm25(row, colunm);
        // ? เช็คว่าจำนวณคนมีค่าน้อยกว่า 0 หรือไม่ และ ค่าสถาณะไฟล์เข้ามาทำงานหรือยัง
        // ~ ผลลัพทธ์ุ คือ ถ้าตรงตามเงื่อนไขสมารถ set สีตามปกติ แต่ ถ้าไม่จะ set สีเป็นสีเทา
        if(data_people>=0 && this.status_file){
            if (data_pm >= 0 && data_pm <= 50) {
                this.color_bt = Color.GREEN;
                this.color_status = cl_all.getStatusGreen();
            } else if (data_pm>= 51 && data_pm <= 100) {
                this.color_bt = Color.YELLOW;
                this.color_status =cl_all.getStatusYellow();
            } else if (data_pm >= 101 && data_pm<= 150) {
                this.color_bt = cl_all.cl_bg_or;
                this.color_status = cl_all.getStatusOrange();
            } else if (data_pm>= 151) {
                this.color_bt = Color.RED;
                this.color_status =cl_all.getStatusRed();
            } else if(data_pm<0){
                this.color_bt = new Color(135, 135, 135);
                this.color_status =cl_all.getStatusGray();
            }
        }else{
            this.color_bt = new Color(135, 135, 135);
            this.color_status =cl_all.getStatusGray();
        } 
        
    }
    // Random Percent 
    // !สุ่มค่า % สมมติ ถ้า pm 123 จะสุ่มค่าตั้งแต่ 20-29 อาจจะได้ค่า 23.34%
    // กำลังปรับแก้ตามความสามารถ
    public float setStatus_percent(int data_people,int data_pm){
        float data_persen=0;
        // ? เช็คว่าจำนวณคนมีค่าน้อยกว่า 0 หรือไม่ และ ค่าสถาณะไฟล์เข้ามาทำงานหรือยัง
        // ~ ผลลัพทธ์ุ คือ ถ้าตรงตามเงื่อนไขสมารถ set ตามปกติ แต่ ถ้าไม่จะ set ค่าเป็น 0
        if(data_people>=0 && this.status_file){
            if (data_pm >= 0 && data_pm <= 50) {
                data_persen = (int) (Math.random() * (10)) + 0;

            } else if ( data_pm >= 51 &&  data_pm  <= 100) {
                data_persen = (int) (Math.random() * (20 - 10)) + 10;

            } else if ( data_pm  >= 101 &&  data_pm <= 150) {
                data_persen = (int) (Math.random() * (30 - 20)) + 20;

            } else if ( data_pm >= 151) {
                data_persen  = (int) (Math.random() * (51 - 30)) + 30;

            } else if( data_pm <0){
                data_persen  = 0;
            }
        }else{
            data_persen  = 0;
        }
        // !สมมติได้ค่า 23.34 ต้องนำมาคูณ 0.01 ก่อนนำไปคำนวณทางคณิตศาสตร์
        data_persen  *= 0.01;
        // ~ 0.2334
        return data_persen;
    }
    // Set Percent ลงใน Atribute
    public void persen(){
        this.percent.clear();
        for(int i=0;i<this.pm25.size();i++){
            ArrayList<Float> percent_add = new ArrayList<>() ;
            for(int j=0;j<this.pm25.get(i).size();j++){
                // !เรียกใช้ setStatus_percent 
                // #ไม่เข้าใจ Methode ไหนให้ CTRL ค้าง และคลิกที่ Methode นั้น
                percent_add.add(setStatus_percent(getPeople(i, j), getPm25(i, j)));
            }
            this.percent.add(percent_add);
        }
    }
    // Process Data People 
    // !ปรับแก้ข้อมูลให้ได้ตามที่ต้องการ
    public int formatPeople(){
        // !ข้อมูลที่ป้อนเข้ามา
        String people = this.people_string;
        int start =0;
        int end = 0;
        int data;
        // ?หาว่ามี ช่วงไหมเช่น 100-5000 or 50000-100 or -100
            // & Random เช่น 100-5000
        // ??ถ้าไม่มี ให้ไปถามต่อว่าเป็นตัวเลขไหม
            // &แปลงค่าเป็น int แล้วเก็บใว้ใน Data
        // ?ไม่ตรงเงื่อนไขไหนเลย
            // &ให้ Data -300
        if(people.contains("-")){
            // !Split 100-5000 เอา "-" ออก จะได้ '100','5000' เป็น array
            String pe[] = people.split("[-]");
            try {
                int data_random[] = new int[2];
                // !เมื่อได้สองค่าแล้ว นำมาแปลง เป็น int
                data_random[0] = Integer.parseInt(pe[0]);
                data_random[1] = Integer.parseInt(pe[1]);
                // !หาว่าใครมีค่ามากสุด เช่น ถ้ามี '100','5000' end = 5000 start = 100 เพื่อนำไป Random
                if (data_random[0] > data_random[1]) {
                    end=data_random[0];
                    start = data_random[1];
                }else {
                    end=data_random[1];
                    start = data_random[0];
                }
                // !ถ้าค่าเท่ากันเช่น 5000-5000 data = 5000
                if(end==start){
                    data = start;
                }else{
                    // !Random 100-5000 data = Random
                    data = (int) (Math.random() * (end - start + 1)) + start;
                }
            } catch (NumberFormatException e) {
                data= -200; // Handle number format exception
                // ! Alert
            }
        }else if(people.matches("\\d+")){
            // !"\\d+": เป็น Regular Expression (regex) ที่ใช้ในการตรวจสอบสตริง
            // !\\d เป็นรูปแบบ regex ที่ตรงกับตัวเลขใดๆ (0-9)
            // !เครื่องหมาย + หมายถึง "หนึ่งตัวหรือมากกว่า" ของตัวที่อยู่ก่อนหน้า ดังนั้น \\d+ จะตรงกับกลุ่มของตัวเลขหนึ่งตัวหรือมากกว่า 
            // !people.matches("\\d+") return ture and false
            data = Integer.parseInt(people);
        }else{
            data = -300;
            // ! Alert
        }
        // ~ return ค่าออกไปเป็น int
        return data;
    }
    
    // Set จำนวณคน
    // !Array ปกติ data[1][1] = Array List data.get(1).get(1) เรียกค่า
    // !Array ปกติ data[1][1] = 13 = Array List data.get(1).set(1,13) setค่าตามตำแหน่ง
    // !Array ปกติ data[1][1] = 13 = Array List data.add(13) setค่าตามตำแหน่ง ถ้าไม่มีค่าใน array list
    public void people(){
        // !ล้างข้อมูล Array list
        this.people.clear();
        for(int i=0;i<this.pm25.size();i++){
            ArrayList<Integer> people = new ArrayList<>() ;
            for(int j=0;j<this.pm25.get(i).size();j++){
                 // #ไม่เข้าใจ Methode ไหนให้ CTRL ค้าง และคลิกที่ Methode นั้น
                people.add(formatPeople());
            }
            this.people.add(people);
        }
    }

    
}
