package com.kunal.repository.impl;

import com.kunal.dto.DomesticPetDTO;
import com.kunal.dto.OwnerDTO;
import com.kunal.dto.PetDTO;
import com.kunal.enums.Gender;
import com.kunal.enums.PetType;
import com.kunal.repository.PetRepository;
import com.kunal.service.impl.PetServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kunal.enums.Gender.M;

/**
 * @author Kunal Raj S
 */

@Repository
public class PetRepositoryImpl implements PetRepository {

    private List<PetDTO> petDTOList;

    public PetRepositoryImpl()
    {
        this.petDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        DomesticPetDTO petDTO = new DomesticPetDTO();
        petDTO.setPetId(1);
        petDTO.setName("Max");
        petDTO.setGender(Gender.M);
        petDTO.setPetType(PetType.DOG);
        petDTO.setBirthDate(LocalDate.of(2018,7,26));
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setOwnerId(1);
        ownerDTO.setFirstName("Kunal");
        ownerDTO.setLastName("Raj");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Ben");
        ownerDTO.setState("KAR");
        ownerDTO.setMobileNumber("123456788");
        ownerDTO.setEmailId("Kunal@gami.com");
        petDTO.setOwnerDTO(ownerDTO);
        petDTOList.add(petDTO);
    }

    @Override
    public Optional<PetDTO> findById(int petId) {
        return petDTOList.stream()
                .filter( pet -> pet.getPetId() == petId)
                .findFirst();
    }
}
