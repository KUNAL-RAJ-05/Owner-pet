package com.kunal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author Kunal Raj S
 */

@Getter
@Setter
@ToString(callSuper = true)
public class DomesticPetDTO extends PetDTO{
    private LocalDate birthDate;
}
