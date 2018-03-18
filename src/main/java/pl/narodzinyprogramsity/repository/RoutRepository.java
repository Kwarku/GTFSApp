package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Rout;

public class RoutRepository extends BaseFeedRepository<Rout> {

    @Override
    public Rout get(String id) {
        Rout rout = super.get(id);
        if (rout != null) {
            return rout;
        }
        return Rout.NOT_FOUND;
    }
}
