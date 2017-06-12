package domain;

public class IngredientPercentage {
    private Ingredient ingredient;
    private int percentage;

    public IngredientPercentage(Ingredient ingredient, int percentage) {
        this.ingredient = ingredient;
        this.percentage = percentage;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getPercentage() {
        return percentage;
    }
}
