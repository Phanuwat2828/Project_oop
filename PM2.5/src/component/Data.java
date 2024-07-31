package component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Data {
    //  ArrayList<Float> persen = new ArrayList<>();
    private int pm25[][] ;
    private int people[][];
    private float persen[][];

    // private ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>() ;
    // private ArrayList<ArrayList<Integer>> people = new ArrayList<>() ;
    // private ArrayList<ArrayList<Integer>> persen = new ArrayList<>() ;

    
    private Boolean status_rain = false;
    private Boolean status_file = false;
    private Boolean status_Error = true;
    private String defualt_data = "5000";
    private Color_all cl_all = new Color_all();

    // ====================== Panel Table ======================

    private Color color_status[] = new Color[2];
    private Color color_bt ;

    // ==================== Default Data ======================= 

    public Data(){
        for(int i=0;i<10;i++){
            for(int j=0;j<20;j++){
                this.people[i][j] = 5000;
            }
        }
    }

    // =================== Real ===========================
       //================= Get Methode ===============

    public void setPeople(int x,int y,int data){
        this.people[x][y] = data;
    }
    public void setPm25(int x,int y,int data){
        this.pm25[x][y] = data;
    }
    public void setPm25(int[][] data){
        
        this.pm25 = data;
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

        //================= Set Methode ===============

    public int[][] getPeople(){
        return this.people;
    }
    public int[][] getPm25(){
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
        return this.persen[row][col];
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
        if(people[row][colunm]>=0 && this.status_file){
            if (pm25[row][colunm] >= 0 && pm25[row][colunm] <= 50) {
                this.color_bt = Color.GREEN;
                this.color_status = cl_all.getStatusGreen();
            } else if (pm25[row][colunm] >= 51 && pm25[row][colunm] <= 100) {
                this.color_bt = Color.YELLOW;
                this.color_status =cl_all.getStatusYellow();
            } else if (pm25[row][colunm] >= 101 && pm25[row][colunm] <= 150) {
                this.color_bt = cl_all.cl_bg_or;
                this.color_status = cl_all.getStatusOrange();
            } else if (pm25[row][colunm] >= 151) {
                this.color_bt = Color.RED;
                this.color_status =cl_all.getStatusRed();
            } else if(pm25[row][colunm]<0){
                this.color_bt = new Color(135, 135, 135);
                this.color_status =cl_all.getStatusGray();
            }
        }else{
            this.color_bt = new Color(135, 135, 135);
            this.color_status =cl_all.getStatusGray();
        }
        
    }
    public void setStatus_persen(int row,int colunm){
        if(people[row][colunm]>=0 && this.status_file){
            if (pm25[row][colunm] >= 0 && pm25[row][colunm] <= 50) {
                this.persen[row][colunm] = (int) (Math.random() * (10)) + 0;

            } else if (pm25[row][colunm] >= 51 && pm25[row][colunm] <= 100) {
                this.persen[row][colunm]  = (int) (Math.random() * (20 - 10)) + 10;

            } else if (pm25[row][colunm] >= 101 && pm25[row][colunm] <= 150) {
                this.persen[row][colunm]  = (int) (Math.random() * (30 - 20)) + 20;

            } else if (pm25[row][colunm] >= 151) {
                this.persen[row][colunm]  = (int) (Math.random() * (51 - 30)) + 30;

            } else if(pm25[row][colunm]<0){
                this.persen[row][colunm]  = 0;
            }
        }else{
            this.persen[row][colunm]  = 0;
        }

        this. persen[row][colunm]  *= 0.01;
        
    }

    public int[] getStatusData(int row,int col,int number_box){
        int[] data = new int[6];
        data[0] = this.pm25[row][col];
        data[1] = this.people[row][col];
        data[2] = (int) (this.persen[row][col]  * 100);
        data[3] = (int) (people[row][col] * this.persen[row][col] );
        data[4] = (this.people[row][col] - (int) (this.people[row][col] * this.persen[row][col] ));
        data[5] = number_box;
        return data;
    }

    
}
