package enums;

public enum SpellType {
    OFFENSIVE("Offensive",10,5,"Air"),
    DEFENSIVE("Defensive",50,1,"Null"),
    ULTIMATE("Ultimate",50,20,"Poison"),
    SUPERULTIMATE("SuperUltimate",100,50,"Piercing");

    private String spellTypeName = "null";
    private Integer damage = 0;
    private Integer manaRequired = 0;
    private String damageType = "null"; // can be further turned into enum

    SpellType(String spellTypeName, Integer damage, Integer manaRequired, String damageType) {
        this.spellTypeName = spellTypeName;
        this.damage = damage;
        this.manaRequired = manaRequired;
        this.damageType = damageType;
    }

    public String getSpellTypeName() {
        return spellTypeName;
    }
    public Integer getDamage() { return damage; }
    public Integer getManaRequired() { return manaRequired; }
    public String getDamageType() { return damageType; }

}
