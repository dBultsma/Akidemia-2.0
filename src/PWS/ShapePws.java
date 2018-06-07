package PWS;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ShapePws extends GraphicsModule { // based on graphics module
    private Shape shape;

    //constructors for shapes
    public ShapePws(Position position, Colors colors, String type, double stroke){
        switch(type){
            case "rectangle": //coordinate values input to define sizes and positions
                this.shape = rectangle(position.getX(), position.getY(), position.getX2()-position.getX(), position.getY2()-position.getY(), colors.getFillSingle());
                break;
            case "ellipse":
                this.shape = ellipse(position.getX(), position.getY(), position.getX2()-position.getX(), position.getY2()-position.getY(), colors.getFillSingle());
                break;
            case "line":
                this.shape = line(position.getX(), position.getY(), position.getX2(), position.getY2(), colors.getFillSingle());
                break;
        }
    }

    public Shape getShape() {
        return shape;
    }
}
