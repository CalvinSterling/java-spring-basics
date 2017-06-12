package logic.machine;

import domain.Recipe;
import logic.dispenser.*;

public class CoffeeMachine {
    private CoffeeDispenser coffeeDispenser;
    private CoffeeDispenserV2 coffeeDispenserV2;
    private MilkDispenser milkDispenser;
    private MilkDispenserV2 milkDispenserV2;
    private SugarDispenser sugarDispenser;
    private SugarDispenserV2 sugarDispenserV2;

    public CoffeeMachine() {
        this.coffeeDispenser = new CoffeeDispenser();
        this.coffeeDispenserV2 = new CoffeeDispenserV2();
        this.milkDispenser = new MilkDispenser();
        this.milkDispenserV2 = new MilkDispenserV2();
        this.sugarDispenser = new SugarDispenser();
        this.sugarDispenserV2 = new SugarDispenserV2();
    }

    public void brew(Recipe recipe) {
        System.out.println(String.format("Brewing %s...", recipe.getName()));
        coffeeDispenser.dispense(recipe.getCoffee(), recipe.getCoffeePercentage());
        milkDispenser.dispense(recipe.getMilk(), recipe.getMilkPercentage());
        sugarDispenser.dispense(recipe.getSugar(), recipe.getSugarPercentage());
        System.out.println("Done");
    }

    public void brewV2(Recipe recipe) {
        System.out.println(String.format("Brewing %s...", recipe.getName()));
        coffeeDispenserV2.dispense(recipe.getCoffee(), recipe.getCoffeePercentage());
        milkDispenserV2.dispense(recipe.getMilk(), recipe.getMilkPercentage());
        sugarDispenserV2.dispense(recipe.getSugar(), recipe.getSugarPercentage());
        System.out.println("Done");
    }
}