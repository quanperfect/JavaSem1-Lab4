package world;

import сreature.Creature;

public class Soot {
    public Boolean inAir = true;
    public Integer amount = 20;
    public Integer speed = 1;

    Soot(Boolean inAir, Integer amount, Integer speed)
    {
        this.inAir = inAir;
        this.amount = amount;
        this.speed = speed;
    }

    public Boolean getInAir() {
        return inAir;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getSpeed() {
        return speed;
    }

    void hitCreature(Creature target) {
        target.isDirty = true;
        System.out.println(target.referencedBy + " got hit by soot and now is dirty");
    }
}
