package PWS;

public class Position {

    private double x; //setting up coordinate variables
    private double y;
    private double x2;
    private double y2;

    //constructor
    public Position(double x, double y, double x2, double y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX() {
        return x;
    } //getters

    public double getY() {
        return y;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
