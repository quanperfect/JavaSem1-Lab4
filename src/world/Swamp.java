package world;

import exceptions.NoWaterException;
import interfaces.interactionAble;
import сreature.Animal;

import java.util.Objects;

final public class Swamp implements interactionAble {
    private Integer waterOpacity;
    private String color;
    private Integer volume;
    private Integer depth;
    private Integer area;
    private Boolean isPopulated;
    private Integer timesInstantiated = 0;

    private static Swamp swamp;

    private Swamp () {
        timesInstantiated++;
        this.waterOpacity = 95;
        this.color = "blue";
        this.depth = 25;
        this.area = 25;
        this.volume = this.depth * this.area;
        this.isPopulated = true;
    }

    public static Swamp getSwamp() {
        if (swamp == null ) {
            swamp = new Swamp();
        }

        return swamp;
    }

    public Integer getTimesInstantiated() {
        return timesInstantiated;
    }

    public Integer getWaterOpacity() {
        return waterOpacity;
    }

    public String getColor() {
        return color;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getDepth() {
        return depth;
    }

    public Integer getArea() {
        return area;
    }

    public Boolean getIsPopulated() {
        return isPopulated;
    }

    public void getDirtier() {
        if (volume > 0) {
            if ((waterOpacity - 5) > 1) {
                waterOpacity -= 5;
            }
            else
            {
                waterOpacity = 1;
            }
        }
        else throw new NoWaterException("Unable to getDirtier, there's no water in the swamp");
    }

    public void splashWater() {
        System.out.println("Somebody's splashing the water");
    }

    public void releaseBoogersFish(Integer amount) {
        checkIfCanBePopulated();
        if (isPopulated) {
            System.out.println(amount + " boogers fish added to the swamp");
        }
        else {
            System.out.println(amount + " boogers fish immediately die in the swamp since it is uninhabitable.");
        }
    }

    public void makeUninhabitable() {
        isPopulated = false;
        System.out.println("Swamp is uninhabitable, not populated.");
    }

    public void drain(Integer drainPercent) {
        drainPercent /= 100; // divide by 2 (area and depth) and by 100 (to coefficient)

        area *= (1 - drainPercent);
        depth *= (1 - drainPercent);
        volume = area * depth;
        checkIfCanBePopulated();
    }

    public void fill(Integer volumeFill) {
        area += volumeFill/2;
        depth += volumeFill/2;
        volume = area * depth;
        checkIfCanBePopulated();
    }

    public void checkIfCanBePopulated() {
        if ((area >= 25) && (depth >= 25) && (!Objects.equals(color, "purple")) && (waterOpacity > 15)) {
            if (!isPopulated) {
                isPopulated = true;
                System.out.println("Swamp is now inhabitable, populated.");
            }
        }
        else {
            makeUninhabitable();
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Swamp otherSwamp = (Swamp) otherObject;
        return  ( (getWaterOpacity().equals(otherSwamp.getWaterOpacity())) && (getArea().equals(otherSwamp.getArea())) && (getDepth().equals(otherSwamp.getDepth()))
                && (getIsPopulated().equals(otherSwamp.getIsPopulated())) && (getColor().equals(otherSwamp.getColor())) && (getVolume().equals(otherSwamp.getVolume())) ) ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getVolume());
    }

    @Override
    public String toString() {
        return  "[Area: " + getArea() + "; Depth: " + getDepth() + "; Volume: " + getVolume() + "; Color: " + getColor() + "; isPopulated: " + getIsPopulated() + "; waterOpacity: " + getWaterOpacity() + "]";
    }
}
