package events;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBus {
    private List<Consumer<TrainEvent>> listeners = new ArrayList<>();
    
    public void subscribe(Consumer<TrainEvent> listener) {
        listeners.add(listener);
    }
    
    public void publish(TrainEvent event) {
        for (Consumer<TrainEvent> l : listeners) {
            l.accept(event);
        }
    }
}
