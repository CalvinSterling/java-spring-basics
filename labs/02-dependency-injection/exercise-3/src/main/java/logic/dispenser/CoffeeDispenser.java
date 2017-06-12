package logic.dispenser;

import domain.Coffee;

public interface CoffeeDispenser {
    void dispense(Coffee coffee, int percentage);
}
