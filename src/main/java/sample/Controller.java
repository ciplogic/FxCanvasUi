package sample;

import sample.engine.painter.CanvasBuilder;
import sample.models.TableCellView;

public class Controller {
    CanvasBuilder canvasBuilder;
    public Controller()
    {
        canvasBuilder = new CanvasBuilder(800, 600);
        paintScreen();
    }

    void paintScreen(){
        var cellView = new TableCellView();
        for(var i = 0; i<24; i++){
            for(var j = 0; j<20; j++) {
                cellView.paintUsingPainter(canvasBuilder.getPainter(i*20, j*20), 20, 0);
            }
        }
    }
}
