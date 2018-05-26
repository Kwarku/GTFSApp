package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Trip")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "trip_id"))})
public class Trip extends FeedModel {

    public static final String TABLE_NAME = "Trip";
    public static Trip NOT_FOUND = new Trip();

 
    @ManyToOne
    private Route routesId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "trip_head_sign")
    private String tripHeadSign;

    @Column(name = "direction_id")
    private String directionId;

    @Column(name = "blok_id")
    private String blockId;

    @ManyToMany
    private Collection<Shape> shapeIdList = new ArrayList<>();

    @Column(name = "is_wheelchair_accessible")
    private boolean wheelchairAccessible;

    @Column(name = "is_low_floor")
    private boolean lowFloor;


    public Trip() {
        super(TextUtils.EMPTY_STRING);
    }

    public Trip(Route routeId,
                String serviceId,
                String tripId,
                String tripHeadSign,
                String directionId,
                String blockId,
                List<Shape> shapeIdList,
                boolean isWheelchairAccessible,
                boolean isLowFloor) {

        super(tripId);
        this.routesId = routeId;
        this.serviceId = serviceId;
        this.tripHeadSign = tripHeadSign;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeIdList = shapeIdList;
        this.wheelchairAccessible = isWheelchairAccessible;
        this.lowFloor = isLowFloor;
    }

    public Route getRouteId() {
        return routesId;
    }

    public void setRouteId(Route routeId) {
        this.routesId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripHeadSign() {
        return tripHeadSign;
    }

    public void setTripHeadSign(String tripHeadSign) {
        this.tripHeadSign = tripHeadSign;
    }

    public String getDirectionId() {
        return directionId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Collection<Shape> getShapeIdList() {
        return shapeIdList;
    }

    public void setShapeIdList(List<Shape> shapeIdList) {
        this.shapeIdList = shapeIdList;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public boolean isLowFloor() {
        return lowFloor;
    }

    public void setLowFloor(boolean lowFloor) {
        this.lowFloor = lowFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return wheelchairAccessible == trip.wheelchairAccessible &&
                lowFloor == trip.lowFloor &&
                Objects.equals(routesId, trip.routesId) &&
                Objects.equals(serviceId, trip.serviceId) &&
                Objects.equals(tripHeadSign, trip.tripHeadSign) &&
                Objects.equals(directionId, trip.directionId) &&
                Objects.equals(blockId, trip.blockId) &&
                Objects.equals(shapeIdList, trip.shapeIdList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(routesId,
                serviceId,
                tripHeadSign,
                directionId,
                blockId,
                shapeIdList,
                wheelchairAccessible,
                lowFloor);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "routeId='" + routesId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", tripHeadSign='" + tripHeadSign + '\'' +
                ", directionId='" + directionId + '\'' +
                ", blockId='" + blockId + '\'' +
                ", shapeIdList='" + shapeIdList + '\'' +
                ", wheelchairAccessible=" + wheelchairAccessible +
                ", lowFloor=" + lowFloor +
                ", id='" + id + '\'' +
                '}';
    }
}
