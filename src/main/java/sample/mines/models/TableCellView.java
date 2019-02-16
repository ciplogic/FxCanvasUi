package sample.mines.models;

import javafx.scene.paint.Color;
import sample.engine.painter.CanvasPainter;

public class TableCellView {
    private static boolean hasBomb(int cellValue) {
        return (TableData.BOMB_VALUE & cellValue) != 0;
    }
    private static boolean hasBeenExposed(int cellValue) {
        return (TableData.EXPOSED & cellValue) != 0;
    }
    public void paintUsingPainter(CanvasPainter painter, int cellSize, int cellValue, int countBombs) {
        boolean cellWithBomb = hasBomb (cellValue) ;
        boolean wasExposed = hasBeenExposed(cellValue);
        if(!wasExposed) {
            painter.setFill(Color.DARKBLUE);
            painter.fillRect(2,2,cellSize-4,cellSize-4);
            return;
        }
        if(cellWithBomb)
            painter.setFill(Color.RED);
        else
            painter.setFill(Color.LIGHTGRAY);

        painter.fillRect(2,2,cellSize-4,cellSize-4);
        if(countBombs>0 && !cellWithBomb)
        {
            painter.setFill(Color.BLACK);
            painter.writeTextLeft(6, 12, ""+countBombs);
        }
    }
}
