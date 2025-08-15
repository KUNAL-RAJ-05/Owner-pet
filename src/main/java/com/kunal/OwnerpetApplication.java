package com.kunal;

import com.kunal.dto.OwnerDTO;
import com.kunal.dto.PetDTO;
import com.kunal.service.OwnerService;
import com.kunal.service.PetService;
import com.kunal.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

/**
 * @author Kunal Raj S
 */

@SpringBootApplication
public class OwnerpetApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerpetApplication.class);
	private final OwnerService ownerService;
	private final PetService petService;

	public OwnerpetApplication(OwnerService ownerService, PetService petService) {
		this.ownerService = ownerService;
		this.petService = petService;
	}

	public static void main(String[] args) {

		SpringApplication.run(OwnerpetApplication.class, args);
	}
	public void run(String... args) throws Exception
	{
		try(Scanner scanner = new Scanner(System.in)){
			do{
				System.out.println("Welcome to Petistan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption){
					case 1:
						OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
						PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
						ownerDTO.setPetDTO(petDTO);
						ownerService.saveOwner(ownerDTO);
						System.out.println("Owner has been saved successfully.");
						break;
					case 2:
						int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerDTO = ownerService.findOwner(ownerId);
						System.out.println("Owner has been fetched successfully.");
						System.out.println(ownerDTO);
						break;
					case 3:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
						ownerService.updatePetDetails(ownerId, petName);
						System.out.println(String.format("Updated petName to %s for owner with ownerId %s.", petName, ownerId));
						break;
					case 4:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerService.deleteOwner(ownerId);
						System.out.println(String.format("Deleted owner with ownerId %s.",ownerId));
						break;
					case 5:
						List<OwnerDTO> ownerDTOList = ownerService.findAllOwner();
						System.out.println(String.format("There are %s owners.",ownerDTOList.size()));
						ownerDTOList.forEach(n -> System.out.println(n.toString()));
						break;
					case 6:
						int petId = InputUtil.acceptPetIdToOperate(scanner);
						petDTO = petService.findPet(petId);
						System.out.println(String.format("Found pet with petId %s.", petId));
						System.out.println(petDTO);
						break;
					default:
						System.out.println("Invalid option entered.");
				}
			}while (InputUtil.wantToContinue(scanner));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
	}


}
