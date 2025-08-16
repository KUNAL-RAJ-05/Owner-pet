package com.kunal.repository.impl;

import com.kunal.dto.DomesticPetDTO;
import com.kunal.dto.OwnerDTO;
import com.kunal.repository.OwnerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kunal.enums.Gender.M;
import static com.kunal.enums.PetType.DOG;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    private List<OwnerDTO> ownerDTOList;

    public OwnerRepositoryImpl(){
        this.ownerDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setOwnerId(1);
        ownerDTO.setFirstName("Kunal");
        ownerDTO.setLastName("Raj");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Ben");
        ownerDTO.setState("KAR");
        ownerDTO.setMobileNumber("123456788");
        ownerDTO.setEmailId("Kunal@gami.com");
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setPetId(1);
        domesticPetDTO.setName("Jimmy");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setPetType(DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2025,8,17));
        ownerDTO.setPetDTO(domesticPetDTO);
        ownerDTOList.add(ownerDTO);
    }
    @Override
    public void save(OwnerDTO ownerDTO) {
        ownerDTOList.add(ownerDTO);
    }

    @Override
    public Optional<OwnerDTO> findById(int ownerId) {
        return ownerDTOList.stream()
                .filter(owner -> owner.getOwnerId() == ownerId)
                .findFirst();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        ownerDTOList.stream()
                .filter(owner -> owner.getOwnerId() == ownerId)
                .findFirst()
                .ifPresent( owner -> owner.getPetDTO().setName(petName));
    }

    @Override
    public void deleteById(int ownerId) {
        ownerDTOList.removeIf(owner -> owner.getOwnerId() == ownerId);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerDTOList;
    }
}
