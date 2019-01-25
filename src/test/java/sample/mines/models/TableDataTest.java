package sample.mines.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableDataTest {
    @Test
    public void testTableSize(){
        var table = new TableData(20, 20);
        table.setBomb(2,2);

        assertTrue(table.hasBomb(2,2));
    }

}