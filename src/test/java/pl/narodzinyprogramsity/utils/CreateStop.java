package pl.narodzinyprogramsity.utils;


import pl.narodzinyprogramsity.models.LocationType;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.models.WheelchairBoardingType;

public class CreateStop {
    public static Stop getTestStop(){
        return new Stop("1271", "1271", "Kołłątaja 11-15",
                "", "53.443798", "14.548237",
                "http://www.zditm.szczecin.pl/rozklady/",
                LocationType.getLocationType(1),"", WheelchairBoardingType.getType(-1));

    }

}
