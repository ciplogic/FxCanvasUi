package sample.mines;

import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import sample.engine.painter.CanvasBuilder;
import sample.engine.painter.CanvasPainter;
import sample.mines.models.TableCellView;
import sample.mines.models.TableData;

import java.awt.*;

public class Controller {
    CanvasBuilder canvasBuilder;
    TableData _tableData;
    public Controller()
    {
        canvasBuilder = new CanvasBuilder(800, 600);
        _tableData = new TableData(24, 20);
        _tableData.setRandomBombs(50);
        paintBackground();
        paintScreen();
    }

    void paintBackground(){
        var gc = canvasBuilder.canvas.getGraphicsContext2D();
        final String IMAGE_LOC = "http://icons.iconarchive.com/icons/uiconstock/flat-halloween/128/Halloween-Bat-icon.png";
        final Image image = new Image(IMAGE_LOC);

        final double W = image.getWidth();
        final double H = image.getWidth();

            gc.setGlobalAlpha(1);

            gc.drawImage(image, 600, 230);

        gc.setGlobalAlpha(0.7);

        gc.drawImage(image, 600, 230 + H*2, W, -H);

        gc.setGlobalAlpha(1);


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

        int row = y  / 20;
        int col = x / 20;
        _tableData.setVisible(row, col);

        var cellView = new TableCellView();
        var cellValue = _tableData.getCell(row, col);
        CanvasPainter painter = canvasBuilder.getPainter(col * 20, row * 20);
        cellView.paintUsingPainter(painter, 20, cellValue, _tableData.countBombs(row, col));
    }


}
