package logic.dispenser;

import domain.Ingredient;

public class DispenserV1 implements Dispenser {
    @Override
    public void dispense(Ingredient ingredient, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, ingredient.getName()));
    }
}
