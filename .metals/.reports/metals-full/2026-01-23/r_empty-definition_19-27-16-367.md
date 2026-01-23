error id: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/observability/SLAChecker.java:_empty_/LatencyTracker#
file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/observability/SLAChecker.java
empty definition using pc, found symbol in pc: _empty_/LatencyTracker#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 125
uri: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/observability/SLAChecker.java
text:
```scala
package com.TrackOSProject.TrackOS.observability;

public class SLAChecker {
    private SLAConfig config;
    private Latenc@@yTracker tracker;

    public SLAChecker(SLAConfig config, LatencyTracker tracker) {
        this.config = config;
        this.tracker = tracker;
    }

    public boolean isMeetingSLA() {
        return tracker.getSLACompliance() >= config.minCompliance;
    }

    public boolean isLatencyOk(long ms) {
        return ms <= config.maxLatencyMs;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/LatencyTracker#