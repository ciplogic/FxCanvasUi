package sample.painting.models;

import javafx.scene.layout.BorderPane;
import sample.engine.painter.CanvasBuilder;

import java.io.File;
import java.util.*;

public class DocumentManager {
    private List<DocumentData> _documents = new ArrayList<>();

    public void openFile(File file, BorderPane centerPane) {
        if(file==null || (!file.exists()))
            return;
        _documents.add(new DocumentData(file));
        var lastImage = _documents.get(_documents.size()-1).image;
        var canvasBuilder = new CanvasBuilder((int)lastImage.getWidth(), (int)lastImage.getHeight());
        centerPane.setCenter(canvasBuilder.canvas);
        var gc = canvasBuilder.canvas.getGraphicsContext2D();
        gc.drawImage(lastImage, 0, 0);
    }
}
