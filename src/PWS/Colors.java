package PWS;

import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;

public class Colors {
    private String color;
    private String fill;

    public Colors(String color, String fill){
        this.color = color;
        this.fill = fill;
    }

    public String getColorString() {
        return color;
    }

    public String getFillString() {
        return fill;
    }

    public Paint getColor() {
        if(this.color.contains("gradient")){
            String array[] = color.split("[\\(||,||\\)]");
            return LinearGradient.valueOf("linear-gradient(from 50% 0% to 50% 100%, " + array[1] + " 0%, " + array[2] + " 100%)");
        }
        else{
            return Color.valueOf(this.color);
        }
    }

    public Paint getFill() {
        if(this.fill.contains("gradient")){
            String array[] = fill.split("[\\(||,||\\)]");
            return LinearGradient.valueOf("linear-gradient(from 50% 0% to 50% 100%, " + array[1] + " 0%, " + array[2] + " 100%)");
        }
        else{
            return Color.valueOf(this.fill);
        }
    }

    public Color getFillSingle(){
        if(this.fill.contains("gradient")){
            String array[] = fill.split("[\\(||,||\\)]");
            return Color.valueOf(array[1]);
        }
        else{
            return Color.valueOf(this.fill);
        }
    }
}
