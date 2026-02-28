package com.practice.FitnessTracker.Controller;

import com.practice.FitnessTracker.DTO.ActivityRequest;
import com.practice.FitnessTracker.DTO.ActivityResponse;
import com.practice.FitnessTracker.DataBags.Activity;
import com.practice.FitnessTracker.Service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/trackActivity")
    public ResponseEntity<ActivityResponse> trackActivity (@RequestBody ActivityRequest activityRequest) {
        return ResponseEntity.ok(activityService.track(activityRequest));
    }

    @GetMapping("getActivity")
    public ResponseEntity<List<ActivityResponse>> getUserActivity (@RequestHeader(value = "X-User-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivity(userId));
    }
}
