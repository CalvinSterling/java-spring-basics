package logic.dispenser;

import domain.IngredientPercentage;

public class DispenserV2 implements Dispenser {
    @Override
    public void dispense(IngredientPercentage ingredientPercentage) {
        System.out.println(String.format("Dispensing %s%% of %s", ingredientPercentage.getPercentage(), ingredientPercentage.getIngredient().getName()));
        System.out.println("Adding Magic Flavor");
    }
}
