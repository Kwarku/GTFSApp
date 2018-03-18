package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.repository.AgencyRepository;
import pl.narodzinyprogramsity.repository.FeedRepository;
import pl.narodzinyprogramsity.repository.RoutRepository;

public class RepositoryModule {
    private static RoutRepository routRepository;
    private static AgencyRepository agencyRepository;

    public static FeedRepository<Agency> getAgencyRepository() {
        if (agencyRepository == null) {
            agencyRepository = new AgencyRepository();
        }
        return agencyRepository;
    }

    public static FeedRepository<Rout> getRoutRespository() {
        if (routRepository == null) {
            routRepository = new RoutRepository();
        }
        return routRepository;
    }

}
