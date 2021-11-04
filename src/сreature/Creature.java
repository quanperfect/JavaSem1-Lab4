package сreature;

public abstract class Creature {
    public String type;
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
    

    public String getType() {
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

    void Walk() {
        currentMovementSpeed = defaultMovementSpeed;
        System.out.println(referencedBy + " is walking");
    }

    void Run() {
        currentMovementSpeed = 2*defaultMovementSpeed;
        System.out.println(referencedBy + " is running");
    }

    void ShineEyes() {
        eyesShining = true;
        System.out.println(referencedBy + " eyes are shining");
    }

    void GetDirty() {
        isDirty = true;
        System.out.println(referencedBy + " is now dirty");
    }

    void TakeDamage(Integer dmg) {
        hp = hp - dmg;
        System.out.println(referencedBy + " lost " + dmg + " hp");
    }

    void Heal(Integer heal) {
        hp = hp + heal;
        System.out.println(referencedBy + " gained " + heal + " hp");
    }

    void CastSpell(String spellType) {
        if (spellType == "defensive")
        {
            mana = mana - 1;
            System.out.println(referencedBy + " casted defensive spell and lost " + "1" + " mana");
        }
        else {
            if (spellType == "offensive") {
                mana = mana - 10;
                System.out.println(referencedBy + " casted offensive spell and lost " + "10" + " mana");
            }
        }
    }




}
