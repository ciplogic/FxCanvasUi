package sample.painting;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sample.engine.painter.CanvasBuilder;

public class MainView {

    public BorderPane _borderPane;

    public void setup(PaintController _controller) {
        _borderPane = new BorderPane();
        MenuBar menuBar = buildMenuBar(_controller);

        _borderPane.setTop(menuBar);

        HBox imagesHbox = new HBox();
        _borderPane.setLeft(imagesHbox);

        CanvasBuilder canvasBuilder = new CanvasBuilder(800, 600);
        _borderPane.setCenter(canvasBuilder.canvas);
    }


    private MenuBar buildMenuBar(PaintController _controller) {
        MenuBar menuBar  = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("_File");
        addMenuItem(menuFile,"_New", "File_New", _controller);
        addMenuItem(menuFile,"_Open", "File_Open", _controller);
        addMenuItem(menuFile,"_Save", "File_Save", _controller);
        addMenuItem(menuFile,"_Close", "File_Close", _controller);
        addMenuSeparator(menuFile);
        addMenuItem(menuFile,"E_xit", "File_Exit", _controller);


        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        menuBar.getMenus().addAll(menuFile, menuEdit);
        return menuBar;
    }

    private void addMenuSeparator(Menu menuFile) {

        menuFile.getItems().add(new SeparatorMenuItem());
    }

    private MenuItem addMenuItem(Menu menuFile, String menuItemCaption, String actionName, PaintController _controller) {
        MenuItem add = new MenuItem(menuItemCaption);
        add.setOnAction((ev)-> _controller.getRoutedEvents().action(actionName, null));
        menuFile.getItems().add(add);
        return add;
    }
}
