package logic.machine;

import domain.Recipe;
import logic.dispenser.*;

public class CoffeeMachine {
    private Dispenser dispenser;

    public CoffeeMachine(Dispenser dispenser) {
        this.dispenser = dispenser;
    }

    public void brew(Recipe recipe) {
        System.out.println(String.format("Brewing %s...", recipe.getName()));
        dispenser.dispense(recipe.getCoffee(), recipe.getCoffeePercentage());
        dispenser.dispense(recipe.getMilk(), recipe.getMilkPercentage());
        dispenser.dispense(recipe.getSugar(), recipe.getSugarPercentage());
        System.out.println("Done");
    }
}