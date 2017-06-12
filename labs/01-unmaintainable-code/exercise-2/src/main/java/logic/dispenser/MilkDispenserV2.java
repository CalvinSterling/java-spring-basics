package logic.dispenser;

import domain.Milk;

public class MilkDispenserV2 {
    public void dispense(Milk milk, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, milk.getName()));
        System.out.println("Adding Magic Flavor");
    }
}
