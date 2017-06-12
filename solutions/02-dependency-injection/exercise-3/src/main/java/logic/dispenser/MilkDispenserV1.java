package logic.dispenser;

import domain.Milk;

public class MilkDispenserV1 implements MilkDispenser {
    public void dispense(Milk milk, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, milk.getName()));
    }
}
