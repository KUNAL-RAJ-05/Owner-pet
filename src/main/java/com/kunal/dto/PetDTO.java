package com.kunal.dto;

import com.kunal.enums.Gender;
import com.kunal.enums.PetType;
import lombok.*;

import java.util.Objects;

/**
 * @author Kunal Raj S
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private int petId;
    private String name;
    private Gender gender;
    private PetType petType;
    private OwnerDTO ownerDTO;

    @Override
    public String toString() {
        if(Objects.isNull(ownerDTO)){
            return "PetDTO{" +
                    "petId=" + petId +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", petType=" + petType +
                    '}';
        }
        return "PetDTO{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", petType=" + petType +
                ", ownerDTO=" + ownerDTO +
                '}';
    }
}
