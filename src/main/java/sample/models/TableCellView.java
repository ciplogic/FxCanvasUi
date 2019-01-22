package sample.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TableCellView {
    public void paint(GraphicsContext gc,int row, int col, int cellSize, int cellValue){

        gc.setFill(Color.BLUE);
        gc.fillRect(2+row*cellSize,2+ col*cellSize,cellSize-4,cellSize-4);
    }
}
