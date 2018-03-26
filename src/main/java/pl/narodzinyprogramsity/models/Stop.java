package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.LocationType;
import pl.narodzinyprogramsity.modelType.WheelchairBoardingType;
import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.Objects;

public class Stop extends FeedModel {
    public static final Stop NOT_FOUND = new Stop();

    private String stopCode;
    private String stopName;
    private String stopDesc;
    private String stopLat;
    private String stopLon;
    private String stopUrl;
    private LocationType locationType;
    private String parentStation;
    private WheelchairBoardingType wheelchairBoardingType;

    public Stop(){
        super(TextUtils.EMPTY_STRING);
    }

    public Stop(String stopId, String stopCode, String stopName,
                String stopDesc, String stopLat, String stopLon,
                String stopUrl, LocationType locationType,
                String parentStation,WheelchairBoardingType wheelchairBoardingType) {

        super(stopId);
        this.stopCode = stopCode;
        this.stopName = stopName;
        this.stopDesc = stopDesc;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.stopUrl = stopUrl;
        this.locationType = locationType;
        this.parentStation = parentStation;
        this.wheelchairBoardingType = wheelchairBoardingType;
    }


    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public String getStopLat() {
        return stopLat;
    }

    public void setStopLat(String stopLat) {
        this.stopLat = stopLat;
    }

    public String getStopLon() {
        return stopLon;
    }

    public void setStopLon(String stopLon) {
        this.stopLon = stopLon;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(String stopUrl) {
        this.stopUrl = stopUrl;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }

    public WheelchairBoardingType getWheelchairBoardingType() {
        return wheelchairBoardingType;
    }

    public void setWheelchairBoardingType(WheelchairBoardingType wheelchairBoardingType) {
        this.wheelchairBoardingType = wheelchairBoardingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return Objects.equals(stopCode, stop.stopCode) &&
                Objects.equals(stopName, stop.stopName) &&
                Objects.equals(stopDesc, stop.stopDesc) &&
                Objects.equals(stopLat, stop.stopLat) &&
                Objects.equals(stopLon, stop.stopLon) &&
                Objects.equals(stopUrl, stop.stopUrl) &&
                locationType == stop.locationType &&
                Objects.equals(parentStation, stop.parentStation) &&
                Objects.equals(wheelchairBoardingType, stop.wheelchairBoardingType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stopCode, stopName, stopDesc, stopLat, stopLon, stopUrl, locationType, parentStation, wheelchairBoardingType);
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopCode='" + stopCode + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopDesc='" + stopDesc + '\'' +
                ", stopLat='" + stopLat + '\'' +
                ", stopLon='" + stopLon + '\'' +
                ", stopUrl='" + stopUrl + '\'' +
                ", locationType=" + locationType +
                ", parentStation='" + parentStation + '\'' +
                ", wheelchairBoardingType='" + wheelchairBoardingType + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
