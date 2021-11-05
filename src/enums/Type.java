package enums;

public enum Type {
    TROLL("troll", 0, 10, 100, 100, false),
    FROG("frog", 0, 2, 10, 10, false),
    DRAGONFLY("dragonfly", 0, 1, 5, 5, true),
    DBSPIDER("dbspider", 7, 1, 1, 1, false),
    BOOGER("booger", 25, 25, 200, 200, true);

    public String typeName = "null";
    public Integer strength = 0;
    public Integer intelligence = 0;
    public Integer maxHP = 0;
    public Integer maxMana = 0;
    public Boolean canFly = false;

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
