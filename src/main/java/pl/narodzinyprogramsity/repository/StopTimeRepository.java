package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.StopTime;

public class StopTimeRepository extends BaseFeedRepository<StopTime> {
    @Override
    public StopTime get(String id) {
        StopTime stopTime = super.get(id);
        if (stopTime != null) {
            return stopTime;
        }
        return StopTime.NOT_FOUND;
    }
}
