package сreature;

import enums.Location;
import enums.Type;
import exceptions.AnimalCannotBeTrollTypeException;
import exceptions.DeadException;
import interfaces.AnimalAble;

import java.util.Objects;

public final class Animal extends Creature implements AnimalAble {
    public Animal(Location location, Type type, Integer age, Boolean isDirty, Boolean eyesShining) {
        super(location, type, age, isDirty, eyesShining);
        if (type == Type.TROLL) {
            throw new AnimalCannotBeTrollTypeException("You cannot create animal with Troll type, Trolls are characters");
        }
        this.setReferencedBy(type.getTypeName());
    }

    public void fly() {
        if (getIsDead()) {
            throw new DeadException(getReferencedBy());
        }
        if (getCanFly()) {
            System.out.println(this.getType() + " is flying.");
        }
        else {
            System.out.println(this.getType() + " is unable to fly.");
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Animal otherAnimal = (Animal) otherObject;
        return  (getType().equals(otherAnimal.getType()));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getType());
    }

    @Override
    public String toString() {
        return  "[Type: " + getType().getTypeName() + "; Age: " + getAge() + "; HP: " + getHp() + "; Mana: " + getMana() + "; isDirty: " + getIsDirty() + "; isDirty: " + getIsDirty() + "]";
    }

}
