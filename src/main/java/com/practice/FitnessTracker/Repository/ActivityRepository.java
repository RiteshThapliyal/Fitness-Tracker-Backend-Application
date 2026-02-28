package com.practice.FitnessTracker.Repository;

import com.practice.FitnessTracker.DataBags.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, String> {
    List<Activity> findByUserId(String userId);
}
