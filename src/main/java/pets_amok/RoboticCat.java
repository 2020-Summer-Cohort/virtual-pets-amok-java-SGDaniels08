package pets_amok;

public class RoboticCat extends RoboticPet implements Cat {

    public RoboticCat(String name, String description, int happiness, int health, int maintenanceNeeded) {
        super(name, description, happiness, health, maintenanceNeeded);
    }

    // Cat Interface -- Override Methods
    @Override
    public void useLitterbox() {
        System.out.println(getName() + " stands in the litterbox, buzzing contentedly (but fruitlessly)");
    }
    // RoboticPet Class -- Override Methods
    @Override
    public void maintain() {
        maintenanceNeeded = 0;
    }
    // VirtualPet Class -- Override Methods
    @Override
    public void tick() {
        maintenanceNeeded += 5;
    }
    @Override
    public void play() {
        happiness += 25;
    }
}
