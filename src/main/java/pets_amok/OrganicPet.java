package pets_amok;

public abstract class OrganicPet extends VirtualPet {

    protected int hunger;
    protected int thirst;
    protected int bathroom;

    public OrganicPet(String name, String description, int happiness, int health, int hunger,
                      int thirst, int bathroom) {
        super(name, description, happiness, health);

        this.hunger = hunger;
        this.thirst = thirst;
        this.bathroom = bathroom;
    }

    // Subclass methods
    public abstract void eat();
    public abstract void drink();

    // Getters
    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getBathroom() {
        return bathroom;
    }
}
