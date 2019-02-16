package sample.painting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RoutedEventsController {
    static class Listener {
        public Listener(String actionName, Consumer<Object> runner) {
            this.actionName = actionName;
            this.runner = runner;
        }

        String actionName;
        Consumer<Object> runner;
    }

    private List<Listener> _listenerList = new ArrayList<>();

    void register(String actionName, Consumer<Object> runner) {
        _listenerList.add(new Listener(actionName, runner));
    }

    public void action(String actionName, Object param) {
        for (var listener : _listenerList) {
            if (listener.actionName.equals(actionName))
                listener.runner.accept(param);
        }
    }
}
