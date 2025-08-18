package com.kunal.dto;

import com.kunal.enums.Gender;
import com.kunal.enums.PetType;
import lombok.*;


/**
 * @author Kunal Raj S
 */

@NoArgsConstructor
@ToString(callSuper = true)
@Setter
@Getter
public class WildPetDTO extends PetDTO{
    private String birthPlace;

    @Builder
    public WildPetDTO(int id, String name, Gender gender, PetType type,OwnerDTO ownerDTO,String birthPlace)
    {
        super(id,name,gender,type,ownerDTO);
        this.birthPlace=birthPlace;
    }

}
