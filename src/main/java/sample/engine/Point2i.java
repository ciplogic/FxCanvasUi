package sample.engine;

public class Point2i {
    public int _x;
    public int _y;

    public Point2i(int x, int y) {
        _x = x; _y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "_x=" + _x +
                ", _y=" + _y +
                '}';
    }
}
