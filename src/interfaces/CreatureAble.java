package interfaces;

import enums.Location;
import enums.SpellType;
import exceptions.AlreadyDeadException;
import exceptions.AnimalsEyesNotShiningWhenInCombatException;
import exceptions.MissingSpellTypeException;
import exceptions.SuperUltimateSpellFromAnimalException;
import сreature.Creature;

public interface CreatureAble {
    void shineEyes();
    void stopShiningEyes();
    void getDirty();
    void castSpell(SpellType spellType, CreatureAble interfaceTarget) throws MissingSpellTypeException, AlreadyDeadException, SuperUltimateSpellFromAnimalException, AnimalsEyesNotShiningWhenInCombatException;
    void attack(CreatureAble interfaceTarget) throws AlreadyDeadException, AnimalsEyesNotShiningWhenInCombatException;
    void move(Location location);
    void checkMyStats();
    void checkStats(CreatureAble interfaceTarget);
    void getRevived();
}
