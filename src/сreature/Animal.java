package сreature;

import enums.Type;

public class Animal extends Creature {

    public Animal(Type type, Integer age, Integer hp, Integer mana, Integer legAmount, Integer defaultMovementSpeed, Boolean isDirty, Boolean canFly, Boolean eyesShining) {
        this.type = type;
        this.age = age;
        this.hp = hp;
        this.mana = mana;
        this.legAmount = legAmount;
        this.defaultMovementSpeed = defaultMovementSpeed;
        this.isDirty = isDirty;
        this.canFly = canFly;
        this.eyesShining = eyesShining;
        this.currentMovementSpeed = 0;
    }

    void fly() {
        if (canFly) {
            System.out.println(this.type + " is flying");
        }
        else {
            System.out.println(this.type + " is unable to fly");
        }
    }

}
