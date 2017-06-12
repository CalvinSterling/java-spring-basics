package domain;

import java.util.List;

public class Recipe {
    private long id;
    private String name;
    private List<IngredientPercentage> ingredientPercentageList;

    public Recipe(long id, String name, List<IngredientPercentage> ingredientPercentageList) {
        this.id = id;
        this.name = name;
        this.ingredientPercentageList = ingredientPercentageList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<IngredientPercentage> getIngredientPercentageList() {
        return ingredientPercentageList;
    }
}