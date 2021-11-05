package сreature;

import enums.Type;

public abstract class Creature {
    public Type type;
    public String location;
    public Integer age;
    public Integer hp;
    public Integer mana;
    public Integer defaultMovementSpeed;
    public Integer currentMovementSpeed;
    public Integer legAmount;
    public Boolean isDirty;
    public Boolean canFly;
    public Boolean eyesShining;
    public String referencedBy;


    public Type getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getMana() {
        return mana;
    }

    public Integer getLegAmount() {
        return legAmount;
    }

    public Integer getDefaultMovementSpeed() {
        return defaultMovementSpeed;
    }

    public Integer getCurrentMovementSpeed() {
        return currentMovementSpeed;
    }

    public Boolean getIsDirty() {
        return isDirty;
    }

    public Boolean getCanFly() {
        return canFly;
    }

    public Boolean getEyesShining() {
        return eyesShining;
    }

    void walk() {
        currentMovementSpeed = defaultMovementSpeed;
        System.out.println(referencedBy + " is walking");
    }

    void run() {
        currentMovementSpeed = 2 * defaultMovementSpeed;
        System.out.println(referencedBy + " is running");
    }

    void shineEyes() {
        eyesShining = true;
        System.out.println(referencedBy + " eyes are shining");
    }

    void getDirty() {
        isDirty = true;
        System.out.println(referencedBy + " is now dirty");
    }

    void takeDamage(Integer dmg) {
        hp = hp - dmg;
        System.out.println(referencedBy + " lost " + dmg + " hp");
    }


    void heal(Integer heal) {
        hp = hp + heal;
        System.out.println(referencedBy + " gained " + heal + " hp");
    }

    void castSpell(String spellType, Creature target) {
        if (spellType == "defensive") {
            mana = mana - 1;
            System.out.println(referencedBy + " casted defensive spell and lost " + "1" + " mana");
        } else {
            if (spellType == "offensive") {
                mana = mana - 10;
                System.out.println(referencedBy + " casted offensive spell and lost " + "10" + " mana");
                target.takeDamage(5);
            }
        }
    }

    void attack(Creature target) {
        target.takeDamage(1);
    }

    void die() {
        System.out.println(referencedBy + " is died");
        // I would destroy an object here but Java doesn't want me to do it
    }

}
