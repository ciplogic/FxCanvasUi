package sample.engine.painter;

import java.util.ArrayDeque;
import java.util.Queue;

public class GameEventLoop {
    Queue<GameEvent> events = new ArrayDeque<>(50);
    public GameEvent peek(){
        return events.peek();
    }
}
