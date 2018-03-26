package pl.narodzinyprogramsity.modelType;

public enum TransferType {
    RECOMMENDED(0), DEPARTING_WAIT_TO_ARRIVING(1), REQUIRE_TIME(2), NOT_POSSIBLE(3);
    private int type;

    TransferType(int type) {
        this.type = type;
    }

    public static TransferType getTransferType(int typeNumber) {
        for (TransferType transferType : TransferType.values()) {
            if (transferType.type == typeNumber) {
                return transferType;
            }
        }
        return RECOMMENDED;
    }
}
