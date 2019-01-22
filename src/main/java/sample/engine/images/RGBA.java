package sample.engine.images;

public class RGBA {
    public static int color(int r, int g, int b, int a) {
        int col = (a << 24) |
                (r << 16) |
                (g << 8) |
                (b);
        return col;
    }

    public static int a(int col) {
        return col>>24;
    }

    public static int r(int col) {
        return (col >>16)&255;
    }
    public static int g(int col) {
        return (col >>8)&255;
    }
    public static int b(int col) {
        return (col )&255;
    }
}
