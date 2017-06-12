package logic.dispenser;

import domain.Sugar;

public class SugarDispenserV3 {
    public void dispense(Sugar sugar, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, sugar.getName()));
        System.out.println("Adding Extra Magic Flavor");
    }
}

