package сreature;

import enums.Location;
import enums.Type;
import exceptions.DeadException;
import interfaces.CharacterAble;
import interfaces.interactionAble;
import world.Swamp;

import java.util.Objects;

import static world.Swamp.getSwamp;

public final class Character extends Creature implements CharacterAble {
    private String name;
    interactionAble Swamp = getSwamp();


    public Character(Location location, String name, Integer age, Boolean isDirty) {
        super(location, Type.TROLL, age, isDirty, false);
        this.name = name;
        this.setReferencedBy(name);
    }

    public String getName() {
        return name;
    }

    public void releaseBoogersFish(Integer amount) {
        if (getIsDead()) {
            throw new DeadException(getReferencedBy());
        }
        Swamp.releaseBoogersFish(amount);
    }

    public void splashWater() {
        if (getIsDead()) {
            throw new DeadException(getReferencedBy());
        }
        Swamp.splashWater();
    }


    @Override
    public void shineEyes() {
        if (getIsDead()) {
            throw new DeadException(getReferencedBy());
        }
        System.out.println(this.name + " is unable to shine eyes.");
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Character otherCharacter = (Character) otherObject;
        return  (getName().equals(otherCharacter.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return  "[Name: " + getName() + "; Type: " + getType().getTypeName() + "; Age: " + getAge() + "; HP: " + getHp() + "; Mana: " + getMana() + "; isDirty: " + getIsDirty() + "]";
    }
}
