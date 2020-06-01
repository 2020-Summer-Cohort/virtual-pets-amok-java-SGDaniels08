package pets_amok;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        VirtualPetShelter shelterAmok = new VirtualPetShelter();
        shelterAmok.initializeSmallShelter();    // Add 3 OrganicDogs, 1 RobotDogs, 2 OrganicCats, and 2 RoboticCats

        int choice;
        boolean keepSheltering = true;

        while (keepSheltering) {
            System.out.println("Welcome to our Virtual Pet Shelter!");
            System.out.println("We have dogs and cats, robotic and organic");
            System.out.println("for you to play with, donate, or adopt!");

            displayAllOrganicPets(shelterAmok);
            displayAllRoboticPets(shelterAmok);

            System.out.println("What would you like to do?");
            displayShelterMenu();
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) { keepSheltering = false; }
            else if (choice == 1) { shelterAmok.allPetsEat(); }
            else if (choice == 2) { shelterAmok.allPetsDrink(); }
            else if (choice == 3) { shelterAmok.cleanAllCages(); }
            else if (choice == 4) { shelterAmok.allPetsOiled(); }
            else if (choice == 5) { shelterAmok.allPetsWalked(); }
            else if (choice == 6) {
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
            else if (choice == 7) {
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
            else if (choice == 8) {
                // Accept a new pet
                VirtualPet newPet = intakeProcess();
                shelterAmok.intakePet(newPet);
            }
            else {
                System.out.println("That was not a valid choice, let's start over!");
                continue;
            }

            shelterAmok.tick();

            ArrayList<String> deceased = new ArrayList<>();
            deceased = shelterAmok.findDeceased();
            shelterAmok.removeDeceased(deceased);
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
            } else if (choice == 3) {
                animal = new OrganicCat(name, description, happiness, health,50,50,0);
                return animal;
            } else if (choice == 4) {
                animal = new RoboticCat(name, description, happiness, health, 50);
                return animal;
            } else {
                System.out.println("Invalid choice, please try again: ");
                continue;
            }
        }
    }

    public static void displayShelterMenu() {
        System.out.println("1 : Feed all organic pets");
        System.out.println("2 : Water all organic pets");
        System.out.println("3 : Clean all organic dog cages");
        System.out.println("4 : Oil and maintain all robotic pets");
        System.out.println("5 : Take all dogs for a walk");
        System.out.println("6 : Play with one pet (choose one)");
        System.out.println("7 : Adopt a pet -- take one home today!");
        System.out.println("8 : Donate a pet -- add it to the shelter!");
        System.out.println("0 : Leave");
        System.out.print("Choose --> ");
    }

    public static void displayAllOrganicPets(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();

        System.out.println("ORGANIC PETS");
        System.out.println("NAME\t\tSpecies\tHunger\tThirst\tBathroom\tHappiness\tHealth\t\tCage Filth (organic dogs only)");

        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();

            if (petToShow instanceof OrganicDog) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print("Dog\t\t\t");
                System.out.print(((OrganicDog) petToShow).getHunger() + "\t\t");
                System.out.print(((OrganicDog) petToShow).getThirst() + "\t\t");
                System.out.print(((OrganicDog) petToShow).getBathroom() + "\t\t");
                System.out.print(((OrganicDog) petToShow).getHappiness() + "\t\t\t");
                System.out.print(((OrganicDog) petToShow).getHealth() + "\t\t\t\t");
                System.out.print(((OrganicDog) petToShow).getCageFilth() + "\n");
            } else if (petToShow instanceof OrganicCat) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print("Cat\t\t\t");
                System.out.print(((OrganicCat) petToShow).getHunger() + "\t\t");
                System.out.print(((OrganicCat) petToShow).getThirst() + "\t\t");
                System.out.print(((OrganicCat) petToShow).getBathroom() + "\t\t");
                System.out.print(((OrganicCat) petToShow).getHappiness() + "\t\t\t\t");
                System.out.print(((OrganicCat) petToShow).getHealth() + "\n");
            }
        }
    }
    public static void displayAllRoboticPets(VirtualPetShelter anyShelter) {
        Map<String, VirtualPet> shelter = anyShelter.retrieveAllPets();

        System.out.println("ROBOTIC PETS");
        System.out.println("NAME\t\tSpecies\t\tHappiness\tHealth\tMaintenance Needed");

        for (Map.Entry<String, VirtualPet> entry : shelter.entrySet()) {
            VirtualPet petToShow = entry.getValue();
            if (petToShow instanceof RoboticDog) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print("Dog\t\t\t\t");
                System.out.print(petToShow.getHappiness() + "\t\t");
                System.out.print(petToShow.getHealth() + "\t\t");
                System.out.print(((RoboticDog) petToShow).getMaintenanceNeeded() + "\n");
            } else if (petToShow instanceof RoboticCat) {
                System.out.print(petToShow.getName() + "\t\t");
                System.out.print("Cat\t\t\t\t");
                System.out.print(petToShow.getHappiness() + "\t\t");
                System.out.print(petToShow.getHealth() + "\t\t");
                System.out.print(((RoboticCat) petToShow).getMaintenanceNeeded() + "\n");
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
