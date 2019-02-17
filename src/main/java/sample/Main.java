package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.painting.MainPaintViewBuilder;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Painter");
        var mainViewBuilder = new MainPaintViewBuilder();

        primaryStage.setScene(new Scene(mainViewBuilder._view));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
