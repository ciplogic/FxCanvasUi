package sample.engine.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static byte[] readAllBytes(String fileName){
        Path path = Paths.get(fileName);
        try {
            byte[] data = Files.readAllBytes(path);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }

    }


}
