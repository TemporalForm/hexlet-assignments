package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public int getRadius() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("");
        }
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }
}
// END
