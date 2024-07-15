


import javax.swing.JFrame;

import component.Button_all;

public class App {
    public static void main(String[] args){
        Button_all dp = new Button_all();
        JFrame frame = new JFrame();
        frame.setSize(1300,700);
        frame.add(dp.button_import());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

