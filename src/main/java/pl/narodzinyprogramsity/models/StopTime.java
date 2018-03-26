package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.DropOffType;
import pl.narodzinyprogramsity.modelType.PickupType;
import pl.narodzinyprogramsity.utils.TextUtils;

import java.time.LocalTime;
import java.util.Objects;

public class StopTime extends FeedModel {

    private String tripId;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private String stopId;
    private String stopSequence;
    private String stopHeadsign;
    private PickupType pickupType;
    private DropOffType dropOffType;

    public StopTime(String tripId,
                    LocalTime arrivalTime, LocalTime departureTime,
                    String stopId, String stopSequence, String stopHeadsign,
                    PickupType pickupType, DropOffType dropOffType) {

        super(TextUtils.EMPTY_STRING);
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.stopHeadsign = stopHeadsign;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(String stopSequence) {
        this.stopSequence = stopSequence;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public PickupType getPickupType() {
        return pickupType;
    }

    public void setPickupType(PickupType pickupType) {
        this.pickupType = pickupType;
    }

    public DropOffType getDropOffType() {
        return dropOffType;
    }

    public void setDropOffType(DropOffType dropOffType) {
        this.dropOffType = dropOffType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopTime stopTime = (StopTime) o;
        return Objects.equals(tripId, stopTime.tripId) &&
                Objects.equals(arrivalTime, stopTime.arrivalTime) &&
                Objects.equals(departureTime, stopTime.departureTime) &&
                Objects.equals(stopId, stopTime.stopId) &&
                Objects.equals(stopSequence, stopTime.stopSequence) &&
                Objects.equals(stopHeadsign, stopTime.stopHeadsign) &&
                Objects.equals(pickupType, stopTime.pickupType) &&
                Objects.equals(dropOffType, stopTime.dropOffType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tripId, arrivalTime, departureTime, stopId, stopSequence, stopHeadsign, pickupType, dropOffType);
    }

    @Override
    public String toString() {
        return "StopTime{" +
                "tripId='" + tripId + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", stopId='" + stopId + '\'' +
                ", stopSequence='" + stopSequence + '\'' +
                ", stopHeadsign='" + stopHeadsign + '\'' +
                ", pickupType=" + pickupType +
                ", dropOffType=" + dropOffType +
                '}';
    }
}
