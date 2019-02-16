package sample.painting;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import sample.painting.models.DocumentManager;

import java.io.File;

public class PaintController {

    RoutedEventsController _router = new RoutedEventsController();
    private Window _stage;

    DocumentManager _documentManager = new DocumentManager();

    public RoutedEventsController getRoutedEvents() {
        return _router;
    }

    void setup(){
        _router.register("File_Open", this::onFileOpen);
    }

    private void onFileOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(_stage);
        _documentManager.openFile(file);
    }
}
