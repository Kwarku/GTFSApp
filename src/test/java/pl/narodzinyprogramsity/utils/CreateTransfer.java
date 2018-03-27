package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.models.Transfer;

public class CreateTransfer {
    public static Transfer createTestTransfer() {
        return new Transfer("10221",
                "10112",
                TransferType.getTransferType(2),
                "320");
    }
}
