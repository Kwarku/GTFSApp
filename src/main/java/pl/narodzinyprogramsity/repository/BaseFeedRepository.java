package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseFeedRepository<T extends FeedModel> implements FeedRepository<T> {
    protected List<T> list;

    public BaseFeedRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public String add(T t) {
        Objects.requireNonNull(t);

        boolean result = list.add(t);
        if (result) {
            return t.getId();
        }
        return TextUtils.EMPTY_STRING;
    }

    @Override
    public T get(String id) {
        Objects.requireNonNull(id);

        return getObject(id);
    }

    @Override
    public List<T> getAll() {
        return list;
    }

    @Override
    public void update(T t, T newT) {
        Objects.requireNonNull(t);

        list.set(getIndex(t), newT);
    }

    @Override
    public void delete(T t) {
        Objects.requireNonNull(t);

        list.remove(t);
    }

    @Override
    public void delete(String id) {
        Objects.requireNonNull(id);

        T t = getObject(id);
        Objects.requireNonNull(t);
        list.remove(t);
    }

    private T getObject(String id) {
        for (T obj : list) {
            if (obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    private int getIndex(T t) {
        return list.indexOf(get(t.getId()));
    }
}
