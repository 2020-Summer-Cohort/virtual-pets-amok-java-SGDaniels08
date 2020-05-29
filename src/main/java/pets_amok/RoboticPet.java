package pets_amok;

public abstract class RoboticPet extends VirtualPet {

    protected int maintenanceNeeded;

    public RoboticPet(String name, String description, int happiness, int health, int maintenanceNeeded) {

        super(name, description, happiness, health);

        this.maintenanceNeeded = maintenanceNeeded;
    }

    // oiling method
    public abstract void maintain();

    // Getters
    public int getMaintenanceNeeded() {
        return maintenanceNeeded;
    }
}
