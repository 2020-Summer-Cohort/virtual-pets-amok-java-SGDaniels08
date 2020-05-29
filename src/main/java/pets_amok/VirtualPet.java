package pets_amok;

public abstract class VirtualPet {

    private String name;
    private String description;
    protected int happiness;
    protected int health;

    public VirtualPet (String name, String description, int happiness, int health) {
        this.name = name;
        this.description = description;
        this.happiness = happiness;
        this.health = health;
    }

    public abstract void tick();
    public abstract void play();

    // Getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getHappiness() {
        return happiness;
    }
    public int getHealth() {
        return health;
    }
}
