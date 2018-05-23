package pl.narodzinyprogramsity.modelType;

public enum WheelchairBoardingType {
    NO_INFORMATION(0),AVAILABLE(1), NOT_AVAILABLE(2);

    private int type;
    WheelchairBoardingType(int type) {
        this.type = type;
    }

    public static WheelchairBoardingType getType(int type){
        for (WheelchairBoardingType someType : WheelchairBoardingType.values()) {
            if (someType.type == type) {
                return someType;
            }
        }
        return NO_INFORMATION;
    }
}
