package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_table extends JPanel implements ActionListener {
    private int[][] pm25;
    private int people = 5000;

    public Panel_table(int[][] pm, int people, JPanel data, Boolean status_Rain , Boolean status_file) {
        this.pm25 = pm;
        this.people = people;
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 8));
        setPreferredSize(new Dimension(705, 500));
        setBackground(null);
        updateTable(data, status_Rain,status_file);
    }

    public void updateTable(JPanel status, Boolean status_Rain ,Boolean status_file) {
        removeAll(); // ล้างคอมโพเนนต์เดิม
        int box_number = 0;
        for (int i = 0; i < pm25.length; i++) {
            for (int j = 0; j < pm25[i].length; j++) {
                box_number += 1;
                int row = i, coloumn = j, people_in = this.people, number = box_number;
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
                if(!status_file){
                    bt.setBackground( new Color(135, 135, 135));
                }
                bt.addActionListener(new ActionListener() {
                    int data_1[] = new int[6];

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int data = pm25[row][coloumn];
                        float persen = 0;
                        Color_all cl_all = new Color_all();
                        Color color[] = new Color[2];
                        Random rn = new Random();
                        if (data >= 0 && data <= 50) {
                            persen = (int) (Math.random() * (10 )) + 0; // สุ่มตัวเลขตั้งแต่ 0 ถึง 9 แล้วบวก 10
                            color[0] = Color.GREEN;
                            color[1] = cl_all.cl_li_green;
                        } else if (data >= 51 && data <= 100) {
                            persen = (int) (Math.random() * (20 - 10)) + 10;
                            color[0] = Color.YELLOW;
                            color[1] = cl_all.cl_li_yellow;
                        } else if (data >= 101 && data <= 150) {
                            persen = (int) (Math.random() * (30 - 20)) + 20;
                            color[0] = cl_all.cl_bg_or;
                            color[1] = cl_all.cl_li_or;
                        } else if (data >= 151 && data <= 250) {
                            persen = (int) (Math.random() * (51 - 30)) + 30;
                            color[0] = Color.RED;
                            color[1] = cl_all.cl_li_red;
                        }
                        
                        persen *= 0.01;
                        if (!status_Rain) {
                            if(status_file){
                                persen = formatFloat(persen, 2);
                                status.removeAll();
                                data_1[0] = pm25[row][coloumn];
                                data_1[1] = people_in;
                                data_1[2] = (int) (persen * 100);
                                data_1[3] = (int) (people_in * persen);
                                data_1[4] = (people_in - (int) (people_in * persen));
                                data_1[5] = number;
            
                                middle re_status = new middle(data_1, color);
                                status.add(re_status);
                                status.revalidate();
                                status.repaint();
                            }else{
                                color[0] = new Color(135, 135, 135);
                                color[1] = new Color(215, 215, 215) ;
                                persen = formatFloat(persen, 2);
                                status.removeAll();
                                data_1[0] = pm25[row][coloumn];
                                data_1[1] = people_in;
                                data_1[2] = 0;
                                data_1[3] = 0;
                                data_1[4] = people_in;
                                data_1[5] = number;
            
                                middle re_status = new middle(data_1, color);
                                status.add(re_status);
                                status.revalidate();
                                status.repaint();
                            }
                            
                        } else {
                            setRain(row, coloumn);
                            updateTable(status, status_Rain,status_file);
                            status.removeAll();
                            Color color_t[] = { new Color(135, 135, 135), new Color(215, 215, 215) };
                            middle new_status = new middle(new int[6], color_t);
                            status.add(new_status);
                        }

                    }

                });
                add(bt);
            }
        }
        revalidate();
        repaint();
    }

    public void setRain(int row, int col) {
        // 50%
        this.pm25[row][col] = (int) (this.pm25[row][col] * 0.5);
        // 30%
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 20 && !(i == row && j == col)) {
                    this.pm25[i][j] = (int) (this.pm25[i][j] * 0.7);
                }
            }
        }

    }

    public float formatFloat(float value, int decimalPlaces) {
        String formatString = String.format("%." + decimalPlaces + "f", value);
        return Float.parseFloat(formatString);
    }

    public int[][] getPm() {
        return this.pm25;
    }

    public void setPm(int[][] pm) {
        this.pm25 = pm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
