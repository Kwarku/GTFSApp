package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Trip;

public class TripParser extends BaseFeedParser<Trip> {

    private static final int ROUTE_ID = 0;
    private static final int SERVICE_ID = 1;
    private static final int TRIP_ID = 2;
    private static final int TRIP_HEAD_SIGN = 3;
    private static final int DIRECTION_ID = 4;
    private static final int BLOCK_ID = 5;
    private static final int SHAPE_ID = 6;
    private static final int WHEELCHAIR_ACCESSIBLE = 7;
    private static final int LOW_FLOOR = 8;

    private static final int NUMBER_OF_ELEMENTS = 9;

    private static final int TRUE_VALUE = 1;

    public TripParser() {
        super(NUMBER_OF_ELEMENTS);
    }

    @Override
    public Trip parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Trip trip = new Trip();
        trip.setId(splitFeedInfo[TRIP_ID]);
        trip.setRouteId(splitFeedInfo[ROUTE_ID]);
        trip.setServiceId(splitFeedInfo[SERVICE_ID]);
        trip.setTripHeadSign(splitFeedInfo[TRIP_HEAD_SIGN]);
        trip.setDirectionId(splitFeedInfo[DIRECTION_ID]);
        trip.setBlockId(splitFeedInfo[BLOCK_ID]);
        validateShapeId(trip);
        validateWheelchairAccessible(trip);
        validateLowFloor(trip);

        return trip;
    }

    private void validateShapeId(Trip trip) {
        if (isNotEmpty(SHAPE_ID)) {
            trip.setShapeId(Integer.MIN_VALUE);
        } else {
            trip.setShapeId(Integer.parseInt(splitFeedInfo[SHAPE_ID]));
        }
    }

    private void validateWheelchairAccessible(Trip trip) {
        if (isNotEmpty(WHEELCHAIR_ACCESSIBLE)) {
            trip.setWheelchairAccessible(false);
        } else {
            trip.setWheelchairAccessible(
                    Integer.parseInt(splitFeedInfo[WHEELCHAIR_ACCESSIBLE]) == TRUE_VALUE);
        }
    }

    private void validateLowFloor(Trip trip) {
        if (isNotEmpty(LOW_FLOOR)) {
            trip.setLowFloor(false);
        } else {
            trip.setLowFloor(Integer.parseInt(splitFeedInfo[LOW_FLOOR]) == TRUE_VALUE);
        }
    }

    private boolean isNotEmpty(int lowFloor) {
        return splitFeedInfo[lowFloor].equals("");
    }
}
