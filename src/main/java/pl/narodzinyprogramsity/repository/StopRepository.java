package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Stop;

public class StopRepository extends BaseFeedRepository<Stop> {



    @Override
    public Stop get(String id) {
        Stop stop =  super.get(id);
        if (stop == null) {
            stop = Stop.NOT_FOUND;
        }
        return stop;
    }

}
