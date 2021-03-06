package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.Objects;

public class Trip extends FeedModel{
    public static Trip NOT_FOUND = new Trip();

   private String routeId;
   private String serviceId;
   private String tripHeadSign;
   private String directionId;
   private String blockId;
   private int shapeId;
   private boolean wheelchairAccessible;
   private boolean lowFloor;

   public Trip(){
       super(TextUtils.EMPTY_STRING);
   }

    public Trip(String routeId,
                String serviceId,
                String tripId,
                String tripHeadSign,
                String directionId,
                String blockId,
                int shapeId,
                boolean isWheelchairAccessible,
                boolean isLowFloor) {

        super(tripId);
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripHeadSign = tripHeadSign;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeId = shapeId;
        this.wheelchairAccessible = isWheelchairAccessible;
        this.lowFloor = isLowFloor;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
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

    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
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
                Objects.equals(routeId, trip.routeId) &&
                Objects.equals(serviceId, trip.serviceId) &&
                Objects.equals(tripHeadSign, trip.tripHeadSign) &&
                Objects.equals(directionId, trip.directionId) &&
                Objects.equals(blockId, trip.blockId) &&
                Objects.equals(shapeId, trip.shapeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(routeId,
                serviceId,
                tripHeadSign,
                directionId,
                blockId,
                shapeId,
                wheelchairAccessible,
                lowFloor);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "routeId='" + routeId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", tripHeadSign='" + tripHeadSign + '\'' +
                ", directionId='" + directionId + '\'' +
                ", blockId='" + blockId + '\'' +
                ", shapeId='" + shapeId + '\'' +
                ", wheelchairAccessible=" + wheelchairAccessible +
                ", lowFloor=" + lowFloor +
                ", id='" + id + '\'' +
                '}';
    }
}
