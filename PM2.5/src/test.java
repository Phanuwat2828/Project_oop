

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class test {
    public static void main(String[] args) {
        int data;
      
        for(int i=0;i<50;i++){
            data = (int) (Math.random() * (-100)) + 50;
            System.out.println(data);
        }
    }
}
