package component;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Font_all {
    public Font font_Tahoma(int size){
        return  new Font("Tahoma",Font.BOLD,size);
    }
    public Font font_Tahoma_pl(int size){
        return  new Font("Tahoma",Font.PLAIN,size);
    }
    
} 
