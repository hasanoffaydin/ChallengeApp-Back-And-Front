package org.example.challengeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/challenge")
@CrossOrigin
public class ChallengeAppController {
    //private List<Challenge> challenges = new ArrayList<>();
    private ChallengeService challengeService;

    public ChallengeAppController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/getAllChallenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        List<Challenge> challenges = challengeService.getAllChallenges();
        if (challenges != null) {
            return new ResponseEntity<>(challenges, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/getAllChallengesByMonth/{month}")
    public ResponseEntity<Challenge> getAllChallengesByMonth(@PathVariable String month){
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addChallenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded){
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not added successfully", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/putChallenges/{id}")
    public ResponseEntity<String> putChallenge(@PathVariable int id, @RequestBody Challenge challenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, challenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteChallenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable int id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not found", HttpStatus.NOT_FOUND);
        }
    }

}
