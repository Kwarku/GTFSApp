package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.Objects;

public class Rout extends FeedModel {
    private String routeShortName;
    private String routeLongName;
    private String routeDesc;
    private RoutType routeType;
    private String routeUrl;
    private String routeColor;
    private String routeTextColor;

    public Rout(String routeId, String routeShortName, String routeLongName, String routeDesc,
                RoutType routeType, String routeUrl, String routeColor, String routeTextColor) {
        super(routeId);
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeDesc = routeDesc;
        this.routeType = routeType;
        this.routeUrl = routeUrl;
        this.routeColor = routeColor;
        this.routeTextColor = routeTextColor;
    }

    public Rout() {
        super(TextUtils.EMPTY_STRING);
    }


    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public RoutType getRouteType() {
        return routeType;
    }

    public void setRouteType(RoutType routeType) {
        this.routeType = routeType;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rout rout = (Rout) o;
        return Objects.equals(routeShortName, rout.routeShortName) &&
                Objects.equals(routeLongName, rout.routeLongName) &&
                Objects.equals(routeDesc, rout.routeDesc) &&
                routeType == rout.routeType &&
                Objects.equals(routeUrl, rout.routeUrl) &&
                Objects.equals(routeColor, rout.routeColor) &&
                Objects.equals(routeTextColor, rout.routeTextColor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(routeShortName, routeLongName, routeDesc, routeType, routeUrl, routeColor, routeTextColor);
    }

    @Override
    public String toString() {
        return "Rout{" +
                "routeShortName='" + routeShortName + '\'' +
                ", routeLongName='" + routeLongName + '\'' +
                ", routeDesc='" + routeDesc + '\'' +
                ", routeType=" + routeType +
                ", routeUrl='" + routeUrl + '\'' +
                ", routeColor='" + routeColor + '\'' +
                ", routeTextColor='" + routeTextColor + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
