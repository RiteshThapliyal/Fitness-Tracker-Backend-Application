package com.practice.FitnessTracker.Repository;

import com.practice.FitnessTracker.DataBags.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
