package sample.painting;

import javafx.scene.layout.BorderPane;

public class MainPaintViewBuilder {
        public BorderPane _view;
        public PaintController _controller = new PaintController();
        public MainPaintViewBuilder()
        {
            MainView mainView = new MainView();
            mainView.setup(_controller);
            _controller.setup(mainView);
            _view = mainView._borderPane;
        }
}
