package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.RoutType;
import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Route")
public class Route extends FeedModel {
    public static final String TABLE_NAME = "Route";
    public static Route NOT_FOUND = new Route();

    @Column(name = "route_short_name")
    private String routeShortName;

    @Column(name = "route_long_name")
    private String routeLongName;

    @Column(name = "route_desc")
    private String routeDesc;

    @Column(name = "route_type")
    private RoutType routeType;

    @Column(name = "route_url")
    private String routeUrl;

    @Column(name = "route_color")
    private String routeColor;

    @Column(name = "route_text_color")
    private String routeTextColor;

    public Route(String routeId,
                 String routeShortName,
                 String routeLongName,
                 String routeDesc,
                 RoutType routeType,
                 String routeUrl,
                 String routeColor,
                 String routeTextColor) {

        super(routeId);
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeDesc = routeDesc;
        this.routeType = routeType;
        this.routeUrl = routeUrl;
        this.routeColor = routeColor;
        this.routeTextColor = routeTextColor;
    }

    public Route() {
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

    @Enumerated()
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
        Route route = (Route) o;
        return Objects.equals(routeShortName, route.routeShortName) &&
                Objects.equals(routeLongName, route.routeLongName) &&
                Objects.equals(routeDesc, route.routeDesc) &&
                routeType == route.routeType &&
                Objects.equals(routeUrl, route.routeUrl) &&
                Objects.equals(routeColor, route.routeColor) &&
                Objects.equals(routeTextColor, route.routeTextColor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(routeShortName,
                routeLongName,
                routeDesc,
                routeType,
                routeUrl,
                routeColor,
                routeTextColor);
    }

    @Override
    public String toString() {
        return "Route{" +
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
