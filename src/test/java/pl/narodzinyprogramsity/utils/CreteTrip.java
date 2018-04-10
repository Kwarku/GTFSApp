package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Trip;

public class CreteTrip {


    public static Trip getOriginalTrip() {
        return new Trip("A",
                "POW",
                "A-7549-POW-1-1-0",
                "Plac Rodła",
                "0",
                "A/1",
                665,
                false,
                true);
    }

    public static Trip testTrip1() {
        return new Trip("testRouteId1",
                "testServiceID1",
                "testTripID1",
                "testHeadSign1",
                "testDirectionID1",
                "testBlockID1",
                1,
                false,
                true);
    }

    public static Trip testTrip2() {
        return new Trip("testRouteId2",
                "testServiceID2",
                "testTripID2",
                "testHeadSign2",
                "testDirectionID2",
                "testBlockID2",
                2,
                true,
                true);
    }

    public static Trip testTrip3() {
        return new Trip("testRouteId3",
                "testServiceID3",
                "testTripID3",
                "testHeadSign3",
                "testDirectionID3",
                "testBlockID3",
                3,
                true,
                false);
    }

    public static Trip testTrip4() {
        return new Trip("testRouteId4",
                "testServiceID4",
                "testTripID4",
                "testHeadSign4",
                "testDirectionID4",
                "testBlockID4",
                4,
                false,
                false);
    }
}
