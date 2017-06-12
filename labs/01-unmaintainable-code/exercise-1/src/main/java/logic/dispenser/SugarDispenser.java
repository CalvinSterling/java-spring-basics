package logic.dispenser;

import domain.Sugar;

public class SugarDispenser {
    public void dispense(Sugar sugar, int percentage) {
        System.out.println(String.format("Dispensing %s%% of %s", percentage, sugar.getName()));
    }
}
