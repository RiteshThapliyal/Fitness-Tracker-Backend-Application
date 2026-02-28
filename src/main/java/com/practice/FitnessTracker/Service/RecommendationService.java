package com.practice.FitnessTracker.Service;

import com.practice.FitnessTracker.DTO.RecommendationRequest;
import com.practice.FitnessTracker.DTO.RecommendationResponse;
import com.practice.FitnessTracker.DataBags.Activity;
import com.practice.FitnessTracker.DataBags.Recommendation;
import com.practice.FitnessTracker.DataBags.User;
import com.practice.FitnessTracker.Repository.ActivityRepository;
import com.practice.FitnessTracker.Repository.RecommendationRepository;
import com.practice.FitnessTracker.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public @Nullable RecommendationResponse generateRecommendation(RecommendationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found by ID: " + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found By ID: " + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .safety(request.getSafety())
                .suggestions(request.getSuggestions())
                .build();
        Recommendation storeRecommendation = recommendationRepository.save(recommendation);
        return mapToResponse(storeRecommendation);
    }

    private @Nullable RecommendationResponse mapToResponse(Recommendation storeRecommendation) {
        RecommendationResponse response = new RecommendationResponse();
        response.setId(storeRecommendation.getId());
        response.setUserId(storeRecommendation.getUser().getId());
        response.setActivityId(storeRecommendation.getActivity().getId());
        response.setType(storeRecommendation.getType());
        response.setRecommendation(storeRecommendation.getRecommendation());
        response.setImprovements(storeRecommendation.getImprovements());
        response.setSafety(storeRecommendation.getSafety());
        response.setSuggestions(storeRecommendation.getSuggestions());
        response.setCreatedAt(storeRecommendation.getCreatedAt());
        response.setUpdatedAt(storeRecommendation.getUpdatedAt());
        return response;
    }

    public @Nullable List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findAllByUserId(userId);
    }

    public @Nullable List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findAllByActivityId(activityId);
    }
}
