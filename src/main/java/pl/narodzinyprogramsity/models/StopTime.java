package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.DropOffType;
import pl.narodzinyprogramsity.modelType.PickupType;
import pl.narodzinyprogramsity.utils.CreateID;
import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "Stop_time")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "stop_time_id"))})
public class StopTime extends FeedModel {

    public static final String TABLE_NAME = "StopTime";
    public static final StopTime NOT_FOUND = new StopTime();

    @ManyToOne
    private Trip tripId;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @ManyToOne
    private Stop stopId;

    @Column(name = "stop_sequence")
    private String stopSequence;

    @Column(name = "stop_headsign")
    private String stopHeadsign;

    @Column(name = "pickup_type")
    private PickupType pickupType;

    @Column(name = "drop_off_type")
    private DropOffType dropOffType;

    public StopTime() {
        super(TextUtils.EMPTY_STRING);
    }

    public StopTime(Trip tripId,
                    LocalTime arrivalTime,
                    LocalTime departureTime,
                    Stop stopId,
                    String stopSequence,
                    String stopHeadsign,
                    PickupType pickupType,
                    DropOffType dropOffType) {

        super(CreateID.createId());
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.stopHeadsign = stopHeadsign;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
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

    public Stop getStopId() {
        return stopId;
    }

    public void setStopId(Stop stopId) {
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

    @Enumerated
    public PickupType getPickupType() {
        return pickupType;
    }

    public void setPickupType(PickupType pickupType) {
        this.pickupType = pickupType;
    }

    @Enumerated
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

        return Objects.hash(tripId,
                arrivalTime,
                departureTime,
                stopId,
                stopSequence,
                stopHeadsign,
                pickupType,
                dropOffType);
    }

    @Override
    public String toString() {
        return "StopTime{" +
                "id :" + id +
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
