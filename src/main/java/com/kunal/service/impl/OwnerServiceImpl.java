package com.kunal.service.impl;

import com.kunal.dto.OwnerDTO;
import com.kunal.exception.DuplicateOwnerIdException;
import com.kunal.exception.OwnerNotFoundException;
import com.kunal.repository.OwnerRepository;
import com.kunal.service.OwnerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kunal Raj S
 */

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private final String ownerAlreadyExists;
    private final String ownerNotFound;

    public OwnerServiceImpl(OwnerRepository ownerRepository, @Value("${owner.not.found}") String ownerNotFound,@Value("${owner.exists}")String ownerAlreadyExists) {
        this.ownerRepository = ownerRepository;
        this.ownerNotFound=ownerNotFound;
        this.ownerAlreadyExists=ownerAlreadyExists;
    }

    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
        if(ownerRepository.findById(ownerDTO.getOwnerId()).isPresent())
        {
            throw new DuplicateOwnerIdException(String.format(ownerAlreadyExists,ownerDTO.getOwnerId()));
        }else{
            ownerRepository.save(ownerDTO);
        }
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId)
                .orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId)
                .orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
        ownerRepository.updatePetDetails(ownerId,petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId)
                .orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDTO> findAllOwner() {
        return ownerRepository.findAll();
    }
}
