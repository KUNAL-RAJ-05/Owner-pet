package com.kunal.dto;

import com.kunal.enums.Gender;
import lombok.*;

import java.util.Objects;

/**
 * @author Kunal Raj S
 */

@Builder
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor()
@NoArgsConstructor
@ToString
public class OwnerDTO {

    @EqualsAndHashCode.Include
    private int ownerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;
    @EqualsAndHashCode.Include
    private String mobileNumber;
    @EqualsAndHashCode.Include
    private String emailId;
    private PetDTO petDTO;

}
