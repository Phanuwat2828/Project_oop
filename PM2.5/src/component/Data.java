package component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;



public class Data {
    //  ArrayList<Float> persen = new ArrayList<>();
    // private int pm25[][] = new int[10][20] ;
    // private int people[][]= new int[10][20] ;
    // private float persen[][]= new float[10][20] ;

    private ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>() ;
    private ArrayList<ArrayList<Integer>> people = new ArrayList<>() ;
    private ArrayList<ArrayList<Float>> persen = new ArrayList<>() ;

    
    private Boolean status_rain = false;
    private Boolean status_file = false;
    private Boolean status_Error = true;
    private String defualt_data = "5000";
    private Color_all cl_all = new Color_all();
    private String people_string  = "5000";


    // ====================== Panel Table ======================

    private Color color_status[] = new Color[2];
    private Color color_bt ;

    // ====================== Alert ======================



    // ==================== Default Data ======================= 

    public Data(){
        setDefault_Data();
    }

    // =================== Real ===========================
    //================= set Methode ===============

    public void setPeople(int x,int y,int data){
        // this.people[x][y] = data;
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
    public void setError(Boolean data){
        this.status_Error = data;
    }

    //ดึงformatPeople มาเช็คว่าผู้ใช้งานกรอกตรงเงื่อนไขหรือไม่
    public void setPeople_str(String data) {
        this.people_string = data;
        int result = formatPeople();
        if (result < 0) {
            Alert.Error_alert("Please enter new information.", "Error");
        } else {
            people();
        }
    }
    
    public void setDefault_Data(){
        this.people.clear();
        this.pm25.clear();
        this.persen.clear();
        this.status_file = false;
        for(int i=0;i<10;i++){
            ArrayList<Integer> people = new ArrayList<>() ;
            ArrayList<Integer> pm25 = new ArrayList<>() ;
            ArrayList<Float> persen = new ArrayList<>() ;
            for(int j=0;j<20;j++){
                // this.people[i][j] = 5000;
                people.add(5000);
                pm25.add(0);
                persen.add((float) 0);
            }
            this.people.add(people);
            this.pm25.add(pm25);
            this.persen.add(persen);
        }
    }

    //================= get Methode ===============

    public ArrayList<ArrayList<Integer>> getPeople(){
        return this.people;
    }
    public ArrayList<ArrayList<Integer>> getPm25(){
        return this.pm25;
    }
    public Boolean getRain(){
        return this.status_rain;
    }
    public Boolean getStatusError(){
        return this.status_Error;
    }
    public Boolean getFile(){
        return this.status_file;
    }
    public String getDefualt_data(){
        return this.defualt_data;
    }
    public Color[] getColor_status(){
        return this.color_status;
    }
    public float getPersen(int row,int col){
        return this.persen.get(row).get(col);
    }
    public Color getColorbt(){
        return this.color_bt;
    }
    // =============== Create Data ================

    public Boolean Mistake(){
        return false;
    }

    public static boolean randomTrueWith5PercentChance(Double random_) {
        Random random = new Random();
        return random.nextDouble() < random_;
    }

    public void setStatus_all(int row,int colunm){
        int data_people = this.people.get(row).get(colunm);
        int data_pm = this.pm25.get(row).get(colunm);
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
    public float setStatus_persen(int data_people,int data_pm){
        float data_persen=0;
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

        data_persen  *= 0.01;
        return data_persen;
        
    }

    public void persen(){
        this.persen.clear();
        for(int i=0;i<this.pm25.size();i++){
            ArrayList<Float> persen_add = new ArrayList<>() ;
            for(int j=0;j<this.pm25.get(i).size();j++){
                persen_add.add(setStatus_persen(this.people.get(i).get(j), this.pm25.get(i).get(j)));
            }
            this.persen.add(persen_add);
        }
    }
    
    // public void showAlert(String message) {
    //     JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    // }


    public int[] getStatusData(int row,int col,int number_box){
        int data_people = this.people.get(row).get(col);
        int data_pm = this.pm25.get(row).get(col);
        float data_persen = this.persen.get(row).get(col);
        int[] data = new int[6];
        data[0] = data_pm;
        data[1] = data_people;
        data[2] = (int) (data_persen  * 100);
        data[3] = (int) (data_people *data_persen );
        data[4] = (data_people - (int) (data[3] ));
        data[5] = number_box;
        return data;
    }

    public int formatPeople(){
        String people = this.people_string;
        int start =0;
        int end = 0;
        int data;
        if(people.contains("-")){
            String pe[] = people.split("[-]");
            
            if(pe.length-1==1 && pe.length==2){
                try {
                    int data_random[] = new int[2];
                    data_random[0] = Integer.parseInt(pe[0]);
                    data_random[1] = Integer.parseInt(pe[1]);
                 

                    if (data_random[0] > data_random[1]) {
                        end=data_random[0];
                        start = data_random[1];
                    }else {
                        end=data_random[1];
                        start = data_random[0];
                    }

                    if(end==start){
                        data = start;
                    }else{
                        data = (int) (Math.random() * (end - start + 1)) + start;
                    }
                } catch (NumberFormatException e) {
                    data= -200; // Handle number format exception
                    
                }
            
            }else{  
                data = -200;

            }
        }else if(people.matches("\\d+")){   
            data = Integer.parseInt(people);
        }else{
            data = -300;
        }
        if(data<0){
            setError(false);
        }
        return data;
    }
    
    public void people(){
        this.people.clear();
        for(int i=0;i<this.pm25.size();i++){
            ArrayList<Integer> people = new ArrayList<>() ;
            for(int j=0;j<this.pm25.get(i).size();j++){
                people.add(formatPeople());
            }
            this.people.add(people);
        }
    }

    
}
