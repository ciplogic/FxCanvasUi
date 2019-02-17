package sample.painting.models;

import javafx.scene.image.Image;

import java.io.File;

public class DocumentData {

    Image image;

    public DocumentData(File file) {
        try {
            String urlFile = file.toURI().toURL().toString();
            image = new Image(urlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
