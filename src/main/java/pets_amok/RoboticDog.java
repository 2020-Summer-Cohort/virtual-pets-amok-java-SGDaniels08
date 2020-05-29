package pets_amok;

public class RoboticDog extends RoboticPet implements Dog {
    public RoboticDog(String name, String description, int happiness, int health, int maintenanceNeeded) {
        super(name, description, happiness, health, maintenanceNeeded);
    }

    // Override methods -- Dog interface
    @Override
    public void walkies() {
        happiness += 25;
    }
    // Override methods -- RoboticPet class
    @Override
    public void maintain() {
        maintenanceNeeded = 0;
        happiness += 10;
    }
    // Override methods -- VirtualPet class
    @Override
    public void tick() {
        happiness -= 1;
        maintenanceNeeded += 5;
    }
    @Override
    public void play() {
        happiness += 25;
    }
}
