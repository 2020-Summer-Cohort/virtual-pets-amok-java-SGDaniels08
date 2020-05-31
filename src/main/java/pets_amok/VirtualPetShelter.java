package pets_amok;

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

    public void tick() {
        for (Map.Entry<String, VirtualPet> entry : shelterInhabitants.entrySet()) {
            VirtualPet tickPet = entry.getValue();
            tickPet.tick();

            // If health reaches 0, pet dies / breaks down
            if (tickPet.getHealth() <= 0) {
                System.out.println("Oh no! " + tickPet.getName() + " has expired. Farewell, " + tickPet.getName() + ".");
                shelterInhabitants.remove(tickPet.getName()); }
        }
    }

    public void initializeShelter() {
        // Organic dogs
        OrganicDog doggo1 = new OrganicDog("Rex", "A friendly-looking mutt", 50, 50, 50, 50, 50, 50);
        OrganicDog doggo2 = new OrganicDog("Rover", "A happy Dalmatian",30, 40, 50, 60, 70,80);
        OrganicDog doggo3 = new OrganicDog("Fido", "A sleepy old hound",10, 15,
                35, 20, 45, 20);
        OrganicDog doggo4 = new OrganicDog("Buggle", "A bouncy little Border Collie", 75,
                40, 35, 70, 30, 50);
        OrganicDog doggo5 = new OrganicDog("Daxeon", "A generally nervous English Shepherd",
                45, 65, 60, 55, 45, 20);
        // Robot dogs
        RoboticDog robDog1 = new RoboticDog("Astro", "He's polished to a blinding sheen!",
                50, 50, 50);
        RoboticDog robDog2 = new RoboticDog("F1d0", "His coat is burnished steel",
                45, 30, 85);
        RoboticDog robDog3 = new RoboticDog("B3nd3r", "Its 40% iron!",
                75, 15, 95);

        // Add to shelter
        shelterInhabitants.put(doggo1.getName(), doggo1);
        shelterInhabitants.put(doggo2.getName(), doggo2);
        shelterInhabitants.put(doggo3.getName(), doggo3);
        shelterInhabitants.put(doggo4.getName(), doggo4);
        shelterInhabitants.put(doggo5.getName(), doggo5);
        shelterInhabitants.put(robDog1.getName(), robDog1);
        shelterInhabitants.put(robDog2.getName(), robDog2);
        shelterInhabitants.put(robDog3.getName(), robDog3);
    }
}
