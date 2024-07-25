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
import java.util.StringTokenizer;

public class Button_input extends JFrame implements ActionListener {
    private int people = 5000;
    private int[][] pm25 = new int[10][20];
    private JButton bt_count = new JButton("Enter");
    JTextField input_count = new JTextField(Integer.toString(this.people));
    private JPanel tablePanel;
    private JPanel status;
    private Boolean status_rain = false;
    private Boolean status_file = false;

    public JPanel button(JPanel panelTable, JPanel status) {
        this.tablePanel = panelTable;
        this.status = status;
        JPanel input_bt = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 17));
        input_bt.setPreferredSize(new Dimension(800, 80));
        input_bt.setBackground(null);

        JButton bt = new JButton("Select File");
        bt.setPreferredSize(new Dimension(100, 35));
        bt.setBackground(new Color_all().cl_bg_bt);
        JLabel Label = new JLabel();
        Label.setFont(new Font_all().font_kanit(17, "Kanit-Bold.ttf"));

        bt_count.setPreferredSize(new Dimension(100, 35));
        bt_count.setBackground(new Color_all().cl_bg_bt);

        input_count.setPreferredSize(new Dimension(200, 35));

        Label.setPreferredSize(new Dimension(300, 35));
        // // เพิ่ม ActionListener ให้กับปุ่ม openButton
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
                        updateTable(getPm(), getPeople(),get_statusfile());

                        // JOptionPane.showMessageDialog(null, content, "File Content",
                        // JOptionPane.INFORMATION_MESSAGE);
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
                    setCount(Integer.parseInt(input_count.getText()));
                    updateTable(getPm(), getPeople(),get_statusfile());
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

    public JButton rain() {
        JButton btn = new JButton("RAIN");
        btn.setBounds(20, 20, 170, 70);
        btn.setBackground(new Color(215, 156, 229));
        btn.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int data[][] = new int[10][20];
                data = getPm();
                if (e.getSource() == btn) {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 20; j++) {
                            data[i][j] = (int) (data[i][j] * 0.5);
                        }
                    }
                    setPm(data);
                    updateTable(getPm(), getPeople(),get_statusfile());
                    reset_status();

                }
            }
        });
        return btn;
    }

    public JButton rain_two() {
        JButton btn2 = new JButton("Atificial Rain");
        btn2.setBounds(250, 20, 170, 70);
        btn2.setBackground(new Color(215, 156, 229));
        btn2.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set_statusRain(!get_statusRain());
                updateTable(pm25, people,get_statusfile());
                btn2.setText(get_statusRain() ? "Select Area" : "Atificial Rain");
            }
        });

        return btn2;
    }
    public JButton back() {
        JButton btn2 = new JButton("Back to Manu");
        btn2.setBounds(20, 150, 170, 40);
        btn2.setBackground(new Color_all().cl_bg_red);
        btn2.setFont(new Font_all().font_kanit(20, "Kanit-Bold.ttf"));
        btn2.setForeground(new Color_all().cl_bg_white);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Back");
            }
        });

        return btn2;
    }

    public void set_statusRain(Boolean status) {
        this.status_rain = status;
    }

    public Boolean get_statusRain() {
        return this.status_rain;
    }

    public Boolean get_statusfile() {
        return this.status_file;
    }

    public void actionPerformed(ActionEvent e) {
        // ไม่ได้ใช้ในโค้ดนี้ แต่ต้องมีเพราะ implements ActionListener
    }

    public void reset_status() {
        this.status.removeAll();
        Color color_t[] = { new Color(135, 135, 135), new Color(215, 215, 215) };
        middle new_status = new middle(new int[6], color_t);
        this.status.add(new_status);

    }

    public int[][] getPm() {
        return this.pm25;
    }

    public void setPm(int[][] pm) {
        this.pm25 = pm;
    }

    public int getPeople() {
        return this.people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    private void updateTable(int[][] pm, int people_,boolean status_file) {
        // Remove old components and update the table with new data
        tablePanel.removeAll();
        Panel_table newTable = new Panel_table(pm, people_, status, get_statusRain(),status_file);
        tablePanel.add(newTable);
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    public void readFile(File file) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            this.status_file = true;
            int i = 0;
            while ((line = br.readLine()) != null) {
                int j = 0;

                StringTokenizer tk = new StringTokenizer(line);

                for (; tk.hasMoreTokens();) {
                    int data = Integer.parseInt(tk.nextToken());
                    System.out.print(data + " ");
                    this.pm25[i][j] = data;
                    j++;
                }
                System.out.print("|" + "\n");
                i++;
            }
        }
    }

    private void setCount(int num) {
        this.people = num;
        System.out.print(this.people);
    }

}