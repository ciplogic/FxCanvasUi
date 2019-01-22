package sample.engine.painter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasPainter {
    private int _left;
    private int _top;
    private final GraphicsContext _gc;

    public CanvasPainter(int left, int top, GraphicsContext graphicsContext2D) {
        setPos(left, top);
        _gc = graphicsContext2D;
    }

    public void setPos(int left, int top)
    {
        _left = left;
        _top = top;
    }

    public void setFill(Paint blue) {
        _gc.setFill(blue);
    }

    public void fillRect(int x, int y, int w, int h) {
        _gc.fillRect(_left + x, _top + y, w, h);
    }
}
