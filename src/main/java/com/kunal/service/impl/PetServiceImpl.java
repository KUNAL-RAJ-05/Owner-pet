package com.kunal.service.impl;

import com.kunal.dto.PetDTO;
import com.kunal.exception.PetNotFoundException;
import com.kunal.repository.PetRepository;
import com.kunal.service.PetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Kunal Raj S
 */
@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    private final String petNotFound;

    public PetServiceImpl(PetRepository petRepository,@Value("${pet.not.found}") String petNotFound){
        this.petRepository=petRepository;
        this.petNotFound = petNotFound;
    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId)
                .orElseThrow(()->new PetNotFoundException(String.format(petNotFound,petId)));
    }
}
