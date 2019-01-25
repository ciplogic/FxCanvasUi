package sample.engine.utils;

public class Rand {
    public static int get(int lo, int hi){
        var randValue = Math.random();
        var fDelta = randValue*(hi-lo);
        var delta = (int) fDelta;
        return (lo + delta);
    }
}
