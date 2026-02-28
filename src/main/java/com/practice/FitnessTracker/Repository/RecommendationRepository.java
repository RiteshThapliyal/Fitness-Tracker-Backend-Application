package com.practice.FitnessTracker.Repository;

import com.practice.FitnessTracker.DataBags.Recommendation;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {

    @Nullable List<Recommendation> findAllByUserId(String userId);

    @Nullable List<Recommendation> findAllByActivityId(String activityId);
}
