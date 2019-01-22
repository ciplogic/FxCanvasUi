package sample.engine.painter;

import java.util.function.Supplier;

public class CircularQueue<T> {
    private int _front, _end;
    private Object[] _values;
    public CircularQueue(int size, Supplier<T> _s){
        _values = new Object[size];
    }

    public boolean isEmpty(){
        return _front == _end;
    }

    public T peek(){
        if(isEmpty())
            return null;
        return (T) _values[_front];
    }

    public T remove(){
        if(isEmpty())
            return null;
        T result = peek();
        _front ++;
        if(_front==_values.length)
            _front = 0;
        return result;
    }

    public CircularQueue<T> add(T item){
        _values[_end++] = item;
        if(_end==_values.length){
            _end=0;
        }
        return this;
    }
}
