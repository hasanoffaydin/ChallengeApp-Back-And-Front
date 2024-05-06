package org.example.challengeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    //private List<Challenge> challenges = new ArrayList<>();
    private ChallengeRepository challengeRepository;
    private int nextChallengeId = 1;
    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }
    public Challenge getChallengeByMonth(String month) {
        Optional<Challenge> challengeOptinal = challengeRepository.findByMonth(month);
        return challengeOptinal.orElse(null);
    }
    public boolean addChallenge(Challenge challenge) {
        if(challenge != null) {
            challenge.setId(nextChallengeId+1);
            nextChallengeId++;
            challengeRepository.save(challenge);
            return true;
        }
        else {
            return false;

        }
    }
    public boolean updateChallenge(int id, Challenge challenge) {
        Optional<Challenge> challengeOpt = challengeRepository.findById(id);
        if(challengeOpt.isPresent()) {
            Challenge challengeToUpdate = challengeOpt.get();
            challengeToUpdate.setMonth(challenge.getMonth());
            challengeToUpdate.setDescription(challenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }
    public boolean deleteChallenge(int id) {
        Optional<Challenge> challengeOptinal = challengeRepository.findById(id);
        if(challengeOptinal.isPresent()) {
            challengeRepository.delete(challengeOptinal.get());
            return true;
        }
        return false;
    }

}
