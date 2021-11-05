package world;

public class Swamp {
    private Integer waterOpacity;
    private String color;
    private Integer volume;
    private Integer depth;
    private Integer area;
    private Boolean isPopulated;

    public Swamp (Integer waterOpacity, String color, Integer depth, Integer area) {
        this.waterOpacity = waterOpacity;
        this.color = color;
        this.volume = area * depth;
        this.depth = depth;
        this.area = area;
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
        if ((waterOpacity - 5) > 1) {
            waterOpacity -= 5;
        }
        else
        {
            waterOpacity = 1;
        }
    }

    public void makeUninhabitable() {
        isPopulated = false;
        System.out.println("Swamp is no longer populated");
    }

    public void drain(int drainPercent) {
        drainPercent /= 200; // divide by 2 (area and depth) and by 100 (to coefficent)

        area *= (1 - drainPercent);
        depth *= (1 - drainPercent);
        volume = area * depth;
    }

    public void checkIfCanBePopulated() {
        if ((area > 1) && (depth > 1) && (color != "purple") && (waterOpacity > 15)) {
            isPopulated = false;
        }
        else {
            isPopulated = true;
        }
    }


}
