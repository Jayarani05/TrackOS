package com.TrackOSProject.TrackOS.DTO.Response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Response for slot allocation results.
 */
public class SlotResponse {

    private String slotId;
    private String trainId;
    private String trackId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private List<ConflictInfo> conflicts;

    public SlotResponse() {
    }

    // Getters and Setters
    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ConflictInfo> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<ConflictInfo> conflicts) {
        this.conflicts = conflicts;
    }

    /**
     * Brief conflict information for responses.
     */
    public static class ConflictInfo {
        private String conflictingSlotId;
        private String conflictingTrainId;
        private LocalDateTime conflictStart;
        private LocalDateTime conflictEnd;

        public ConflictInfo() {
        }

        public ConflictInfo(String conflictingSlotId, String conflictingTrainId,
                LocalDateTime conflictStart, LocalDateTime conflictEnd) {
            this.conflictingSlotId = conflictingSlotId;
            this.conflictingTrainId = conflictingTrainId;
            this.conflictStart = conflictStart;
            this.conflictEnd = conflictEnd;
        }

        // Getters and Setters
        public String getConflictingSlotId() {
            return conflictingSlotId;
        }

        public void setConflictingSlotId(String conflictingSlotId) {
            this.conflictingSlotId = conflictingSlotId;
        }

        public String getConflictingTrainId() {
            return conflictingTrainId;
        }

        public void setConflictingTrainId(String conflictingTrainId) {
            this.conflictingTrainId = conflictingTrainId;
        }

        public LocalDateTime getConflictStart() {
            return conflictStart;
        }

        public void setConflictStart(LocalDateTime conflictStart) {
            this.conflictStart = conflictStart;
        }

        public LocalDateTime getConflictEnd() {
            return conflictEnd;
        }

        public void setConflictEnd(LocalDateTime conflictEnd) {
            this.conflictEnd = conflictEnd;
        }
    }
}
