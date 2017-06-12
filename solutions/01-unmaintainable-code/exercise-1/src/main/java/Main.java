import domain.Coffee;
import domain.Milk;
import domain.Recipe;
import domain.Sugar;
import logic.dispenser.CoffeeDispenser;
import logic.dispenser.MilkDispenser;
import logic.dispenser.SugarDispenser;
import logic.machine.CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Coffee coffee = new Coffee(1, "Douwe Egberts");
        Milk milk = new Milk(1, "Fresh Milk");
        Sugar sugar = new Sugar(1, "White Sugar");
        Recipe recipe = new Recipe(1, "Latte", coffee, milk, sugar, 60, 30, 10);

        coffeeMachine.brew(recipe);
    }
}
