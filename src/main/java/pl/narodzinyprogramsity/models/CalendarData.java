package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.CreateID;
import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "calendar_data_id")) })
public class CalendarData extends FeedModel {

    public static final CalendarData NOT_FOUND = new CalendarData();
    public static final String TABLE_NAME = "CalenarData";

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "is_data_available")
    private boolean isDataAvailable;

    public CalendarData() {
        super(TextUtils.EMPTY_STRING);
    }

    public CalendarData(String serviceId, LocalDate data, boolean isDataAvailable) {
        super(CreateID.createId());
        this.serviceId = serviceId;
        this.data = data;
        this.isDataAvailable = isDataAvailable;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isDataAvailable() {
        return isDataAvailable;
    }

    public void setDataAvailable(boolean dataAvailable) {
        isDataAvailable = dataAvailable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarData that = (CalendarData) o;
        return isDataAvailable == that.isDataAvailable &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, data, isDataAvailable);
    }

    @Override
    public String toString() {
        return "CalendarData{" +
                "serviceId='" + serviceId + '\'' +
                ", data=" + data +
                ", isDataAvailable=" + isDataAvailable +
                '}';
    }
}
