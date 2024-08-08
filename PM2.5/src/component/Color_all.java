package component;

import java.awt.Color;
import java.awt.Graphics;

public class Color_all {
       public Color cl_bg = new Color(195, 179, 238);
       public Color cl_bg_red = new Color(255, 0, 0);
       public static Color cl_bg_white = new Color(255, 255, 255);
       public Color cl_bg_gray = new Color(217, 217, 217);
       public Color cl_bg_sky = new Color(181, 207, 248);
       public Color cl_bg_bt = new Color(215, 156, 229);
       public Color cl_bg_or = new Color(255, 125, 0);

       // ============ light
       public Color cl_li_red = new Color(255, 200, 200);
       public Color cl_li_or = new Color(255, 200, 150);
       public Color cl_li_green = new Color(200, 255, 200);
       public Color cl_li_yellow = new Color(255, 255, 200);

       // =========== Method GET ==========

       public Color[] getStatusGray(){
              Color color[] = {new Color(135, 135, 135),new Color(215, 215, 215)};
              return color;
       }
       public Color[] getStatusRed(){
              Color color[] = {Color.RED,cl_li_red};
              return color;
       }
       public Color[] getStatusGreen(){
              Color color[] = {Color.GREEN,cl_li_green};
              return color;
       }
       public Color[] getStatusYellow(){
              Color color[] = {Color.YELLOW,cl_li_yellow};
              return color;
       }
       public Color[] getStatusOrange(){
              Color color[] = {cl_bg_or,cl_li_or};
              return color;
       }


}
