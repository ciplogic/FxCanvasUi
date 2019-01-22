package sample.engine;

public class Pair<T1, T2> {
    private T1 _t1;
    private T2 _t2;

    public Pair(T1 t1, T2 t2){
        _t1 = t1;
        _t2 = t2;
    }
    public T1 first(){
        return _t1;
    }
    public void setFirst(T1 value){
        _t1 = value;
    }

    public void setSecond(T2 value){
        _t2 = value;
    }

    public T2 second(){
        return _t2;
    }
}
