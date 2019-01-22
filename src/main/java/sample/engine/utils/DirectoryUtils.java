package sample.engine.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DirectoryUtils {
    public static List<String> getFilesInDir(String dirFullPath, String extension) {

        File pdfTestDir = new File(dirFullPath);
        return Arrays.stream(Objects.requireNonNull(
                pdfTestDir.listFiles(
                        (dir, name) -> {
                            boolean filter = name.toLowerCase().endsWith("." + extension);
                            return filter;
                        }
                )))
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());

    }
}
