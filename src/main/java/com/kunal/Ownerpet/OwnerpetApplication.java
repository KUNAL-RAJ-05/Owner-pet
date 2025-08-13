package com.kunal.Ownerpet;

import com.kunal.dto.OwnerDTO;
import com.kunal.dto.PetDTO;
import com.kunal.service.OwnerService;
import com.kunal.service.PetService;
import com.kunal.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OwnerpetApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerpetApplication.class);
	private OwnerService ownerService;
	private PetService petService;

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
						System.out.println("Pet details of owner have been updated successfullt");

				}
			}while (true);
		}
	}


}
