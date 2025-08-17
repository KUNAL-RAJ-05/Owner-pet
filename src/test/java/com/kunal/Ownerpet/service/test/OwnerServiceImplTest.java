package com.kunal.Ownerpet.service.test;

import com.kunal.dto.DomesticPetDTO;
import com.kunal.dto.OwnerDTO;
import com.kunal.exception.DuplicateOwnerIdException;
import com.kunal.exception.OwnerNotFoundException;
import com.kunal.repository.OwnerRepository;
import com.kunal.repository.impl.OwnerRepositoryImpl;
import com.kunal.service.impl.OwnerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Kunal Raj S
 */

@TestPropertySource("classpath:messges.properties")
@SpringBootTest(classes = OwnerServiceImpl.class)
public class OwnerServiceImplTest {

    @Autowired
    private OwnerServiceImpl ownerServiceImpl;
    @MockBean
    private OwnerRepository ownerRepository;

    @Test
    void testSaveOwnerWhenNewOwnerId() throws DuplicateOwnerIdException {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setOwnerId(1);
        Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
        when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
        ownerServiceImpl.saveOwner(expectedOwnerDTO);
        verify(ownerRepository, times(1)).findById(1);
        verify(ownerRepository, times(1)).save(expectedOwnerDTO);
    }

    @Test
    void testSaveOwnerWhenExistingOwnerId() {
        String expectedMessage = "Owner already exixts with OwnerId 2";
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setOwnerId(2);
        Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
        when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
        DuplicateOwnerIdException actualException = assertThrows(DuplicateOwnerIdException.class,
                () -> ownerServiceImpl.saveOwner(expectedOwnerDTO));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(ownerRepository, times(1)).findById(2);
    }

    @Test
    void testFindOwnerWhenFound() throws OwnerNotFoundException {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setOwnerId(1);
        Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
        when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
        OwnerDTO actualOwnerDTO = ownerServiceImpl.findOwner(1);
        assertEquals(expectedOwnerDTO, actualOwnerDTO);
        verify(ownerRepository, times(1)).findById(1);
    }

    @Test
    void testFindOwnerWhenNotFound() {
        String expectedMessage = "Can't find owner with OwnerId 2";
        Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
        when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
        OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
                () -> ownerServiceImpl.findOwner(2));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(ownerRepository, times(1)).findById(2);
    }

    @Test
    void testUpdatePetDetailsWhenFound() throws OwnerNotFoundException {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setOwnerId(1);
        DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
        expectedPetDTO.setPetId(1);
        expectedPetDTO.setName("Max");
        expectedOwnerDTO.setPetDTO(expectedPetDTO);
        Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
        when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
        ownerServiceImpl.updatePetDetails(1, "Tom");
        assertEquals(expectedOwnerDTO.getPetDTO().getName(), optionalOwnerDTO.get().getPetDTO().getName());
        verify(ownerRepository, times(1)).findById(1);
    }

    @Test
    void testUpdatePetDetailsWhenNotFound() {
        String expectedMessage = "Can't find owner with OwnerId 2";
        Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
        when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
        OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
                () -> ownerServiceImpl.updatePetDetails(2, "Tom"));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(ownerRepository, times(1)).findById(2);
    }

    @Test
    void testDeleteOwnerWhenFound() throws OwnerNotFoundException {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setOwnerId(1);
        Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
        when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
        ownerServiceImpl.deleteOwner(1);
        verify(ownerRepository, times(1)).findById(1);
        verify(ownerRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteOwnerWhenNotFound() {
        String expectedMessage = "Can't find owner with OwnerId 2";
        Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
        when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
        OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
                () -> ownerServiceImpl.deleteOwner(2));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(ownerRepository, times(1)).findById(2);
    }

    @Test
    void testFindAllOwners() {
        List<OwnerDTO> expectedOwnerDTOList = new ArrayList<>();
        when(ownerRepository.findAll()).thenReturn(expectedOwnerDTOList);
        List<OwnerDTO> actualOwnerDTOList = ownerServiceImpl.findAllOwner();
        assertNotNull(actualOwnerDTOList);
        verify(ownerRepository, times(1)).findAll();
    }
}
