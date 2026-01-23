error id: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/service/AllocationService.java
file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/service/AllocationService.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[1,1]

error in qdox parser
file content:
```java
offset: 1
uri: file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/service/AllocationService.java
text:
```scala
p@@ackage com.;

import com.TrackOSProject.TrackOS.Entity.Allocation;
import com.TrackOSProject.TrackOS.Repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    public Optional<Allocation> getAllocationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        return allocationRepository.findById(id);
    }

    public List<Allocation> getAllocationsByTrainId(Long trainId) {
        return allocationRepository.findByTrainId(trainId);
    }

    public Allocation saveAllocation(Allocation allocation) {
        validateAllocation(allocation);
        return allocationRepository.save(allocation);
    }

    public Allocation updateAllocation(Long id, Allocation allocationDetails) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        validateAllocation(allocationDetails);

        Allocation allocation = allocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found with id: " + id));

        allocation.setTrainId(allocationDetails.getTrainId());
        allocation.setTrackName(allocationDetails.getTrackName());
        allocation.setStartTime(allocationDetails.getStartTime());
        allocation.setEndTime(allocationDetails.getEndTime());
        allocation.setStatus(allocationDetails.getStatus());

        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Allocation ID cannot be null");
        }
        if (!allocationRepository.existsById(id)) {
            throw new RuntimeException("Allocation not found with id: " + id);
        }
        allocationRepository.deleteById(id);
    }

    private void validateAllocation(Allocation allocation) {
        if (allocation == null) {
            throw new IllegalArgumentException("Allocation cannot be null");
        }
        if (allocation.getTrainId() == null) {
            throw new IllegalArgumentException("Train ID is required");
        }
        if (allocation.getTrackName() == null || allocation.getTrackName().trim().isEmpty()) {
            throw new IllegalArgumentException("Track name is required");
        }
        if (allocation.getStartTime() == null) {
            throw new IllegalArgumentException("Start time is required");
        }
        if (allocation.getEndTime() == null) {
            throw new IllegalArgumentException("End time is required");
        }
        if (allocation.getEndTime().isBefore(allocation.getStartTime())) {
            throw new IllegalArgumentException("End time must be after start time");
        }
        if (allocation.getStatus() == null || allocation.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status is required");
        }
    }
}

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:936)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in file:///C:/Projects/TrackOS/src/main/java/com/TrackOSProject/TrackOS/service/AllocationService.java