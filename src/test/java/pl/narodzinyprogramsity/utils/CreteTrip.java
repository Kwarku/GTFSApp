package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Trip;

public class CreteTrip {


    public static Trip getTestTrip() {
        return new Trip("A", "POW", "A-7549-POW-1-1-0",
                "Plac Rodła", "0", "A/1",
                665, false, true);
    }
}
