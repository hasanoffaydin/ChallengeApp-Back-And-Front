package org.example.challengeapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    Optional<Challenge> findByMonth(String month);
    Optional<Challenge> findById(int id);
}
