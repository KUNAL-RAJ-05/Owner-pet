package com.kunal.util;

import com.kunal.dto.OwnerDTO;
import com.kunal.dto.PetDTO;

import java.util.Scanner;

public class InputUtil {
    public static int acceptMenuOption(Scanner scanner) {
        System.out.println("Press 1 to add new owner.");
        System.out.println("Press 2 to fetch owner details.");
        System.out.println("Press 3 to update pet details of owner");
        System.out.println("Press 4 to delete owner details");
        System.out.println("Press 5 to fetch all owners");
        System.out.println("Press 6 to fetch pet details");
        int menuOption = scanner.nextInt();
        if(menuOption >= 1 && menuOption <= 6){
            return menuOption;
        }else {
            System.out.println("Invalid option entered");
            return acceptMenuOption(scanner);
        }
    }
    public static boolean wantToContinue(Scanner scanner){
        System.out.println("Press Y to continue and N to exit");
        char choice = scanner.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static OwnerDTO acceptOwnerDetailsToSave(Scanner scanner) {
        return null;
    }

    public static PetDTO acceptPetDetailsToSave(Scanner scanner) {
        return null;
    }

    public static int acceptOwnerIdToOperate(Scanner scanner) {
        return 0;
    }

    public static String acceptPetDetailsToUpdate(Scanner scanner) {
        return "";
    }
}
