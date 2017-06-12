package logic.machine;

import domain.Recipe;
import logic.dispenser.CoffeeDispenser;
import logic.dispenser.MilkDispenser;
import logic.dispenser.SugarDispenser;

public class CoffeeMachine {
    private CoffeeDispenser coffeeDispenser;
    private MilkDispenser milkDispenser;
    private SugarDispenser sugarDispenser;

    public CoffeeMachine() {
        this.coffeeDispenser = new CoffeeDispenser();
        this.milkDispenser = new MilkDispenser();
        this.sugarDispenser = new SugarDispenser();
    }

    public void brew(Recipe recipe) {
        System.out.println(String.format("Brewing %s...", recipe.getName()));
        coffeeDispenser.dispense(recipe.getCoffee(), recipe.getCoffeePercentage());
        milkDispenser.dispense(recipe.getMilk(), recipe.getMilkPercentage());
        sugarDispenser.dispense(recipe.getSugar(), recipe.getSugarPercentage());
        System.out.println("Done");
    }

    public void brewV2(Recipe recipe) {
    }
}