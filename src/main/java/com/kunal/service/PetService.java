package com.kunal.service;

import com.kunal.dto.PetDTO;
import com.kunal.exception.PetNotFoundException;

/**
 * @author Kunal Raj S
 */

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
