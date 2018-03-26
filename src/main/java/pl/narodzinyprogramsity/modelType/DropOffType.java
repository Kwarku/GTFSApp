package pl.narodzinyprogramsity.modelType;

public enum DropOffType {
    REGULARLY(0),NO_DROP(1),MUST_PHONE_AGENCY(2), MUST_COORDINATE_WITH_DRIVER(3),;

    private int type;

    DropOffType(int type) {
        this.type = type;
    }

    public static DropOffType getDropOffType(int typeNumber){
        for (DropOffType dropOffType : DropOffType.values()) {
            if (dropOffType.type == typeNumber) {
                return dropOffType;
            }
        }
        return REGULARLY;
    }

}
