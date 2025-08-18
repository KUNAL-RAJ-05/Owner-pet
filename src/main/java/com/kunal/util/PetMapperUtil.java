package com.kunal.util;

import com.kunal.dto.OwnerDTO;
import com.kunal.dto.PetDTO;
import com.kunal.dto.WildPetDTO;
import com.kunal.entity.DomesticPet;
import com.kunal.entity.Pet;
import com.kunal.entity.WildPet;

public class PetMapperUtil {

    private  static final String UNSUPPORTED_PET_INSTANCE = "Unsupported pet instance: %s";

    public static PetDTO pettoPetDTO(Pet pet)
    {
        return switch (pet) {
            case DomesticPet domesticPet -> domesticPetToDomesticPetDTO(domesticPet);
            case WildPet wildPet -> wildPetToWildPetDTO(wildPet);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, pet.getClass()));
        };
    }

    private static PetDTO wildPetToWildPetDTO(WildPet wildPet) {
        OwnerDTO ownerDTO = ownerToOwnerDTOWithoutPet(wildPet.getOwner());
        return WildPetDTO.builder()
                .id(wildPet.getId())
                .name(wildPet.getName())
                .gender(wildPet.getGender())
                .type(wildPet.getType())
                .birthPlace(wildPet.getBirthPlace())
                .ownerDTO(ownerDTO)
                .build();

    }

    private static PetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet) {
    }

}
