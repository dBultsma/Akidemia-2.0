package PWS;

import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Fonts {

    private String font; //defining variables
    private boolean italic;
    private boolean bold;
    private boolean underline;
    private int textsize;

    //constructor
    public Fonts(String font, boolean italic, boolean bold, boolean underline, int textsize){
        this.font = font;
        this.italic = italic;
        this.bold = bold;
        this.underline = underline;
        this.textsize = textsize;
    }

    public String getFont() {
        return font;
    } //getters

    public FontWeight getBold() {
        if(bold){
            return FontWeight.BOLD;
        }
        else {
            return FontWeight.NORMAL;
        }
    }

    public FontPosture getItalic() {
        if(italic){
            return FontPosture.ITALIC;
        }
        else{
            return FontPosture.REGULAR;
        }
    }

    public boolean isUnderline() {
        return underline;
    }

    public int getTextsize() {
        return textsize;
    }
}
