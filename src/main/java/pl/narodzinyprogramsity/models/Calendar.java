package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.CreateID;
import pl.narodzinyprogramsity.utils.TextUtils;

import java.time.LocalDate;
import java.util.Objects;

public class Calendar extends FeedModel {
    public static final Calendar NOT_FOUND = new Calendar();

    private String serviceId;
    private boolean isMonday;
    private boolean isTuesday;
    private boolean isWednesday;
    private boolean isThursday;
    private boolean isFriday;
    private boolean isSaturday;
    private boolean isSunday;

    private LocalDate startDate;
    private LocalDate endDate;

    public Calendar() {
        super(TextUtils.EMPTY_STRING);

    }

    public Calendar(String service_id,
                    boolean isMonday,
                    boolean isTuesday,
                    boolean isWednesday,
                    boolean isThursday,
                    boolean isFriday,
                    boolean isSaturday,
                    boolean isSunday,
                    LocalDate startDate,
                    LocalDate endDate) {

        super(CreateID.createId());
        this.serviceId = service_id;
        this.isMonday = isMonday;
        this.isTuesday = isTuesday;
        this.isWednesday = isWednesday;
        this.isThursday = isThursday;
        this.isFriday = isFriday;
        this.isSaturday = isSaturday;
        this.isSunday = isSunday;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public boolean isMonday() {
        return isMonday;
    }

    public void setMonday(boolean monday) {
        isMonday = monday;
    }

    public boolean isTuesday() {
        return isTuesday;
    }

    public void setTuesday(boolean tuesday) {
        isTuesday = tuesday;
    }

    public boolean isWednesday() {
        return isWednesday;
    }

    public void setWednesday(boolean wednesday) {
        isWednesday = wednesday;
    }

    public boolean isThursday() {
        return isThursday;
    }

    public void setThursday(boolean thursday) {
        isThursday = thursday;
    }

    public boolean isFriday() {
        return isFriday;
    }

    public void setFriday(boolean friday) {
        isFriday = friday;
    }

    public boolean isSaturday() {
        return isSaturday;
    }

    public void setSaturday(boolean saturday) {
        isSaturday = saturday;
    }

    public boolean isSunday() {
        return isSunday;
    }

    public void setSunday(boolean sunday) {
        isSunday = sunday;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return isMonday == calendar.isMonday &&
                isTuesday == calendar.isTuesday &&
                isWednesday == calendar.isWednesday &&
                isThursday == calendar.isThursday &&
                isFriday == calendar.isFriday &&
                isSaturday == calendar.isSaturday &&
                isSunday == calendar.isSunday &&
                Objects.equals(serviceId, calendar.serviceId) &&
                Objects.equals(startDate, calendar.startDate) &&
                Objects.equals(endDate, calendar.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId,
                isMonday,
                isTuesday,
                isWednesday,
                isThursday,
                isFriday,
                isSaturday,
                isSunday,
                startDate,
                endDate);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "serviceId='" + serviceId + '\'' +
                ", isMonday=" + isMonday +
                ", isTuesday=" + isTuesday +
                ", isWednesday=" + isWednesday +
                ", isThursday=" + isThursday +
                ", isFriday=" + isFriday +
                ", isSaturday=" + isSaturday +
                ", isSunday=" + isSunday +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
