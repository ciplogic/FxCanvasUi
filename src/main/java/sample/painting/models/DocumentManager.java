package sample.painting.models;

import java.io.File;
import java.util.*;

public class DocumentManager {
    List<DocumentData> _documents = new ArrayList<>();

    public void openFile(File file) {
        if(file==null || (!file.exists()))
            return;
        _documents.add(new DocumentData(file));
    }
}
