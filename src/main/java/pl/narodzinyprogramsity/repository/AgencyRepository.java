package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Agency;

public class AgencyRepository extends BaseFeedRepository<Agency> {

    @Override
    public Agency get(String id) {
        Agency agency = super.get(id);
        if (agency != null) {
            return agency;
        }
        return Agency.NOT_FOUND;
    }
}
