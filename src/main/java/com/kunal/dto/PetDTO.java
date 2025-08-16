package com.kunal.dto;

import com.kunal.enums.Gender;
import com.kunal.enums.PetType;
import lombok.*;

/**
 * @author Kunal Raj S
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private int petId;
    private String name;
    private Gender gender;
    private PetType petType;
    private OwnerDTO ownerDTO;
}
