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
        Objects.requireNonNull(newT);

        if (isObjExist(t)) {
            doUpdate(t, newT);
        }
    }


    @Override
    public void delete(T t) {
        Objects.requireNonNull(t);

        if (isObjExist(t)) {
            deleteObjFromList(t);
        }
    }

    @Override
    public void delete(String id) {
        Objects.requireNonNull(id);

        T t = getObject(id);
        if (t == null) {
            return;
        }
        if (isObjExist(t)) {
            deleteObjFromList(t);
        }

    }

    private void deleteObjFromList(T t) {
        list.remove(t);
    }


    private boolean isObjExist(T t) {
        for (T obj : list) {
            if (t.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private void doUpdate(T t, T newT) {
        list.set(getIndex(t), newT);
    }

    private int getIndex(T t) {
        return list.indexOf(t);
    }

    private T getObject(String id) {
        for (T obj : list) {
            if (obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }

}
