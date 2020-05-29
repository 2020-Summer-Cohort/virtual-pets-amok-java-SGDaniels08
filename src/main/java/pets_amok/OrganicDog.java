package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {

    private int cageFilth;

    public OrganicDog(String name, String description, int happiness, int health, int hunger,
                      int thirst, int bathroom, int cageFilth) {
        super(name, description, happiness, health, hunger, thirst, bathroom);

        this.cageFilth = cageFilth;
    }

    // Subclass methods - OrganicDog
    public void messCage() {
        cageFilth += bathroom/2;
        bathroom = 0;
    }
    public void cleanCage() {
        cageFilth = 0;
    }

    // Override methods -- Dog interface
    @Override
    public void walkies() {
        happiness += 35;
        bathroom -= 50;
    }
    // Override methods -- OrganicPet class
    @Override
    public void eat() {
        hunger -= 50;
    }
    @Override
    public void drink() {
        thirst = 0;
    }
    // Override methods -- VirtualPet class
    @Override
    public void tick() {
        happiness -= 5;
        hunger += 5;
        thirst += 10;

        // If bathroom > 10, more unhappy, more chance to messCage()
    }
    @Override
    public void play() {
        happiness += 50;
    }

    // Getter
    public int getCageFilth() {
        return cageFilth;
    }
}
