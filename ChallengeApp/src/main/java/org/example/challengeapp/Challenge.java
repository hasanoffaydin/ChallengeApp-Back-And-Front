package org.example.challengeapp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "challenges")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "month")
    private String month;
    @Column(name = "description")
    private String description;

}