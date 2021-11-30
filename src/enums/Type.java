package enums;

public enum Type {
    TROLL("Troll", 0, 10, 200, 200, false),
    FROG("Frog", 0, 2, 25, 10, false),
    DRAGONFLY("Dragonfly", 0, 1, 20, 5, true),
    DBSPIDER("Dbspider", 7, 1, 15, 1, false),
    BOOGER("Booger", 25, 25, 200, 200, true);

    private String typeName = "null";
    private Integer strength = 0;
    private Integer intelligence = 0;
    private Integer maxHP = 0;
    private Integer maxMana = 0;
    private Boolean canFly = false;

    Type(String typeName, Integer strength, Integer intelligence, Integer maxHP, Integer maxMana, Boolean canFly) {
        this.typeName = typeName;
        this.strength = strength;
        this.intelligence = intelligence;
        this.maxHP = maxHP;
        this.maxMana = maxMana;
        this.canFly = canFly;
    }


    public String getTypeName() {
        return typeName;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getMaxMana() {
        return maxMana;
    }

    public Boolean getCanFly() {
        return canFly;
    }

}
