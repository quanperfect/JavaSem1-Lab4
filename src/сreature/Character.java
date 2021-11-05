package сreature;

import enums.Type;

public class Character extends Creature {
    private String name;

    public Character(String name, Integer age, Integer hp, Integer mana, Integer defaultMovementSpeed, Boolean isDirty) {
        this.name = name;
        this.type = Type.TROLL;
        referencedBy = name;
        this.age = age;
        this.hp = hp;
        this.mana = mana;
        this.defaultMovementSpeed = defaultMovementSpeed;
        this.isDirty = isDirty;
        this.currentMovementSpeed = 0;
    }

    @Override
    void shineEyes() {
        System.out.println(this.name + " is unable to shine eyes");
    }
}
