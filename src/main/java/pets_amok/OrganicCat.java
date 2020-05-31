package pets_amok;

import java.util.Random;

public class OrganicCat extends OrganicPet implements Cat {

    public OrganicCat(String name, String description, int happiness, int health, int hunger,
                      int thirst, int bathroom) {
        super(name, description, happiness, health, hunger, thirst, bathroom);
    }
    // Cat Interface -- Override Methods
    @Override
    public void useLitterbox() {
        bathroom = 0;
    }
    // OrganicPet Class -- Override Methods
    @Override
    public void eat() {
        hunger -= 50;
        happiness += 25;
    }
    @Override
    public void drink() {
        thirst = 0;
    }
    // VirtualPet Class -- Override Methods
    @Override
    public void tick() {
        Random randomNumber = new Random();
        happiness -= 1;
        hunger += 10;
        thirst += 5;
        bathroom += 10;

        // Adjust health proportional to other fields
        health -= ((hunger/10) + (thirst/10) + (bathroom/10));
        health += (happiness/10);

        // Use Litterbox
        if (randomNumber.nextInt(75) < bathroom ) { useLitterbox(); }
    }
    @Override
    public void play() {
        happiness += 50;
    }
}
