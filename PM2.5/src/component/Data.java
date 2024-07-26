package component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Data {
    private int pm25[][] =new int[10][20];
    private int people[][] = new int[10][20];
    private Boolean status_rain = false;
    private Boolean status_file = false;
    private String defualt_data = "5000";
    private Color_all cl_all = new Color_all();
    // ====================== Panel Table ======================
    private Color color_status[] = new Color[2];
    private float persen ;
    private Color color_bt ;
    private int data_status;
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
    public Boolean getFile(){
        return this.status_file;
    }
    public String getDefualt_data(){
        return this.defualt_data;
    }
    public Color[] getColor_status(){
        return this.color_status;
    }
    public float getPersen(){
        return this.persen;
    }
    public Color getColorbt(){
        return this.color_bt;
    }
        // =============== Create Data ================

    public Boolean Mistake(){
        return false;
    }

    public void setStatus_all(int i,int j){
        if(people[i][j]>=0){
            if (pm25[i][j] >= 0 && pm25[i][j] <= 50) {
                this.persen = (int) (Math.random() * (10)) + 0;
                this.color_bt = Color.GREEN;
                this.color_status = cl_all.getStatusGreen();
            } else if (pm25[i][j] >= 51 && pm25[i][j] <= 100) {
                this.persen = (int) (Math.random() * (20 - 10)) + 10;
                this.color_bt = Color.YELLOW;
                this.color_status =cl_all.getStatusYellow();
            } else if (pm25[i][j] >= 101 && pm25[i][j] <= 150) {
                this.persen = (int) (Math.random() * (30 - 20)) + 20;
                this.color_bt = cl_all.cl_bg_or;
                this.color_status = cl_all.getStatusOrange();
            } else if (pm25[i][j] >= 151) {
                this.persen = (int) (Math.random() * (51 - 30)) + 30;
                this.color_bt = Color.RED;
                this.color_status =cl_all.getStatusRed();
            } else if(pm25[i][j]<0){
                this.persen = 0;
                this.color_bt = new Color(135, 135, 135);
                this.color_status =cl_all.getStatusGray();
            }
        }else{
            this.persen = 0;
            this.color_bt = new Color(135, 135, 135);
            this.color_status =cl_all.getStatusGray();
        }
        
    }

    
}
