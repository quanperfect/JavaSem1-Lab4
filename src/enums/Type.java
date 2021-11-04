package enums;

public enum Type {
    TROLL ("troll"),
    FROG ("frog"),
    DRAGONFLY ("dragonfly");

    private String title;

    Type(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
