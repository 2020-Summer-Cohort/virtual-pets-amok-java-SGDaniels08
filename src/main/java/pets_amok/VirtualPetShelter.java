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
    public void playWith(VirtualPet playPet) {
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
        }
    }
}
