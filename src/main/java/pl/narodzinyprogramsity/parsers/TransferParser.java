package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.models.Transfer;
import pl.narodzinyprogramsity.utils.CreateID;

public class TransferParser extends BaseFeedParser<Transfer> {


    private static final int FROM_STOP_ID_COLUMN = 0;
    private static final int TO_STOP_ID_COLUMN = 1;
    private static final int TRANSFER_TYPE_COLUMN = 2;
    private static final int MINIMAL_TRANSFER_TIME_COLUMN = 3;

    private static final int NUMBER_OF_ELEMENTS = 4;

    public TransferParser() {
        super(NUMBER_OF_ELEMENTS);
    }


    @Override
    public Transfer parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Transfer transfer = new Transfer();
        transfer.setFromStopId(splitFeedInfo[FROM_STOP_ID_COLUMN]);
        transfer.setToStopId(splitFeedInfo[TO_STOP_ID_COLUMN]);
        transfer.setTransferType(getTransferType());
        transfer.setMinTransferTime(splitFeedInfo[MINIMAL_TRANSFER_TIME_COLUMN]);

        return transfer;
    }

    private TransferType getTransferType() {
        String transferTypeString = splitFeedInfo[TRANSFER_TYPE_COLUMN];
        int transferTypeInt;

        if (transferTypeString.equals("")) {
            transferTypeInt = -1;
        }else {
            transferTypeInt = Integer.parseInt(transferTypeString);
        }
        return TransferType.getTransferType(transferTypeInt);
    }
}
