# TrackOS

**Real-Time Rail Slot Allocation & Runtime Observability Engine**

## What is TrackOS?

TrackOS schedules trains on tracks in real-time while monitoring JVM performance.

## Features

- Conflict detection using Interval Trees
- Priority-based resolution using Heaps
- Path validation using Graph algorithms
- JVM observability (threads, GC, memory)

## Quick Start

`ash
javac -d out src/**/*.java
java -cp out Main
`

## Project Structure

`
src/
  models/        - Train, Track, Station, TimeSlot
  datastructures/- IntervalTree, RailNetwork, CapacityTracker
  services/      - SchedulingEngine, ConflictDetector
  observability/ - ThreadMonitor, GCMonitor, MemoryMonitor
  events/        - EventBus, TrainEvent
  demo/          - TestData, SampleNetwork
  Main.java      - Entry point
`
"@}
)
Write-Host "[51/53] Update readme file" -ForegroundColor Green

# Commit 52: Add build instructions
Make-Commit "2026-01-14 16:45:00" "Add build instructions" @(
    @{Path="BUILD.md"; Content=@"
# Build Instructions

## Prerequisites

- Java 11 or higher
- No external dependencies

## Compile

`ash
# Windows
javac -d out src\models\*.java src\datastructures\*.java src\services\*.java src\observability\*.java src\events\*.java src\demo\*.java src\util\*.java src\Main.java

# Linux/Mac
javac -d out src/**/*.java
`

## Run

`ash
java -cp out Main
`

## Clean

`ash
rm -rf out/
`
"@}
)
Write-Host "[52/53] Add build instructions" -ForegroundColor Green

# Commit 53: Final cleanup and polish
Make-Commit "2026-01-14 18:00:00" "Final cleanup and polish" @(
    @{Path="src/Main.java"; Content=@"
import demo.*;
import models.*;
import services.*;
import datastructures.*;
import observability.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        Printer.header("TrackOS - Rail Slot Allocation Demo");
        
        // Setup
        RailNetwork network = SampleNetwork.create();
        SchedulingEngine engine = new SchedulingEngine(network);
        RuntimeAnalyzer analyzer = new RuntimeAnalyzer(100);
        
        // Create trains
        Train express1 = TestData.expressA();
        Train express2 = TestData.expressB();
        Train local1 = TestData.localA();
        Train cargo1 = TestData.cargoA();
        
        Printer.section("Trains");
        Printer.item(express1.toString());
        Printer.item(express2.toString());
        Printer.item(local1.toString());
        Printer.item(cargo1.toString());
        
        // Get track
        Station central = network.getStation("S1");
        Track track = network.getTracksFrom("S1").get(0);
        
        // Schedule
        Printer.section("Scheduling");
        
        long now = System.currentTimeMillis();
        long slot30min = 30 * 60 * 1000;
        
        TimeSlot s1 = new TimeSlot(now, now + slot30min, express1, track);
        SchedulingResult r1 = engine.schedule(s1);
        analyzer.recordLatency(r1.latencyMs);
        System.out.println(express1.name + ": " + (r1.success ? "OK" : r1.message));
        
        TimeSlot s2 = new TimeSlot(now + 15*60*1000, now + 45*60*1000, local1, track);
        SchedulingResult r2 = engine.schedule(s2);
        analyzer.recordLatency(r2.latencyMs);
        System.out.println(local1.name + ": " + (r2.success ? "OK" : r2.message));
        
        TimeSlot s3 = new TimeSlot(now + 60*60*1000, now + 90*60*1000, cargo1, track);
        SchedulingResult r3 = engine.schedule(s3);
        analyzer.recordLatency(r3.latencyMs);
        System.out.println(cargo1.name + ": " + (r3.success ? "OK" : r3.message));
        
        Printer.section("Runtime Health");
        System.out.println("Healthy: " + analyzer.isHealthy());
        
        Printer.header("Demo Complete");
    }
}
