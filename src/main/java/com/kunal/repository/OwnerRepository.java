package com.kunal.repository;

import com.kunal.dto.OwnerDTO;
import com.kunal.exception.DuplicateOwnerIdException;
import com.kunal.exception.OwnerNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author Kunal Raj S
 */

public interface OwnerRepository {

    void save(OwnerDTO ownerDTO);

    Optional<OwnerDTO> findById(int ownerId);

    void updatePetDetails(int ownerId, String petName);

    void deleteById(int ownerId);

    List<OwnerDTO> findAll();
}
