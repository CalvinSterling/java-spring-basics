package domain;

public abstract class Ingredient {
    private long id;
    private String name;

    public Ingredient(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
