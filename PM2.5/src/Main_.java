
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import component.Color_all;
import component.ColorPanel;
import component.middle;
import component.Button_input;
import component.Panel_table;
// ================= ที่ต้องทำ 
// รับค่า  เป็นช่วงได้ และ เมื่อมีรับที่ไม่ไช่เลขให้แจ้ง error
// ค่าในไฟล์ มีค่า eeror ให้แจ้ง ถ้าเป็นตัวหนังสือให้เปลี่ยนเป็น -1
// 

public class Main_ {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PM2.5 version alpha");
        Button_input bt_input = new Button_input();
        int data_start[] = new int[6];
        Color color_t[] = { new Color(135, 135, 135), new Color(215, 215, 215) };
        middle box_status = new middle(data_start, color_t);
        Panel_table panelTable = new Panel_table(new int[10][20], 5000, box_status, false,false);
        Color_all color_all = new Color_all();
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JPanel content_1 = new JPanel();
        JPanel content_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // ======================= Panel_1 ===============================
        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill = GridBagConstraints.HORIZONTAL;s
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel_1.setBackground(new Color_all().cl_bg);

        // ================== content_1 ===================

        content_1.setPreferredSize(new Dimension(800, 700));
        content_1.setBackground(new Color_all().cl_bg);

        JPanel Tapbar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Tapbar.setPreferredSize(new Dimension(800, 100));
        Tapbar.setBackground(Color_all.cl_bg_white);
        JPanel Table = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        Table.setBackground(Color_all.cl_bg_white);

        Table.setPreferredSize(new Dimension(800, 500));
        JPanel inputfile = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputfile.setPreferredSize(new Dimension(800, 100));

        // ================== content_2 ===================
        JPanel Rain = new JPanel();
        JPanel Status = new JPanel();
        // middle manageRect = new middle();

        // JLayeredPane layeredPane = manageRect.manageRect_all(data);
        Status.add(box_status);

        Status.setPreferredSize(new Dimension(450, 480));
        Status.setBackground(color_all.cl_bg_white);
        Rain.setPreferredSize(new Dimension(450, 200));
        Rain.setBackground(color_all.cl_bg_white);
        // Rain

        JButton rainButton = bt_input.rain();
        Rain.setLayout(null);
        Rain.add(rainButton);

        JButton rainButtonTwo = bt_input.rain_two();
        // Rain.setLayout(null);
        Rain.add(rainButtonTwo);
        content_2.setPreferredSize(new Dimension(450, 700));

        JButton back = bt_input.back();
        Rain.add(back);
        // content_2.setLocation(800,0);
        content_2.setBackground(null);
        content_2.add(Status);
        content_2.add(Rain);
        

        // ====================== Tabbar ==================
        // Create the panels that will draw rectangles with different background colors
        JPanel redPanel = new ColorPanel(Color.RED, color_all.cl_li_red, "มากกว่า 30%");
        JPanel orangePanel = new ColorPanel(color_all.cl_bg_or, color_all.cl_li_or, "ตั้งแต่ 20-29%");
        JPanel yellowPanel = new ColorPanel(Color.YELLOW, color_all.cl_li_yellow, "ตั้งแต่ 10-19%");
        JPanel greenPanel = new ColorPanel(Color.GREEN, color_all.cl_li_green, "ตั้งแต่ 0-9%");

        // Add the color panels to panel2
        Tapbar.add(redPanel);
        Tapbar.add(orangePanel);
        Tapbar.add(yellowPanel);
        Tapbar.add(greenPanel);

        // ====================== Table ================== <== work here
        Table.add(panelTable);

        // ====================== inputfile ==================
        inputfile.add(bt_input.button(panelTable, box_status));
        inputfile.setBackground(new Color_all().cl_bg_white);

        // ========================= add panel ===============================
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        content_1.add(Tapbar);
        content_1.add(Table);
        content_1.add(inputfile);

        // ====================== Add ===================================
        panel_1.add(content_1);

        gbc.gridx = 1;
        panel_1.add(content_2);

        frame.setIconImage(new ImageIcon(Main_.class.getResource("/image/mark2.png")).getImage());

        frame.setSize(1300, 750);
        frame.add(panel_1);

        // =======================================================

        // =======================================================
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // =======================================================
    }
}
