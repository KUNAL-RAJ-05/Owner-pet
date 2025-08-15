package com.kunal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Kunal Raj S
 */

@Getter
@Setter
@ToString(callSuper = true)
public class WildPetDTO extends PetDTO{
    private String birthPlace;
}
