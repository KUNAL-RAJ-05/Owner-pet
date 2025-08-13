package com.kunal.service;

import com.kunal.dto.OwnerDTO;

public interface OwnerService {

    void saveOwner(OwnerDTO ownerDTO);

    OwnerDTO findOwner(int ownerId);

    void updatePetDetails(int ownerId, String petName);
}
