package com.kunal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


/**
 * @author Kunal Raj S
 */

@Getter
@Setter
public class WildPetDTO extends PetDTO{
    private String birthPlace;

    @Override
    public String toString() {
        if (Objects.nonNull(getOwnerDTO())) {
            return "WildPetDTO [id=" + getPetId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
                    + getPetType() + ", birthPlace=" + birthPlace + ", ownerDTO=" + getOwnerDTO() + "]";
        } else {
            return "WildPetDTO [id=" + getPetId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
                    + getPetType() + ", birthPlace=" + birthPlace + "]";
        }
    }
}
