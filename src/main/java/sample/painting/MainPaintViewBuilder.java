package sample.painting;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;

public class MainPaintViewBuilder {
        public BorderPane _view;
        public PaintController _controller = new PaintController();
        public MainPaintViewBuilder()
        {

            var borderPane = new BorderPane();
            MenuBar menuBar = buildMenuBar();

            borderPane.setTop(menuBar);

            _controller.setup();

            _view = borderPane;
        }

    private MenuBar buildMenuBar() {
        MenuBar menuBar  = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("_File");
        addMenuItem(menuFile,"_New", "File_New");
        addMenuItem(menuFile,"_Open", "File_Open");
        addMenuItem(menuFile,"_Save", "File_Save");
        addMenuItem(menuFile,"_Close", "File_Close");
        addMenuSeparator(menuFile);
        addMenuItem(menuFile,"E_xit", "File_Exit");


        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        menuBar.getMenus().addAll(menuFile, menuEdit);
        return menuBar;
    }

    private void addMenuSeparator(Menu menuFile) {

        menuFile.getItems().add(new SeparatorMenuItem());
    }

    private MenuItem addMenuItem(Menu menuFile, String menuItemCaption, String actionName) {
        MenuItem add = new MenuItem(menuItemCaption);
        add.setOnAction((ev)-> _controller.getRoutedEvents().action(actionName, null));
        menuFile.getItems().add(add);
        return add;
    }
}
