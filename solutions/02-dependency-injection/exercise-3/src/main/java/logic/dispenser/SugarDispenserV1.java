package logic.dispenser;

import domain.Sugar;

public class SugarDispenserV1 implements SugarDispenser {
    public void dispense(Sugar sugar, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, sugar.getName()));
    }
}
