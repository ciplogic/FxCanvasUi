package sample.mines;

import javafx.scene.input.MouseEvent;
import sample.engine.painter.CanvasBuilder;
import sample.engine.painter.CanvasPainter;
import sample.mines.models.TableCellView;
import sample.mines.models.TableData;

public class Controller {
    CanvasBuilder canvasBuilder;
    TableData _tableData;
    public Controller()
    {
        canvasBuilder = new CanvasBuilder(800, 600);
        _tableData = new TableData(24, 20);
        _tableData.setRandomBombs(50);
        paintScreen();
    }

    void paintScreen(){
        var cellView = new TableCellView();
        var w = _tableData.getWidth();
        var h = _tableData.getHeight();
        for(var col = 1; col<=w; col++){
            for(var row = 1; row<=h; row++) {
                var cellValue = _tableData.getCell(row, col);
                CanvasPainter painter = canvasBuilder.getPainter(col * 20, row * 20);
                cellView.paintUsingPainter(painter, 20, cellValue, _tableData.countBombs(row, col));
            }
        }
    }

    public void onClick(MouseEvent mouseEvent) {
        var x = (int)mouseEvent.getX() ;
        var y= (int)mouseEvent.getY();
    }
}
