package com.TrackOSProject.TrackOS.Repository;

import com.TrackOSProject.TrackOS.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
}
