package logic.dispenser;

import domain.Coffee;

public class CoffeeDispenserV2 {
    public void dispense(Coffee coffee, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, coffee.getName()));
        System.out.println("Adding Magic Flavor");
    }
}
