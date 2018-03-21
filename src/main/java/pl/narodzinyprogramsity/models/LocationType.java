package pl.narodzinyprogramsity.models;

public enum LocationType {
    STOP(0),STATION(1), ENTER_OR_EXIT(2), UNKNOWN(-1);

    private int type;

    LocationType(int type) {
        this.type = type;
    }

    public static LocationType getLocationType(int type){
        for (LocationType locationType : LocationType.values()) {
            if (locationType.type == type) {
                return locationType;
            }

        }
        return UNKNOWN;
    }
}
