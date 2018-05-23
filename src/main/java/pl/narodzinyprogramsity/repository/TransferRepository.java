package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Transfer;

public class TransferRepository extends BaseFeedRepository<Transfer> {
    @Override
    public Transfer get(String id) {
        Transfer transfer = super.get(id);
        if (transfer != null) {
            return transfer;
        }
        return Transfer.NOT_FOUND;
    }
}
