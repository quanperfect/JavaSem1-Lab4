import enums.Location;
import enums.SpellType;
import enums.Type;
import exceptions.AlreadyDeadException;
import exceptions.AnimalsEyesNotShiningWhenInCombatException;
import exceptions.MissingSpellTypeException;
import exceptions.SuperUltimateSpellFromAnimalException;
import interfaces.AnimalAble;
import interfaces.CharacterAble;
import interfaces.God;
import world.Soot;
import world.Swamp;
import world.Weather;
import сreature.Animal;
import сreature.Character;
import сreature.Creature;

import javax.crypto.Mac;

public class Main {
    public static void main(String[] args) throws AlreadyDeadException, MissingSpellTypeException, SuperUltimateSpellFromAnimalException, AnimalsEyesNotShiningWhenInCombatException {
        final AnimalAble GlyphidGrunt = new Animal(Location.SWAMP, Type.DBSPIDER, 1, true, false);
        final AnimalAble Mactera = new Animal(Location.SWAMP, Type.DRAGONFLY, 2, true, false);
        final AnimalAble Wise = new Animal(Location.SWAMP, Type.FROG, 3, true, false);
        final AnimalAble Nasal = new Animal(Location.SWAMP, Type.BOOGER, 4, true, false);

        final CharacterAble MumuMama = new Character(Location.SWAMP, "Mumu-Mama", 50,  false);
        CharacterAble Mumla = new Character(Location.SWAMP, "Mumla", 10, false);
        final CharacterAble MumuPapa = new Character(Location.SWAMP, "Mumu-Papa", 50, false);

        Weather Weather = world.Weather.getWeather();
        Swamp Swamp = world.Swamp.getSwamp();
        Soot Soot1 = new Soot(true, 50, 5);

        Weather.checkStats();
        Weather.getSun().shine();
        Weather.getSun().heat(10);
        Weather.setWindSpeed(10);
        Weather.checkStats();

        // prepare animals for combat:
        GlyphidGrunt.shineEyes();
        Mactera.shineEyes();
        Wise.shineEyes();
        Nasal.shineEyes();
        //
        MumuMama.checkMyStats();
        MumuMama.attack(GlyphidGrunt);
        MumuMama.castSpell(SpellType.ULTIMATE, GlyphidGrunt);
        MumuMama.castSpell(SpellType.SUPERULTIMATE, Nasal);
        Nasal.castSpell(SpellType.ULTIMATE, MumuMama);
        Nasal.castSpell(SpellType.ULTIMATE, MumuMama);
        Mactera.attack(MumuMama);
        Wise.castSpell(SpellType.DEFENSIVE, Nasal);
        MumuMama.castSpell(SpellType.DEFENSIVE,MumuMama);
        MumuMama.move(Location.HOUSE);
        MumuMama.checkMyStats();

        MumuMama.move(Location.SWAMP);
        Nasal.castSpell(SpellType.ULTIMATE, MumuMama);
        Nasal.castSpell(SpellType.ULTIMATE, MumuMama);
        Nasal.castSpell(SpellType.ULTIMATE, MumuPapa);
        Nasal.castSpell(SpellType.ULTIMATE, MumuPapa);
        Mactera.attack(MumuMama);
        Mactera.attack(MumuPapa);
        MumuPapa.castSpell(SpellType.SUPERULTIMATE,Nasal);
        MumuPapa.castSpell(SpellType.SUPERULTIMATE,Nasal);

        // anonymous class
        God man = new God() {
            @Override
            public void bless() {
                System.out.println("GOD: Everyone was blessed!");
                revive();
            }
            public void revive() {
                GlyphidGrunt.getRevived();
                Nasal.getRevived();
            }
        };

        man.bless();
        Mactera.fly();
        GlyphidGrunt.fly();

        MumuMama.splashWater();
        Swamp.getDirtier();
        Swamp.drain(100);
        MumuMama.releaseBoogersFish(5);
        Swamp.fill(200);
        MumuMama.releaseBoogersFish(5);
    }

}
