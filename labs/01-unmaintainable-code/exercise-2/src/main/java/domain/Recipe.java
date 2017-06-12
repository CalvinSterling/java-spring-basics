package domain;

public class Recipe {
    private long id;
    private String name;

    private Coffee coffee;
    private Milk milk;
    private Sugar sugar;

    private int coffeePercentage;
    private int milkPercentage;
    private int sugarPercentage;

    public Recipe(long id, String name, Coffee coffee, Milk milk, Sugar sugar, int coffeePercentage, int milkPercentage, int sugarPercentage) {
        this.id = id;
        this.name = name;
        this.coffee = coffee;
        this.milk = milk;
        this.sugar = sugar;
        this.coffeePercentage = coffeePercentage;
        this.milkPercentage = milkPercentage;
        this.sugarPercentage = sugarPercentage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Milk getMilk() {
        return milk;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public int getCoffeePercentage() {
        return coffeePercentage;
    }

    public int getMilkPercentage() {
        return milkPercentage;
    }

    public int getSugarPercentage() {
        return sugarPercentage;
    }
}
