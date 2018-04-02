package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.models.Transfer;

public class CreateTransfer {
    public static Transfer createOriginalTransfer() {
        return new Transfer("10221",
                "10112",
                TransferType.getTransferType(2),
                "320");
    }

    public static Transfer createTestTransfer1() {
        return new Transfer("fromTest1",
                "toTest1",
                TransferType.getTransferType(0),
                "test1");
    }

    public static Transfer createTestTransfer2() {
        return new Transfer("fromTest2",
                "toTest2",
                TransferType.getTransferType(1),
                "test2");
    }

    public static Transfer createTestTransfer3() {
        return new Transfer("fromTest3",
                "toTest3",
                TransferType.getTransferType(2),
                "test3");
    }

    public static Transfer createTestTransfer4() {
        return new Transfer("fromTest4",
                "toTest4",
                TransferType.getTransferType(3),
                "test4");
    }

}
