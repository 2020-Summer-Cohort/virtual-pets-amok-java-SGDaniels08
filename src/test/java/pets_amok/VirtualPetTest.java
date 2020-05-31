package pets_amok;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {

    /*
            OrganicDog Test Methods
     */
    @Test
    public void createOrganicDogObject() {
        OrganicDog testDoggo = new OrganicDog("Rex", "A friendly-looking mutt", 50, 50, 50, 50, 50, 50);

        assertEquals(50, testDoggo.getHappiness());
    }
    @Test
    public void testOrganicDogWalkies() {
        OrganicDog testDoggo = new OrganicDog("Rover", "A happy Dalmatian",30, 40,
                50, 60, 75, 15);
        testDoggo.walkies();

        assertEquals(0, testDoggo.getBathroom());
        assertEquals(65, testDoggo.getHappiness());
    }
    @Test
    public void testOrganicDogTick() {
        OrganicDog testDoggo = new OrganicDog("Fido", "A sleepy old hound",10, 15,
                35, 20, 45, 20);
        testDoggo.tick();

        assertEquals(5, testDoggo.getHappiness());
        assertEquals(40, testDoggo.getHunger());
        assertEquals(30, testDoggo.getThirst());
    }
    @Test
    public void testOrganicDogMessCage() {
        OrganicDog testDoggo = new OrganicDog("Buggle", "A bouncy little Border Collie", 75,
                40, 35, 70, 30, 50);
        assertEquals(30, testDoggo.getBathroom());
        testDoggo.messCage();

        assertEquals(65, testDoggo.getCageFilth());
        assertEquals(0, testDoggo.getBathroom());
    }
    @Test
    public void testOrganicDogCleanCage() {
        OrganicDog testDoggo = new OrganicDog("Daxeon", "A generally nervous English Shepherd",
                45, 65, 60, 55, 50, 20);
        assertEquals(20, testDoggo.getCageFilth());
        testDoggo.cleanCage();

        assertEquals(0, testDoggo.getCageFilth());
    }
    @Test
    public void testOrganicDogEat() {
        OrganicDog testDoggo = new OrganicDog("Samwise", "A chubby, loyal little pup",
                70, 85, 85, 70, 50, 15);
        testDoggo.eat();
        assertEquals(35,testDoggo.getHunger());
    }
    @Test
    public void testOrganicDogDrink() {
        OrganicDog testDoggo = new OrganicDog("Frodo", "He looks like he's carrying an awful burder",
                35, 30, 65, 60, 50, 20);
        assertEquals(60, testDoggo.getThirst());
        testDoggo.drink();
        assertEquals(0, testDoggo.getThirst());
    }

    /*
            RoboticDog Test Methods
     */
    @Test
    public void testRoboticDogTick() {
        RoboticDog testDog = new RoboticDog("Astro", "He's polished to a blinding sheen!",
                50, 50, 50);
        testDog.tick();

        assertEquals(49, testDog.getHappiness());
        assertEquals(55, testDog.getMaintenanceNeeded());
    }
    @Test
    public void testRoboticDogPlay() {
        RoboticDog testDog = new RoboticDog("F1d0", "His coat is burnished steel",
                45, 30, 85);
        testDog.play();

        assertEquals(70, testDog.getHappiness());
    }
    @Test
    public void testRoboticDogMaintain() {
        RoboticDog testDog = new RoboticDog("B3nd3r", "Its 40% iron!",
                75, 15, 95);
        testDog.maintain();

        assertEquals(0, testDog.getMaintenanceNeeded());
    }
    @Test
    public void testRoboticDogWalkies() {
        RoboticDog testDog = new RoboticDog("Pluto", "Goofy-looking",
                90, 90, 15);
        testDog.walkies();

        assertEquals(115, testDog.getHappiness());
    }

    /*
            VirtualPetShelter Test Methods
    */
    @Test
    public void testShelterInitialization() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();

        assertTrue(testShelter.contains("Daxeon"));
    }
    @Test
    public void testWalkAll() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        VirtualPet testDoggo = testShelter.getPet("Daxeon");
        VirtualPet testRobDog = testShelter.getPet("Astro");

        assertEquals(45, testDoggo.getHappiness());
        assertEquals(50, testRobDog.getHappiness());

        testShelter.allPetsWalked();

        assertEquals(80, testDoggo.getHappiness());
        assertEquals(0, ((OrganicPet) testDoggo).getBathroom());
        assertEquals(75, testRobDog.getHappiness());
    }
    @Test
    public void testOilAll() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        VirtualPet testDoggo = testShelter.getPet("Daxeon");
        VirtualPet testRobDog = testShelter.getPet("Astro");

        assertEquals(45, testDoggo.getHappiness());
        assertEquals(50, testRobDog.getHappiness());
        assertEquals(50, ((RoboticPet) testRobDog).getMaintenanceNeeded());

        testShelter.allPetsOiled();

        assertEquals(45, testDoggo.getHappiness());
        assertEquals(60, testRobDog.getHappiness());
        assertEquals(0, ((RoboticPet) testRobDog).getMaintenanceNeeded());
    }
    @Test
    public void testCleanCages() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        VirtualPet testDoggo = testShelter.getPet("Daxeon");
        VirtualPet testRobDog = testShelter.getPet("Astro");

        testShelter.cleanAllCages();

        assertEquals(51, testDoggo.getHappiness());
        assertEquals(0, ((OrganicDog) testDoggo).getCageFilth());
        assertEquals(50, testRobDog.getHappiness());
    }
    @Test
    public void testPlayWith() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        VirtualPet testDoggo = testShelter.getPet("Daxeon");
        VirtualPet testRobDog = testShelter.getPet("Astro");

        testShelter.playWith(testDoggo);
        testShelter.playWith(testRobDog);

        assertEquals(95, testDoggo.getHappiness());
        assertEquals(75, testRobDog.getHappiness());
    }
    @Test
    public void testShelterTick() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        VirtualPet testDoggo = testShelter.getPet("Daxeon");
        VirtualPet testRobDog = testShelter.getPet("Astro");

        testShelter.tick();
    }
    @Test
    public void testOrganicDogTickHealthChange() {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.initializeShelter();
        OrganicDog testTickHealth = new OrganicDog("Test this Mess", "Looks like he might make a mess",
                50, 50, 50, 50, 50, 50);
        OrganicDog testTickHealth2 = new OrganicDog("Test another", "How healthy is he?",
                75, 86, 44, 27, 56, 20);
        testShelter.intakePet(testTickHealth);
        testShelter.intakePet(testTickHealth2);

        testShelter.tick();

        assertEquals(37, testTickHealth.getHealth());
        assertEquals(80, testTickHealth2.getHealth());
    }
}
