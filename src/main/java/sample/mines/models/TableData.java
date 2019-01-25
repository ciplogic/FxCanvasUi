package sample.mines.models;

import sample.engine.utils.Rand;

public class TableData {
    public static final int BOMB_VALUE = 16;
    private int _width;
    private int _height;
    int[] _tableData;

    public TableData(int width, int height) {

        _width = width+2;
        _height = height+2;

        _tableData = new int[_width*_height];
    }

    public void setBomb(int row, int col) {
        setValue(row, col, BOMB_VALUE);
    }

    private void setValue(int row, int col, int val) {
        int pos = _width * row + col;
        _tableData[pos] = val;
    }

    public boolean hasBomb(int row, int col) {
        return (getCell(row, col) & BOMB_VALUE) != 0;
    }

    public int getWidth() {
        return _width-2;
    }
    public int getHeight() {
        return _height-2;
    }

    public int getCell(int row, int col) {
        int pos = _width * row + col;
        return _tableData[pos];
    }

    public void setRandomBombs(int countBombs) {
        for(int i = 0; i<countBombs;){
            var newRow = Rand.get(1, _height-1);
            var newCol = Rand.get(1, _width-1);
            if(!hasBomb(newRow, newCol))
            {
                setBomb(newRow, newCol);
                i++;
            }

        }
    }

    public int countBombs(int row, int col) {
        var result = 0;
        for(var i = -1; i<=1; i++)
            for(var j = -1; j<=1; j++)
                if(hasBomb(row+i, col +j))
                    result++;
        return result;
    }
}
