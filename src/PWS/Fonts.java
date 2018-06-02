package PWS;

public class Fonts {

    private String font;
    private boolean italic;
    private boolean bold;
    private boolean underline;
    private int textsize;

    public Fonts(String font, boolean italic, boolean bold, boolean underline, int textsize){
        this.font = font;
        this.italic = italic;
        this.bold = bold;
        this.underline = underline;
        this.textsize = textsize;
    }

    public String getFont() {
        return font;
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public boolean isUnderline() {
        return underline;
    }

    public int getTextsize() {
        return textsize;
    }
}
