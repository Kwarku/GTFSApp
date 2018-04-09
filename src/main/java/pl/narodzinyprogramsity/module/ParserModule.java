package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.*;
import pl.narodzinyprogramsity.parsers.*;

public class ParserModule {
    private static AgencyParser agencyParser;
    private static CalendarParser calendarParser;
    private static CalendarDataParser calendarDataParser;
    private static RouteParser routeParser;
    private static ShapeParser shapeParser;
    private static StopTimeParser stopTimeParser;
    private static StopParser stopParser;
    private static TransferParser transferParser;
    private static TripParser tripParser;

    public static FeedParser<Agency> getAgencyParser() {
        if (agencyParser == null) {
            agencyParser = new AgencyParser();
        }
        return agencyParser;
    }

    public static FeedParser<Calendar> getCalendarParser() {
        if (calendarParser == null) {
            calendarParser = new CalendarParser();
        }
        return calendarParser;
    }

    public static FeedParser<CalendarData> getCalendarDataParser() {
        if (calendarDataParser == null) {
            calendarDataParser = new CalendarDataParser();
        }
        return calendarDataParser;
    }

    public static FeedParser<Route> getRouteParser() {
        if (routeParser == null) {
            routeParser = new RouteParser();
        }
        return routeParser;
    }

    public static FeedParser<Shape> getShapeParser() {
        if (shapeParser == null) {
            shapeParser = new ShapeParser();
        }
        return shapeParser;
    }

    public static FeedParser<StopTime> getStopTimeParser() {
        if (stopTimeParser == null) {
            stopTimeParser = new StopTimeParser();
        }
        return stopTimeParser;
    }

    public static FeedParser<Stop> getStopParser() {
        if (stopParser == null) {
            stopParser = new StopParser();
        }
        return stopParser;
    }

    public static FeedParser<Transfer> getTransferParser() {
        if (transferParser == null) {
            transferParser = new TransferParser();
        }
        return transferParser;
    }

    public static FeedParser<Trip> getTripParser() {
        if (tripParser == null) {
            tripParser = new TripParser();
        }
        return tripParser;
    }

}
