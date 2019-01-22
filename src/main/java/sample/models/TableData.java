package sample.models;

public class TableData {
    private static final int BOMB_VALUE = 16;
    private int _width;
    private int _height;
    int[] _tableData;

    public TableData(int width, int height) {

        _width = width+2;
        _height = height+2;

        _tableData = new int[width*height];
    }

    public void setBomb(int row, int col) {
        setValue(row, col, BOMB_VALUE);
    }

    private void setValue(int row, int col, int val) {
        int pos = _width * row + col;
        _tableData[pos] = val;
    }

    public boolean hashBomb(int row, int col) {
        int pos = _width * row + col;
        return (_tableData[pos] & BOMB_VALUE) != 0;
    }
}
