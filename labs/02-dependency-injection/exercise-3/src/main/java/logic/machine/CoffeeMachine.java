package logic.machine;

import domain.Recipe;
import logic.dispenser.*;

public class CoffeeMachine {
    private CoffeeDispenser coffeeDispenser;
    private MilkDispenser milkDispenser;
    private SugarDispenser sugarDispenser;

    public CoffeeMachine(CoffeeDispenser coffeeDispenser, MilkDispenser milkDispenser, SugarDispenser sugarDispenser) {
    }

    public void brew(Recipe recipe) {
        System.out.println(String.format("Brewing %s...", recipe.getName()));
        coffeeDispenser.dispense(recipe.getCoffee(), recipe.getCoffeePercentage());
        milkDispenser.dispense(recipe.getMilk(), recipe.getMilkPercentage());
        sugarDispenser.dispense(recipe.getSugar(), recipe.getSugarPercentage());
        System.out.println("Done");
    }
}