package cit360junit;

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeroTest extends TestCase {

    private Hero testHero;

    @Override
    protected void setUp() throws Exception {
        System.out.println("Executing setUp()");
        testHero = new Hero("Warrior", 100, 10);
    }

    //AssertNotNull test
    public void testHeroCreation() {
        System.out.println("HeroTest: executing HeroCreation()");
        assertNotNull(testHero);
    }

    //AssertEquals Test
    public void testTakeDamage() {
        System.out.println("HeroTest: executing TakeDamage()");
        int damage = 15;
        int newHealth = 85;

        testHero.takeDamage(damage);
        int actualHealth = testHero.getHealth();

        assertEquals(newHealth, actualHealth);
    }

    //AssertArrayEquals test
    public void testUseItems() {
        System.out.println("HeroTest: executing UseItems()");
        String item = "Potion";
        String[] newItems = new String[]{"Potion", "Bread", null};

        testHero.useItem(item);
        String[] actualItems = testHero.getItems();

        assertArrayEquals(newItems, actualItems);
    }

    //AssetFalse test
    //AssertTrue test
    public void testGetDisease() {
        System.out.println("HeroTest: executing GetDisease()");
        testHero.takeDamage(85);
        testHero.getDisease();

        assertTrue(testHero.isDisease());

        testHero.useItem("Potion");

        assertFalse(testHero.isDisease());
    }

    //AssertNotSame test
    public void testDiseaseEffect(){
        System.out.println("HeroTest: executing DiseaseEffect()");
        testHero.takeDamage(85);
        testHero.getDisease();

        assertNotSame(10, testHero.getStrength());
    }

    //AssertThat
    public void testItemAdd() {
        testHero.useItem("Potion");
        testHero.useItem("Potion");
        testHero.useItem("Bread");

        testHero.addItem("Bread");

        assertThat(Arrays.asList(testHero.getItems()), hasItems("Bread"));
    }

    //AssertSame test
    public void testHeal(){
        System.out.println("HeroTest: executing Heal()");
        testHero.takeDamage(45);


        testHero.useItem("Bread");
        assertSame(75, testHero.getHealth());
        testHero.addItem("Bread");

        testHero.useItem("Bread");
        assertSame(95, testHero.getHealth());
        testHero.addItem("Bread");

        testHero.useItem("Bread");
        assertSame(100, testHero.getHealth());
    }

    //AssertNull test
    @Override
    protected void tearDown() throws Exception {
        System.out.println("Executing tearDown()");
        testHero = null;
        assertNull(testHero);
    }
}