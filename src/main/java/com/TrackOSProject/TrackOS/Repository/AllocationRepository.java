package com.TrackOSProject.TrackOS.Repository;

import com.TrackOSProject.TrackOS.Entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
    List<Allocation> findByTrainId(Long trainId);
}
