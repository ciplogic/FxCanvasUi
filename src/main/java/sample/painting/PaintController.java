package sample.painting;

import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import sample.painting.models.DocumentManager;

import java.io.File;

public class PaintController {

    RoutedEventsController _router = new RoutedEventsController();
    private Window _stage;

    DocumentManager _documentManager = new DocumentManager();
    private MainView _mainView;

    public RoutedEventsController getRoutedEvents() {
        return _router;
    }

    void setup(MainView mainView){
        _mainView = mainView;
        _router.register("File_Open", t -> onFileOpen());
        _router.register("File_Save", t -> onFileSave());
        _router.register("File_Exit", t-> onFileExit());
    }

    private void onFileExit() {
        Platform.exit();
        System.exit(0);
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
        _documentManager.openFile(file, _mainView._borderPane);
    }

    private void onFileSave() {
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
        File file = fileChooser.showSaveDialog(_stage);
        _documentManager.openFile(file, _mainView._borderPane);
    }
}
