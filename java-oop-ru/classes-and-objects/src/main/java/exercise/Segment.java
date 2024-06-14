package exercise;

// BEGIN
public class Segment {
    Point beginPoint;
    Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int beginMidPoint = (beginPoint.getX() + endPoint.getX()) / 2;
        int endMidPoint = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(beginMidPoint, endMidPoint);
    }
}
// END
