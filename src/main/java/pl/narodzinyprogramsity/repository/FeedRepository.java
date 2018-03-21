package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.FeedModel;

import java.util.List;

public interface FeedRepository<T extends FeedModel> {
    String add(T t);

    T get(String id);

    List<T> getAll();

    void update(T t, T newT);

    void delete(T feedObj);

    void delete(String id);

}
