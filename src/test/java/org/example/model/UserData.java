package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder// generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // generates no-arg constructor
@AllArgsConstructor     // generates all-arg constructor
public class UserData {
    private String scenarioID;
    private String run;
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
