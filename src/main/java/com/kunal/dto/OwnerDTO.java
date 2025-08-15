package com.kunal.dto;

import com.kunal.enums.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Kunal Raj S
 */

@Setter
@Getter
@ToString
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

    public void setPetDTO(PetDTO petDTO) {
    }
}
