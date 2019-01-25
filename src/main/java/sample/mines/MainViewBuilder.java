package sample.mines;

import javafx.scene.layout.BorderPane;
import sample.mines.Controller;

public class MainViewBuilder {
    public BorderPane _view;
    public Controller _controller;
    public MainViewBuilder()
    {
        var borderPane = new BorderPane();
        _controller = new Controller();
        borderPane.setCenter(_controller.canvasBuilder.canvas);
        borderPane.setOnMouseClicked(mouseEvent -> {
            _controller.onClick(mouseEvent);
        });
        _view = borderPane;
    }
}
