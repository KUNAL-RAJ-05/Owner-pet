package com.kunal.dto;

import com.kunal.enums.Gender;
import lombok.*;

import java.util.Objects;

/**
 * @author Kunal Raj S
 */

@Setter
@Getter
@AllArgsConstructor()
@NoArgsConstructor
public class OwnerDTO {
    private int ownerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private PetDTO petDTO;

    @Override
    public String toString() {
        if(Objects.isNull(petDTO)){
            return "OwnerDTO{" +
                    "ownerId=" + ownerId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", gender=" + gender +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", emailId='" + emailId + '\'' +
                    '}';
        }
        return "OwnerDTO{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", petDTO=" + petDTO +
                '}';
    }
}
