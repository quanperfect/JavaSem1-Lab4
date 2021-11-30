package сreature;

import enums.Location;
import enums.SpellType;
import enums.Type;
import exceptions.*;
import interfaces.CreatureAble;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements CreatureAble {
    private Type type;
//    private String location;
    private Integer age;
    private Integer hp;
    private Integer mana;
//    private Integer defaultMovementSpeed;
//    private Integer currentMovementSpeed;
//    private Integer legAmount;
    private Boolean isDirty;
    private Boolean eyesShining;
    private String referencedBy;
    private Boolean canFly;
    private Environment environment;
    private Boolean isDead = false;

    public Creature(Location location, Type type, Integer age, Boolean isDirty, Boolean eyesShining) {
        this.type = type;
        this.age = age;
        this.hp = type.getMaxHP();
        this.mana = type.getMaxMana();
        this.isDirty = isDirty;

        this.canFly = type.getCanFly();
        this.eyesShining = eyesShining;
        Environment Environment = new Environment(location);
        this.environment = Environment;
    }

    public Type getType() {
        return type;
    }

//    public String getLocation() {
//        return location;
//    }
    
    public String getReferencedBy() {
        return referencedBy;
    }

    public void setReferencedBy(String referencedBy) {
        this.referencedBy = referencedBy;
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

    public Environment getEnvironment() {
        return environment;
    }

//    public Integer getLegAmount() {
//        return legAmount;
//    }
//
//    public Integer getDefaultMovementSpeed() {
//        return defaultMovementSpeed;
//    }
//
//    public Integer getCurrentMovementSpeed() {
//        return currentMovementSpeed;
//    }

    public Boolean getIsDirty() {
        return isDirty;
    }

    public Boolean getEyesShining() {
        return eyesShining;
    }

    //Just like static members, a static nested class does not have access to the instance variables and methods of the outer class.
    public class Environment {
        private Location location = Location.SWAMP; // default spawn point

        public Environment(Location location) {
            this.location = location;
        }

        public void checkLocation() {
            if (getLocation().getSafe()) {
                Creature.this.heal(Creature.this.getType().getMaxHP());
                Creature.this.mana = Creature.this.getType().getMaxMana();
            }

        }

        public Location getLocation() {
            return location;
        }

        public void move(Location location) {
            this.location = location;
            checkLocation();
            System.out.println(referencedBy + " moved to " + location.getLocationName() + ".");
        }
    }

    public void shineEyes() {
        if (isDead) {
            throw new DeadException(referencedBy);
        }
        eyesShining = true;
        System.out.println(referencedBy + " eyes are shining.");
    }

    public void stopShiningEyes() {
        if (isDead) {
            throw new DeadException(referencedBy);
        }
        eyesShining = false;
        System.out.println(referencedBy + " eyes are no longer shining.");
    }

    public void getDirty() {
        isDirty = true;
        System.out.println(referencedBy + " is now dirty.");
    }

    public Boolean getCanFly() {
        return canFly;
    }

    public void takeDamage(Integer dmg) throws AlreadyDeadException {
        if (dmg < 0) {
            throw new NegativeDamageException("EXCEPTION: Cannot inflict negative damage, that would heal target!");
        }
        else {
            if (hp <= 0)
                throw new AlreadyDeadException(this.type.getTypeName() + " is already dead");
            else {
                if (hp - dmg > 0) {
                    hp = hp - dmg;
                    System.out.println(referencedBy + " lost " + dmg + " HP. Current HP: " + hp + ".");
                }
                else {
                    System.out.println(referencedBy + " lost " + hp + " HP. Current HP: " + 0 + ".");
                    hp = 0;
                    this.die();
                }
            }
        }
    }


    public void heal(Integer heal) {
        if (hp + heal > getType().getMaxHP()) {
            hp = getType().getMaxHP();
            System.out.println(referencedBy + " was fully healed. Current HP: " + hp + ".");
        }
        else {
            hp = hp + heal;
            System.out.println(referencedBy + " gained " + heal + " HP. Current HP: " + hp + ".");

        }
    }

    public void castSpell(SpellType spellType, CreatureAble interfaceTarget) throws MissingSpellTypeException, AlreadyDeadException, SuperUltimateSpellFromAnimalException, AnimalsEyesNotShiningWhenInCombatException {
        Creature target = (Creature) interfaceTarget;
        if (isDead) {
            throw new DeadException(referencedBy);
        }
        if (mana - spellType.getManaRequired() < 0) {
            throw new NoManaException(referencedBy);
        }
        mana = mana - spellType.getManaRequired();
        //exceptions
        if ((spellType == SpellType.SUPERULTIMATE) && (this.getType() != Type.TROLL)) {
            throw new SuperUltimateSpellFromAnimalException("EXCEPTION: Only Trolls can use SuperUltimate spell!");
        }
        if ((this.getType() != Type.TROLL) && !(this.getEyesShining())) {
            throw new AnimalsEyesNotShiningWhenInCombatException("EXCEPTION: Animals can be in combat only when their eyes are shining!");
        }

        // spell processing
        if ((spellType == SpellType.OFFENSIVE) || (spellType == SpellType.ULTIMATE) || (spellType == SpellType.SUPERULTIMATE)) {
            System.out.println(referencedBy + " casted " + spellType.getSpellTypeName() + " spell for " + spellType.getManaRequired() + " mana, successfully dealed " + spellType.getDamage() + " damage with " + spellType.getDamageType() + " to " + target.referencedBy + ".");
            target.takeDamage(spellType.getDamage());
        }
        else {
            if (spellType == SpellType.DEFENSIVE) {
                System.out.println(referencedBy + " casted " + spellType.getSpellTypeName() + " spell for " + spellType.getManaRequired() + " mana, successfully healed " + spellType.getDamage() + " HP to " + target.referencedBy + ".");
                target.heal(spellType.getDamage());
            }
            else {
                throw new MissingSpellTypeException("EXCEPTION: There is no such type of spell!");
            }
        }
    }

    public void attack(CreatureAble interfaceTarget) throws AlreadyDeadException, AnimalsEyesNotShiningWhenInCombatException {
        if (isDead) {
            throw new DeadException(referencedBy);
        }
        Creature target = (Creature) interfaceTarget;
        if ((this.getType() != Type.TROLL) && !(eyesShining)) {
            throw new AnimalsEyesNotShiningWhenInCombatException("EXCEPTION: Animals can be in combat only when their eyes are shining!");
        }
        target.takeDamage(3);
    }

    public void die() {
        System.out.println(referencedBy + " died.");
        isDead = true;
        // I would destroy an object here but Java doesn't want me to do it
    }

    public void move(Location location) {
        getEnvironment().move(location);
    }

    public void checkMyStats() {
        System.out.println("-------------------------");
        System.out.println(getReferencedBy() + " checks own stats: \n" + "- Type: " + getType().getTypeName() + "\n- HP: " + getHp() + "\n- Mana: " + getMana()
                + "\n- Max HP: " + getType().getMaxHP() + "\n- Max Mana: " + getType().getMaxMana() + "\n- Eyes Shining: " + getEyesShining()
                + "\n- Location: " + getEnvironment().getLocation().getLocationName());
        System.out.println("-------------------------");
    }

    public void checkStats(CreatureAble interfaceTarget) {
        Creature target = (Creature) interfaceTarget;
        System.out.println("-------------------------");
        System.out.println(getReferencedBy() + "checks " + target.getReferencedBy() + " stats: \n" + "- Type: " + target.getType().getTypeName() + "\n- HP: " + target.getHp() + "\n- Mana: " + target.getMana()
               + "\n- Max HP: " + target.getType().getMaxHP() + "\n- Max Mana: " + target.getType().getMaxMana() + "\n- Eyes Shining: " + target.getEyesShining()
                + "\n- Location: " + target.getEnvironment().getLocation().getLocationName());
        System.out.println("-------------------------");
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void getRevived() {
        if (isDead) {
            isDead = false;
            hp = 1;
            System.out.println(referencedBy + " has been revived. Current HP: " + hp + ".");
        }
    }

}
