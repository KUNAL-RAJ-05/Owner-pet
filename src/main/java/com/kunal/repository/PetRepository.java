package com.kunal.repository;

import com.kunal.dto.PetDTO;

import java.util.Optional;

/// @author Kunal Raj S
public interface PetRepository {

    Optional<PetDTO> findById(int petId);
}
