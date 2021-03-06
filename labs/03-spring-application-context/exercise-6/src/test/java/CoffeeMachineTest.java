import domain.*;
import logic.dispenser.*;
import logic.machine.CoffeeMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
        List<IngredientPercentage> ingredientPercentageList = new ArrayList<>();

        ingredientPercentageList.add(new IngredientPercentage(coffee, 60));
        ingredientPercentageList.add(new IngredientPercentage(milk, 30));
        ingredientPercentageList.add(new IngredientPercentage(sugar, 10));

        return new Recipe(1, "Latte", ingredientPercentageList);
    }

    @Test
    public void test() throws IOException, URISyntaxException {
        Dispenser dispenserV1 = new DispenserV1();
        CoffeeMachine coffeeMachine = new CoffeeMachine(dispenserV1);
        coffeeMachine.brew(generateTestRecipe());
        String expectedOutput = TestUtils.readFile("brew-latte-output.txt");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testV2() throws IOException, URISyntaxException {
        Dispenser dispenserV2 = new DispenserV2();
        CoffeeMachine coffeeMachine = new CoffeeMachine(dispenserV2);
        coffeeMachine.brew(generateTestRecipe());
        String expectedOutput = TestUtils.readFile("brew-latte-output-v2.txt");
        assertEquals(expectedOutput, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
