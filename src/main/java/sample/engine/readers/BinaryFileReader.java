package sample.engine.readers;


import sample.engine.utils.FileUtils;

public class BinaryFileReader {
    public static ByteVectorReader open(String fileName){
        byte[] fileData = FileUtils.readAllBytes(fileName);
        return new ByteVectorReader(fileData);
    }
}
