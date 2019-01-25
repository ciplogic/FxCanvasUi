package sample.mines.models;

import javafx.scene.paint.Color;
import sample.engine.painter.CanvasPainter;

public class TableCellView {
    public void paintUsingPainter(CanvasPainter painter, int cellSize, int cellValue, int countBombs) {
        boolean hasBomb = (TableData.BOMB_VALUE & cellValue) !=0;
        if(hasBomb)
            painter.setFill(Color.RED);
        else
            painter.setFill(Color.LIGHTGRAY);

        painter.fillRect(2,2,cellSize-4,cellSize-4);
        if(countBombs>0 && !hasBomb)
        {
            painter.setFill(Color.BLACK);
            painter.writeTextLeft(6, 12, ""+countBombs);
        }
    }
}
