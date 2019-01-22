package sample.engine.images;

import sample.engine.Point2i;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Surface {
    private int[] _pixels;
    private int _width, _height;

    public Surface(int width, int height) {
        _width = width;
        _height = height;
        _pixels = new int[width * height];

    }



    public void DrawPoint(Point2i pt, int iColor) {
        DrawPoint(pt._x, pt._y, iColor);
    }

    public void DrawPoint(int x, int y, int iColor) {
        int pos = y * _width + x;
        _pixels[pos] = iColor;
    }
    public boolean isValid() {
        return _width > 0;
    }

    public int depth() {
        return isValid() ? 32 : 0;
    }

    public static BufferedImage getImageFromArray(int[] pixels, int width, int height) {
        int[] bitMasks = new int[]{0xFF0000, 0xFF00, 0xFF, 0xFF000000};
        SinglePixelPackedSampleModel sm = new SinglePixelPackedSampleModel(
                DataBuffer.TYPE_INT, width, height, bitMasks);
        DataBufferInt db = new DataBufferInt(pixels, pixels.length);
        WritableRaster wr = Raster.createWritableRaster(sm, db, null);
        BufferedImage image = new BufferedImage(ColorModel.getRGBdefault(), wr, false, null);

        return image;
    }

    public BufferedImage toJavaImage() {
        return getImageFromArray(_pixels, _width, _height);
    }

    public void saveToDisk(String fileName, String extension) {
        BufferedImage img = toJavaImage();
        save(img, fileName, extension);
    }

    private static void save(BufferedImage image, String fileName, String ext) {
        if(image==null)
            return;
        File file = new File(fileName + "." + ext);
        try {
            ImageIO.write(image, ext, file);
            // ignore returned boolean
        } catch (IOException e) {
            System.out.println("Write error for " + file.getPath() + ": " + e.getMessage());
        }
    }

}