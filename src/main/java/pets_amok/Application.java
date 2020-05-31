package pets_amok;

import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        VirtualPetShelter shelterAmok = new VirtualPetShelter();
        shelterAmok.initializeShelter();    // Add 5 OrganicDogs and 3 RobotDogs

        int choice;
        boolean keepSheltering = true;

        while (keepSheltering) {
            System.out.println("Welcome to our Virtual Pet Shelter!");
            System.out.println("We have dogs and cats, robotic and organic");
            System.out.println("for you to play with, donate, or adopt!");

            displayOrganicPets(shelterAmok);
            displayRoboticPets(shelterAmok);

            System.out.println("What would you like to do?");
            displayShelterMenu();
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) { keepSheltering = false; }
            else if (choice == 1) { shelterAmok.allPetsEat(); }
            else if (choice == 2) { shelterAmok.allPetsDrink(); }
            else if (choice == 3) { shelterAmok.cleanAllCages(); }
            else if (choice == 4) { shelterAmok.allPetsOiled(); }
            else if (choice == 5) {
                // Play with a Pet
                String petName;
                System.out.println("Which pet would you like to play with?");
                displayPetNamesAndDescriptions(shelterAmok);
                petName = input.nextLine();

                if (shelterAmok.contains(petName)) {
                    shelterAmok.playWith(petName);
                } else {
                    System.out.println("That pet doesn't seem to be in our system; please try again.");
                    continue;
                }
            }
            else if (choice == 6) {
                // Adopt out a pet
                String petName;
                System.out.println("Which pet would you like to adopt?");
                displayPetNamesAndDescriptions(shelterAmok);
                petName = input.nextLine();

                if (shelterAmok.contains(petName)) {
                    shelterAmok.adoptPet(petName);
                    System.out.println("So long, " + petName + "!");
                } else {
                    System.out.println("That pet doesn't seem to be in our system; please try again.");
                    continue;
                }
            }
            else if (choice == 7) {
                // Accept a new pet
                VirtualPet newPet = intakeProcess();
                shelterAmok.intakePet(newPet);
            }
            else {
                System.out.println("That was not a valid choice, let's start over!");
                continue;
            }

            shelterAmok.tick();
            if (shelterAmok.isEmpty()) { keepSheltering = false; }
        }

        System.out.println("\n\nGoodbye, thanks for visiting!");
    }


    /*
     *      Methods for main()
     */

    private static VirtualPet intakeProcess() {
        Scanner input = new Scanner(System.in);
        int choice;
        String name;
        String description;
        int happiness;
        int health;
        VirtualPet animal;

        while (true) {
            System.out.println("Please tell us about the pet you would like to donate:\n");
            System.out.println("BREED (choose one)");
            System.out.println("1: Organic Dog\t\t2: Robotic Dog");
            System.out.println("3: Organic Cat\t\t4: Robotic Cat");

            choice = input.nextInt();
            input.nextLine();

            System.out.println("What is the pet's name?");
            name = input.nextLine();
            System.out.println("How would you describe the pet?");
            description = input.nextLine();
            System.out.println("1-100 , how happy is the pet?");
            happiness = input.nextInt();
            System.out.println("1-100 , how healthy is the pet?");
            health = input.nextInt();

            if (choice == 1) {
                animal = new OrganicDog(name, description, happiness, health, 50,50,0,0);
                return animal;
            } else if (choice == 2) {
                animal = new RoboticDog(name, description, happiness, health, 50);
                return animal;
//            } else if (choice == 3) {
//            } else if (choice == 4) {
            } else {
                System.out.println("Invalid choice, please try again: ");
                continue;
            }
        }
    }

    public static void displayShelterMenu() {
        System.out.println("1 : Feed all organic pets");
        System.out.println("2 : Water all organic dogs");
        System.out.println("3 : Clean all organic dog cages");
        System.out.println("4 : Oil and maintain all robotic pets");
        System.out.println("5 : Play with one pet (choose one)");
        System.out.println("6 : Adopt a pet -- take one home today!");
        System.out.println("7 : Donate a pet -- add it to the shelter!");
        System.out.println("0 : Leave");
        System.out.print("Choose --> ");
    }

    public static void displayOrganicPets(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();

        System.out.println("ORGANIC PETS");
        System.out.println("NAME\t\tHunger\tThirst\tBathroom\tHappiness");

        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            if (petToShow instanceof OrganicPet) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print(((OrganicPet) petToShow).getHunger() + "\t\t");
                System.out.print(((OrganicPet) petToShow).getThirst() + "\t\t");
                System.out.print(((OrganicPet) petToShow).getBathroom() + "\t\t");
                System.out.print(((OrganicPet) petToShow).getHealth() + "\n");
            }
        }
    }
    public static void displayRoboticPets(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();

        System.out.println("ROBOTIC PETS");
        System.out.println("NAME\t\tMaintenanceNeeded\tHappiness");

        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            if (petToShow instanceof RoboticPet) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print(((RoboticPet) petToShow).getMaintenanceNeeded() + "\t\t");
                System.out.print(((RoboticPet) petToShow).getHealth() + "\n");
            }
        }
    }

    private static void displayPetNames(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();
        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            System.out.println("[ " + petToShow.getName() + " ]");
        }
    }

    private static void displayPetNamesAndDescriptions(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();
        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            System.out.println("[ " + petToShow.getName() + " ]" + petToShow.getDescription());
        }
    }
}
