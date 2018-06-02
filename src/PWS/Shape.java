package PWS;

import javafx.scene.paint.Color;

public class Shape extends GraphicsModule {
    private javafx.scene.shape.Shape shape;

    public Shape(Position position, Colors colors, String type, double stroke){
        switch(type){
            case "rectangle":
                this.shape = rectangle(position.getX(), position.getY(), position.getX2()-position.getX(), position.getY2()-position.getY(), colors.getFillSingle());
                break;
            case "circle":
                this.shape = circle(position.getX(), position.getY(), (position.getX2()-position.getX())/2, colors.getFillSingle());
                break;
            case "line":
                this.shape = line(position.getX(), position.getY(), position.getX2(), position.getY2(), colors.getFillSingle());
                break;
        }
    }

    public javafx.scene.shape.Shape getShape() {
        return shape;
    }
}
