package enums;

public enum Location {
    SWAMP ("swamp",false),
    HOUSE ("house",true),
    HAMMOCK ("hammock",false);

    private String locationName;
    private Boolean Safe;

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
