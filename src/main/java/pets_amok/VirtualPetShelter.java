package pets_amok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    private Map<String, VirtualPet> shelterInhabitants = new HashMap<>();

    public Map<String, VirtualPet> retrieveAllPets() {
        return shelterInhabitants;
    }

    public VirtualPet getPet(String name) {
        return shelterInhabitants.get(name);
    }

    public void allPetsEat() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toFeed = entry.getValue();

            if (toFeed instanceof OrganicPet) {
                ((OrganicPet) toFeed).eat();
            }
        }
    }
    public void allPetsDrink() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toWater = entry.getValue();

            if (toWater instanceof OrganicPet) {
                ((OrganicPet) toWater).drink();
            }
        }
    }
    public void allPetsOiled() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toOil = entry.getValue();

            if (toOil instanceof RoboticPet) {
                ((RoboticPet) toOil).maintain();
            }
        }
    }
    public void allPetsWalked() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toWalk = entry.getValue();

            if (toWalk instanceof Dog) {
                ((Dog) toWalk).walkies();
            }
        }
    }
    public void playWith(String playPetName) {
        VirtualPet playPet = getPet(playPetName);
        playPet.play();
    }
    public void cleanAllCages() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet toClean = entry.getValue();

            if (toClean instanceof OrganicDog) {
                ((OrganicDog) toClean).cleanCage();
            }
        }
    }

    public void intakePet(VirtualPet takenIn) {
        shelterInhabitants.put(takenIn.getName(), takenIn);
    }
    public void adoptPet(String name) {
        shelterInhabitants.remove(name);
    }
    public boolean contains(String name) {
        return shelterInhabitants.containsKey(name);
    }
    public boolean isEmpty() {
        return shelterInhabitants.isEmpty();
    }
    public ArrayList<String> findDeceased() {
        ArrayList<String> deceased = new ArrayList<>();
        String name;

        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet testDead = entry.getValue();
            if (!testDead.isAlive()) {
                name = testDead.getName();
                deceased.add(name);
            }
        }
        return deceased;
    }
    public void removeDeceased(ArrayList<String> deceased) {
        for (String name : deceased) { shelterInhabitants.remove(name); }
    }

    public void tick() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet tickPet = entry.getValue();
            tickPet.tick();

            // If health reaches 0, pet dies / breaks down
            if (tickPet.isAlive() == false) {
                String deceased = tickPet.getName();
                System.out.println("Oh no! " + deceased + " has expired. Farewell, " + deceased + ".");
             }
        }
    }

    public void initializeShelter() {
        // Add 5 OrganicDogs, 3 RobotDogs, 3 OrganicCats, and 2 RoboticCats

        // Organic dogs
        OrganicDog doggo1 = new OrganicDog("Rex", "A friendly-looking mutt", 50, 50, 50, 50, 50, 50);
        OrganicDog doggo2 = new OrganicDog("Rover", "A happy Dalmatian",30, 40, 50, 60, 70,80);
        OrganicDog doggo3 = new OrganicDog("Fido", "A sleepy old hound",10, 15,
                35, 20, 45, 20);
        OrganicDog doggo4 = new OrganicDog("Buggle", "A bouncy little Border Collie", 75,
                40, 35, 70, 30, 50);
        OrganicDog doggo5 = new OrganicDog("Daxeon", "A generally nervous English Shepherd",
                45, 65, 60, 55, 45, 20);
        // Robotic dogs
        RoboticDog robDog1 = new RoboticDog("Astro", "He's polished to a blinding sheen!",
                50, 50, 50);
        RoboticDog robDog2 = new RoboticDog("F1d0", "His coat is burnished steel",
                45, 30, 85);
        RoboticDog robDog3 = new RoboticDog("B3nd3r", "Its 40% iron!",
                75, 15, 95);
        // Organic cats
        OrganicCat testKitty1 = new OrganicCat("Arya", "A chubby floof", 80,
                45,90,60,60);
        OrganicCat testKitty2 = new OrganicCat("Freya", "She looks like a ghost!", 65,40,
                95,60,65);
        OrganicCat testKitty3 = new OrganicCat("Shabadu", "Super-cute!",
                75, 65, 55, 40, 35);
        // Robotic cats
        RoboticCat botCat1 = new RoboticCat("0lg4", "Is she purring or is that an electrical problem?",
                50, 50, 50);
        RoboticCat botCat2 = new RoboticCat("Kit-10", "Unnervingly humanoid",
                50, 50, 68);

        // Add to shelter
        shelterInhabitants.put(doggo1.getName(), doggo1);
        shelterInhabitants.put(doggo2.getName(), doggo2);
        shelterInhabitants.put(doggo3.getName(), doggo3);
        shelterInhabitants.put(doggo4.getName(), doggo4);
        shelterInhabitants.put(doggo5.getName(), doggo5);
        shelterInhabitants.put(robDog1.getName(), robDog1);
        shelterInhabitants.put(robDog2.getName(), robDog2);
        shelterInhabitants.put(robDog3.getName(), robDog3);
        shelterInhabitants.put(testKitty1.getName(), testKitty1);
        shelterInhabitants.put(testKitty2.getName(), testKitty2);
        shelterInhabitants.put(testKitty3.getName(), testKitty3);
        shelterInhabitants.put(botCat1.getName(), botCat1);
        shelterInhabitants.put(botCat2.getName(), botCat2);
    }
}
