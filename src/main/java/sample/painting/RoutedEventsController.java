package sample.painting;

import java.util.ArrayList;
import java.util.List;

public class RoutedEventsController {
    static class Listener {
        public Listener(String actionName, Runnable runner) {
            this.actionName = actionName;
            this.runner = runner;
        }

        String actionName;
        Runnable runner;
    }

    private List<Listener> _listenerList = new ArrayList<>();

    void register(String actionName, Runnable runner) {
        _listenerList.add(new Listener(actionName, runner));
    }

    public void action(String actionName) {
        for (var listener : _listenerList) {
            if (listener.actionName.equals(actionName))
                listener.runner.run();
        }
    }
}
