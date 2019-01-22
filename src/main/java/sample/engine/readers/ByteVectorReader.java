package sample.engine.readers;

import java.util.Arrays;

/**
 *
 * @author Ciprian
 */
public class ByteVectorReader {

    private final byte[] _data;
    private int _pos;

    public ByteVectorReader(byte[] data) {
        _data = data;
    }

    public ByteVectorReader(ByteVectorReader body) {
        _data = body._data;
        _pos = body._pos;
    }

    public ByteVectorReader(ByteVectorReader body, int offsetAdd) {
        _data = body._data;
        _pos = body._pos + offsetAdd;
    }

    public void skip(int sz) {
        _pos += sz;
    }

    public int Get8() {
        int resVal = current();
        _pos++;
        return resVal;
    }

    public int getLE16() {

        int lo = Get8();
        int hi = Get8();
        return lo + (hi << 8);
    }

    public int getLE32() {
        int lo = getLE16();
        int hi = getLE16();

        return lo + (hi << 16);
    }

    public int size() {
        return _data.length;
    }


    public void seek(int pos) {
        _pos = pos;
    }

    int get() {
        return Get8();
    }

    public int tell() {
        return _pos;
    }

    public byte[] getRaw(int sizeblock) {
        byte[] result = Arrays.copyOfRange(_data, _pos, _pos + sizeblock);
        _pos+= sizeblock;
        return result;
    }


    static int strLen(byte[] bytes){
        for(int i = 0; i<bytes.length; i++){
            if(bytes[i]==0)
                return i;
        }
        return bytes.length;
    }
    public String toString(int sizeBlock) {
        byte[] subRange = getRaw(sizeBlock);
        int len = strLen(subRange);
        String res = new String(subRange, 0,len );
        return res;
    }

    public int current() {
        int resVal = _data[_pos];
        if(resVal<0)
            resVal += 256;

        return resVal;
    }
}

