package pl.narodzinyprogramsity.modelType;

public enum PickupType {
    REGULARLY(0), NO_PICKUP(1), MUST_PHONE_AGENCY(2), MUST_COORDINATE_WITH_DRIVER(3);

    private int type;

    PickupType(int type) {
        this.type = type;
    }

    public static PickupType getPickupType(int typeNumber){
        for (PickupType pickupType : PickupType.values()) {
            if (pickupType.type == typeNumber) {
                return pickupType;
            }
        }
        return REGULARLY;
    }
}
