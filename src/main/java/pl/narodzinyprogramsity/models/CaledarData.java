package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import java.time.LocalDate;
import java.util.Objects;

public class CaledarData extends FeedModel{

    private String serviceId;
    private LocalDate data;
    private boolean isDataAvailable;

    public CaledarData(String serviceId, LocalDate data, boolean isDataAvailable) {
        super(TextUtils.EMPTY_STRING);
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
        CaledarData that = (CaledarData) o;
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
        return "CaledarData{" +
                "serviceId='" + serviceId + '\'' +
                ", data=" + data +
                ", isDataAvailable=" + isDataAvailable +
                '}';
    }
}
