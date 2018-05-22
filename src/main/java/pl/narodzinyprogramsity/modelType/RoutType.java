package pl.narodzinyprogramsity.modelType;

public enum RoutType {
    TRAM(0),
    METRO(1),
    RAIL(2),
    BUS(3),
    FERRY(4),
    CABLE_CAR(5),
    GONDOLA(6),
    FUNICULAR(7),
    UNKNOWN(-1);

    private int type;

    RoutType(int type){
        this.type = type;
    }

    public static RoutType getRouteType(int types){
        for (RoutType rout : RoutType.values()) {
            if (rout.type == types) {
                return rout;
            }
        }
        return UNKNOWN;
    }
}
