import domain.Coffee;
import domain.Milk;
import domain.Recipe;
import domain.Sugar;
import logic.dispenser.*;
import logic.machine.CoffeeMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class CoffeeMachineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    private Recipe generateTestRecipe() {
        Coffee coffee = new Coffee(1, "Douwe Egberts");
        Milk milk = new Milk(1, "Fresh Milk");
        Sugar sugar = new Sugar(1, "White Sugar");
        return new Recipe(1, "Latte", coffee, milk, sugar, 60, 30, 10);
    }

    @Test
    public void test() throws IOException, URISyntaxException {
        CoffeeDispenser coffeeDispenserV1 = new CoffeeDispenserV1();
        MilkDispenser milkDispenserV1 = new MilkDispenserV1();
        SugarDispenser sugarDispenserV1 = new SugarDispenserV1();
        CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeDispenserV1, milkDispenserV1, sugarDispenserV1);
        coffeeMachine.brew(generateTestRecipe());
        String expectedOutput = TestUtils.readFile("brew-latte-output.txt");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testV2() throws IOException, URISyntaxException {
        CoffeeDispenser coffeeDispenserV2 = new CoffeeDispenserV2();
        MilkDispenser milkDispenserV2 = new MilkDispenserV2();
        SugarDispenser sugarDispenserV2 = new SugarDispenserV2();
        CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeDispenserV2, milkDispenserV2, sugarDispenserV2);
        coffeeMachine.brew(generateTestRecipe());
        String expectedOutput = TestUtils.readFile("brew-latte-output-v2.txt");
        assertEquals(expectedOutput, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
