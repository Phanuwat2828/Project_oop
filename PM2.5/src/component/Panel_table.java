package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_table extends JPanel implements ActionListener {

    private Data data_tr;
    private ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>();
    // ================== Constructer ===============

    public Panel_table(JPanel data,Data data_tr) {
        this.data_tr = data_tr;
        this.pm25 = data_tr.getPm25();
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 8));
        setPreferredSize(new Dimension(705, 500));
        setBackground(null);
        updateTable(data);
    }

    public void updateTable(JPanel status) {
        removeAll(); // ล้างคอมโพเนนต์เดิม
        int box_number = 0;
        data_tr.people();
        data_tr.persen();
        // creat button
        for (int i = 0; i <  data_tr.getPm25().size(); i++) {
            for (int j = 0; j <  data_tr.getPm25().get(i).size(); j++) {
                // =========== Variable =================

                box_number += 1;
                int row = i, coloumn = j, number = box_number;
    
                // ======================================

                JButton bt = new JButton();
                bt.setPreferredSize(new Dimension(33, 33));
                data_tr.setStatus_all(i, j);
                bt.setBackground(data_tr.getColorbt());  
                // ======================================
                if(!data_tr.getFile()){
                    bt.setBackground(new Color(135, 135, 135));
                }
       
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        data_tr.setStatus_all(row, coloumn);
                        Color color[] = data_tr.getColor_status();
                        float persen = data_tr.getPersen(row,coloumn);
                        if (!data_tr.getRain()) {
                            persen = formatFloat(persen, 2);
                            status.removeAll();
                            middle re_status = new middle(data_tr.getStatusData(row, coloumn, number), color);
                            status.add(re_status);
                            status.revalidate();
                            status.repaint();
                        } else {
                            setRain(row, coloumn);
                            updateTable(status);
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

    // =================== Change Data ================== ฝนเทียม
    public void setRain(int row, int col) {
        // 50%
        int data_pm = this.pm25.get(row).get(col);
        data_tr.setPm25(row,col,(int) (data_pm * 0.5));
        // 30%
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < data_tr.getPm25().size() && j >= 0 && j < data_tr.getPm25().get(i).size() && !(i == row && j == col)) {
                    data_tr.setPm25(i,j,(int) (data_pm* 0.7));
                }
            }
        }

    }
    // ============ Format Float ====================
    private float formatFloat(float value, int decimalPlaces) {
        float scale = (float) Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


   
}
