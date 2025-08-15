package com.kunal.service;

import com.kunal.dto.OwnerDTO;
import com.kunal.exception.DuplicateOwnerIdException;
import com.kunal.exception.OwnerNotFoundException;

import java.util.List;

/**
 * @author Kunal Raj S
 */

public interface OwnerService {

    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwner();
}
