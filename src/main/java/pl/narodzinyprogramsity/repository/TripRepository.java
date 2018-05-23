package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Trip;

public class TripRepository extends BaseFeedRepository<Trip> {
    @Override
    public Trip get(String id) {
        Trip trip = super.get(id);
        if (trip == null) {
            trip = Trip.NOT_FOUND;
        }
        return trip;
    }
}
