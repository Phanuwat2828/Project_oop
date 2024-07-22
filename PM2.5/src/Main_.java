
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
// import java.util.concurrent.Flow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.w3c.dom.css.Rect;

import component.Color_all;
import component.Button_input;
import component.ColorPanel;
import component.Table;
import component.ColorRectangle;

public class Main_ {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PM2.5 version alpha");
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
        JPanel x = new JPanel();
        Status.setPreferredSize(new Dimension(450,480));
        Status.setBackground(new Color_all().cl_bg_red);
        Rain.setPreferredSize(new Dimension(450,200));
        Rain.setBackground(new Color_all().cl_bg_gray);
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
        
        // Table.add(new Panel_table());

        // ====================== inputfile ==================
        inputfile.add(new Button_input().button());
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


class Panel_table extends JPanel{
    JPanel table_in = new JPanel(new FlowLayout(FlowLayout.LEFT,2,8));

    public Panel_table(int people,int[][] pm ){

        removeAll();
        setLayout(new FlowLayout(FlowLayout.LEFT,2,8));
        setPreferredSize(new Dimension(700,500));
        for(int i=0;i<10;i++){
            for(int j=0;j<20;j++){
                JButton bt =new JButton();
                
                bt.setPreferredSize(new Dimension(33,33));
                if(pm[i][j] >=0 && pm[i][j] <=50){
                    // bt.setBackground(new Color());
                }else  if(pm[i][j] >=51 && pm[i][j] <=100) {
                    bt.setBackground(new Color_all().cl_bg_gray);
                }else  if(pm[i][j] >=101 && pm[i][j] <=150) {
                    bt.setBackground(new Color_all().cl_bg_gray);
                }else  if(pm[i][j] >=151 && pm[i][j] <=250) {
                    bt.setBackground(new Color_all().cl_bg_gray);
                }
                add(bt);
            }
            
        }
        
        revalidate();
        repaint();
    }
}