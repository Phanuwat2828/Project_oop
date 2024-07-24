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

    public Panel_table(int[][] pm, int people, JPanel data, Boolean status_Rain) {
        this.pm25 = pm;
        this.people = people;
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 8));
        setPreferredSize(new Dimension(705, 500));
        setBackground(null);
        updateTable(data, status_Rain);
    }

    public void updateTable(JPanel status, Boolean status_Rain) {
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
                bt.addActionListener(new ActionListener() {
                    int data_1[] = new int[5];

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int data = pm25[row][coloumn];
                        float persen = 0;
                        Color_all cl_all = new Color_all();
                        Color color[] = new Color[2];
                        Random rn = new Random();
                        System.out.println(row + "," + coloumn + " = " + data);
                        if (data >= 0 && data <= 50) {
                            persen = rn.nextInt(0, 10);
                            color[0] = Color.GREEN;
                            color[1] = cl_all.cl_li_green;
                        } else if (data >= 51 && data <= 100) {
                            persen = rn.nextInt(11, 20);
                            color[0] = Color.YELLOW;
                            color[1] = cl_all.cl_li_yellow;
                        } else if (data >= 101 && data <= 150) {
                            persen = rn.nextInt(20, 30);
                            color[0] = cl_all.cl_bg_or;
                            color[1] = cl_all.cl_li_or;
                        } else if (data >= 151 && data <= 250) {
                            persen = rn.nextInt(30, 51);
                            color[0] = Color.RED;
                            color[1] = cl_all.cl_li_red;
                        }
                        if (!status_Rain) {
                            persen *= 0.01;
                            persen = formatFloat(persen, 2);
                            status.removeAll();
                            data_1[0] = people_in;
                            data_1[1] = (int) (persen * 100);
                            data_1[2] = (int) (people_in * persen);
                            data_1[3] = (people_in - (int) (people_in * persen));
                            data_1[4] = number;
                            middle re_status = new middle(data_1, color);
                            status.add(re_status);
                            status.revalidate();
                            status.repaint();
                        } else {
                            setRain(row, coloumn);
                            updateTable(status, status_Rain);
                            status.removeAll();
                            Color color_t[] = { new Color(135, 135, 135), new Color(215, 215, 215) };
                            middle new_status = new middle(new int[5], color_t);
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
