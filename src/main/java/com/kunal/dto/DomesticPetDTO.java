package com.kunal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Kunal Raj S
 */

@Getter
@Setter
public class DomesticPetDTO extends PetDTO{
    private LocalDate birthDate;

    @Override
    public String toString() {
        if (Objects.nonNull(getOwnerDTO())) {
            return "WildPetDTO [id=" + getPetId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
                    + getPetType() + ", birthDate=" + birthDate + ", ownerDTO=" + getOwnerDTO() + "]";
        } else {
            return "WildPetDTO [id=" + getPetId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
                    + getPetType() + ", birthDate=" + birthDate + "]";
        }
    }
}
