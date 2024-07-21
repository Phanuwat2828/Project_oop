package component;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Font_all {
    public Font font_Tahoma(int size){
        return  new Font("Tahoma",Font.BOLD,size);
    }
    
    public Font font_kanit(int size,String style){
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./font/Kanit/"+style));
            return font.deriveFont(Font.BOLD,size);
        }catch (FontFormatException | IOException e){
            System.out.println(e);
            return font_Tahoma(size);
        }
    }
    
}
