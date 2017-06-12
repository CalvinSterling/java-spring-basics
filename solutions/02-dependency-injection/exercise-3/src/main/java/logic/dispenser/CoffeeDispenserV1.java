package logic.dispenser;

import domain.Coffee;

public class CoffeeDispenserV1 implements CoffeeDispenser {
    public void dispense(Coffee coffee, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, coffee.getName()));
    }
}
