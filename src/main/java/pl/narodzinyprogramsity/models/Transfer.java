package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.utils.CreateID;
import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "Transfer")
public class Transfer extends FeedModel {
    public static final String TABLE_NAME = "Transfer";
    public static final Transfer NOT_FOUND = new Transfer();

    @ManyToOne
    private List<Stop> fromStopIdList;

    @ManyToOne
    private List<Stop> toStopIdList;

    @Column(name = "transfer_type")
    private TransferType transferType;

    @Column(name = "min_transfer_time")
    private String minTransferTime;

    public Transfer(){
        super(TextUtils.EMPTY_STRING);
    }

    public Transfer(List<Stop> fromStopIdList,
                    List<Stop> toStopIdList,
                    TransferType transferType,
                    String minTransferTime) {

        super(CreateID.createId());
        this.fromStopIdList = fromStopIdList;
        this.toStopIdList = toStopIdList;
        this.transferType = transferType;
        this.minTransferTime = minTransferTime;
    }

    public List<Stop> getFromStopIdList() {
        return fromStopIdList;
    }

    public void setFromStopIdList(List<Stop> fromStopIdList) {
        this.fromStopIdList = fromStopIdList;
    }

    public List<Stop> getToStopIdList() {
        return toStopIdList;
    }

    public void setToStopIdList(List<Stop> toStopIdList) {
        this.toStopIdList = toStopIdList;
    }

    @Enumerated
    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public String getMinTransferTime() {
        return minTransferTime;
    }

    public void setMinTransferTime(String minTransferTime) {
        this.minTransferTime = minTransferTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(fromStopIdList, transfer.fromStopIdList) &&
                Objects.equals(toStopIdList, transfer.toStopIdList) &&
                transferType == transfer.transferType &&
                Objects.equals(minTransferTime, transfer.minTransferTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fromStopIdList, toStopIdList, transferType, minTransferTime);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromStopIdList='" + fromStopIdList + '\'' +
                ", toStopIdList='" + toStopIdList + '\'' +
                ", transferType=" + transferType +
                ", minTransferTime='" + minTransferTime + '\'' +
                '}';
    }
}
