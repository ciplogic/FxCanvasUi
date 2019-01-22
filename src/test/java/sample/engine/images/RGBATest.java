package sample.engine.images;

import org.junit.Test;

import static org.junit.Assert.*;

public class RGBATest {

    @Test
    public void colorTest() {
        int r = 1;
        int g = 2;
        int b = 3;
        int a = 4;
        int col = RGBA.color(r,g,b,a);
        int redT = RGBA.r(col);
        assertEquals(redT, r);

        int redA = RGBA.a(col);
        assertEquals(redA, a);
    }
}