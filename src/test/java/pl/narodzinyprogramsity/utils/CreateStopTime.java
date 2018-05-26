//package pl.narodzinyprogramsity.utils;
//
//import pl.narodzinyprogramsity.modelType.DropOffType;
//import pl.narodzinyprogramsity.modelType.PickupType;
//import pl.narodzinyprogramsity.models.StopTime;
//
//import java.time.LocalTime;
//
//public class CreateStopTime {
//
//    public static StopTime createOriginalStopTime() {
//        return new StopTime("A-7549-POW-1-1-0",
//                LocalTime.of(4, 41, 0),
//                LocalTime.of(4, 41, 0),
//                "84613",
//                "1",
//                "",
//                PickupType.REGULARLY,
//                DropOffType.REGULARLY);
//    }
//    public static StopTime createTestStopTime1() {
//        return new StopTime("testTripId1",
//                LocalTime.MAX,
//                LocalTime.MAX,
//                "testStopId1",
//                "1",
//                "",
//                PickupType.REGULARLY,
//                DropOffType.REGULARLY);
//    }
//    public static StopTime createTestStopTime2() {
//        return new StopTime("testTripId2",
//                LocalTime.of(1, 12, 0),
//                LocalTime.of(1, 13, 0),
//                "testStopId2",
//                "1",
//                "",
//                PickupType.NO_PICKUP,
//                DropOffType.NO_DROP);
//    }
//    public static StopTime createTestStopTime3() {
//        return new StopTime("testTripId3",
//                LocalTime.of(5, 10, 0),
//                LocalTime.of(5, 10, 0),
//                "testStopId3",
//                "1",
//                "",
//                PickupType.MUST_COORDINATE_WITH_DRIVER,
//                DropOffType.MUST_COORDINATE_WITH_DRIVER);
//    }
//    public static StopTime createTestStopTime4() {
//        return new StopTime("testTripId4",
//                LocalTime.of(16, 41, 0),
//                LocalTime.of(16, 41, 0),
//                "testStopId4",
//                "12",
//                "",
//                PickupType.MUST_PHONE_AGENCY,
//                DropOffType.MUST_PHONE_AGENCY);
//    }
//}
