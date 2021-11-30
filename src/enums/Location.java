package enums;

public enum Location {
    SWAMP ("Swamp",false),
    HOUSE ("House",true),
    HAMMOCK ("Hammock",false);

    private final String locationName;
    private final Boolean Safe;

    Location (String locationName, Boolean Safe) {
        this.locationName = locationName;
        this.Safe = Safe;
    }

    public Boolean getSafe() {
        return Safe;
    }

    public String getLocationName() {
        return locationName;
    }
}
