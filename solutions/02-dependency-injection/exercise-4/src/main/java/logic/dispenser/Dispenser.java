package logic.dispenser;

import domain.Ingredient;

public interface Dispenser {
    void dispense(Ingredient ingredient, int percentage);
}
