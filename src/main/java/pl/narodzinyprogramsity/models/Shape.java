package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.Objects;

public class Shape extends FeedModel {
    private String shapePtLat;
    private String shapePtLon;
    private String shapePtSequence;


    public Shape() {
        super(TextUtils.EMPTY_STRING);
    }

    public Shape(String shapeId, String shapePtLat, String shapePtLon, String shapePtSequence) {
        super(shapeId);
        this.shapePtLat = shapePtLat;
        this.shapePtLon = shapePtLon;
        this.shapePtSequence = shapePtSequence;
    }

    public String getShapePtLat() {
        return shapePtLat;
    }

    public void setShapePtLat(String shapePtLat) {
        this.shapePtLat = shapePtLat;
    }

    public String getShapePtLon() {
        return shapePtLon;
    }

    public void setShapePtLon(String shapePtLon) {
        this.shapePtLon = shapePtLon;
    }

    public String getShapePtSequence() {
        return shapePtSequence;
    }

    public void setShapePtSequence(String shapePtSequence) {
        this.shapePtSequence = shapePtSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(shapePtLat, shape.shapePtLat) &&
                Objects.equals(shapePtLon, shape.shapePtLon) &&
                Objects.equals(shapePtSequence, shape.shapePtSequence);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapePtLat, shapePtLon, shapePtSequence);
    }

    @Override
    public String toString() {
        return "Shape{" +
                " id='" + id + '\'' +
                ", shapePtLat='" + shapePtLat + '\'' +
                ", shapePtLon='" + shapePtLon + '\'' +
                ", shapePtSequence='" + shapePtSequence + '\'' +
                '}';
    }
}
