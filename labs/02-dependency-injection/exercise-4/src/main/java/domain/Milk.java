package domain;

public class Milk {
    private long id;
    private String name;

    public Milk(long id, String name) {
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
