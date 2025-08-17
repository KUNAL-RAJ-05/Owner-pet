package com.kunal.Ownerpet.service.test;

import com.kunal.dto.DomesticPetDTO;
import com.kunal.dto.PetDTO;
import com.kunal.exception.PetNotFoundException;
import com.kunal.repository.impl.PetRepositoryImpl;
import com.kunal.service.impl.PetServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

/**
 * @author Kunal Raj S
 */
@TestPropertySource("classpath:messges.properties")
@SpringBootTest(classes = PetServiceImpl.class)
class PetServiceImplTest {
    @Autowired
    private PetServiceImpl petService;
    @MockBean
    private PetRepositoryImpl petRepository;

    @Test
    void testFindPetWhenFound() throws PetNotFoundException{
        DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
        Optional<PetDTO> optionalPetDTO = Optional.of(expectedPetDTO);
        when(petRepository.findById(1)).thenReturn(optionalPetDTO);
        PetDTO actualPetDTO = petService.findPet(1);
        assertEquals(expectedPetDTO, actualPetDTO);
        verify(petRepository, times(1)).findById(1);
    }

    @Test
    void testFindPetWhenNotFound(){
        String expectedMessage = "Can't find pet with petId 2";
        Optional<PetDTO> optionalPetDTO = Optional.empty();
        when(petRepository.findById(2)).thenReturn(optionalPetDTO);
        PetNotFoundException actualException = assertThrows(PetNotFoundException.class,()->petService.findPet(2));
        assertEquals(expectedMessage,actualException.getMessage());
        verify(petRepository,times(1)).findById(2);
    }
}
