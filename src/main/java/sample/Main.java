package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.mines.MainViewBuilder;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        var mainViewBuilder = new MainViewBuilder();

        primaryStage.setScene(new Scene(mainViewBuilder._view));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
