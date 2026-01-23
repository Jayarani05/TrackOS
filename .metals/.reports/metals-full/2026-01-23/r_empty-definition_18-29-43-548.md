error id: file:///C:/Projects/TrackOS/src/events/TrainEvent.java:models/Train#
file:///C:/Projects/TrackOS/src/events/TrainEvent.java
empty definition using pc, found symbol in pc: models/Train#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 31
uri: file:///C:/Projects/TrackOS/src/events/TrainEvent.java
text:
```scala
package events;

import models.@@Train;
import models.Station;

public class TrainEvent {
    public String type;
    public Train train;
    public Station station;
    public long timestamp;
    
    public TrainEvent(String type, Train train, Station station) {
        this.type = type;
        this.train = train;
        this.station = station;
        this.timestamp = System.currentTimeMillis();
    }
    
    public static TrainEvent arrival(Train t, Station s) {
        return new TrainEvent("ARRIVAL", t, s);
    }
    
    public static TrainEvent departure(Train t, Station s) {
        return new TrainEvent("DEPARTURE", t, s);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: models/Train#