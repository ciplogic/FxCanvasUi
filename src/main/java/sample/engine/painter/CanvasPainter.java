package sample.engine.painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasPainter {
    private int _left;
    private int _top;
    private final GraphicsContext _gc;

    public CanvasPainter(int left, int top, GraphicsContext graphicsContext2D) {
        _left = left;
        _top = top;
        _gc = graphicsContext2D;
    }

    public void setFill(Paint blue) {
        _gc.setFill(blue);
    }

    public void fillRect(int x, int y, int w, int h) {
        _gc.fillRect(_left + x, _top + y, w, h);
    }
}
