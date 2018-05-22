package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.utils.CreateID;
import pl.narodzinyprogramsity.utils.TextUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "Transfer")
public class Transfer extends FeedModel {
    public static final String TABLE_NAME = "Transfer";
    public static final Transfer NOT_FOUND = new Transfer();

    @Column(name = "from_stop_id")
    private String fromStopId;

    @Column(name = "to_stop_id")
    private String toStopId;

    @Column(name = "transfer_type")
    private TransferType transferType;

    @Column(name = "min_transfer_time")
    private String minTransferTime;

    public Transfer(){
        super(TextUtils.EMPTY_STRING);
    }

    public Transfer(String fromStopId,
                    String toStopId,
                    TransferType transferType,
                    String minTransferTime) {

        super(CreateID.createId());
        this.fromStopId = fromStopId;
        this.toStopId = toStopId;
        this.transferType = transferType;
        this.minTransferTime = minTransferTime;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public void setFromStopId(String fromStopId) {
        this.fromStopId = fromStopId;
    }

    public String getToStopId() {
        return toStopId;
    }

    public void setToStopId(String toStopId) {
        this.toStopId = toStopId;
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
        return Objects.equals(fromStopId, transfer.fromStopId) &&
                Objects.equals(toStopId, transfer.toStopId) &&
                transferType == transfer.transferType &&
                Objects.equals(minTransferTime, transfer.minTransferTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fromStopId, toStopId, transferType, minTransferTime);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromStopId='" + fromStopId + '\'' +
                ", toStopId='" + toStopId + '\'' +
                ", transferType=" + transferType +
                ", minTransferTime='" + minTransferTime + '\'' +
                '}';
    }
}
