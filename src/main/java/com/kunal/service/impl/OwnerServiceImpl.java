package com.kunal.service.impl;

import com.kunal.dto.OwnerDTO;
import com.kunal.entity.Owner;
import com.kunal.util.OwnerMapper;
import com.kunal.exception.OwnerNotFoundException;
import com.kunal.repository.OwnerRepository;
import com.kunal.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kunal Raj S
 */
@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    @Value("${owner.not.found}")
    private String ownerNotFound;

    @Override
    public void saveOwner(OwnerDTO ownerDTO) {
        Owner owner = OwnerMapper.ownerDTOtoOwner(ownerDTO);
        ownerRepository.save(owner);
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId)
                .map(ownerMapper::ownerToOwnerDTO)
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
