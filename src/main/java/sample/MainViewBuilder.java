package sample;

import javafx.scene.layout.BorderPane;

public class MainViewBuilder {
    public BorderPane _view;
    public Controller _controller;
    public MainViewBuilder()
    {
        var borderPane = new BorderPane();
        _controller = new Controller();
        borderPane.setCenter(_controller.canvasBuilder.canvas);
        _view = borderPane;
    }
}
