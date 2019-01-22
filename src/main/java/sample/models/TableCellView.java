package sample.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.engine.painter.CanvasPainter;

public class TableCellView {
    public void paintUsingPainter(CanvasPainter painter, int cellSize, int cellValue) {

        painter.setFill(Color.BLUE);
        painter.fillRect(2,2,cellSize-4,cellSize-4);
    }
}
