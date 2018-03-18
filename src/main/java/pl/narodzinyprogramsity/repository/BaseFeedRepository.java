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
        if (result){
            return t.getId();
        }
        return TextUtils.EMPTY_STRING;
    }

    @Override
    public T get(String id) {
        for (T obj : list){
            if (obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return list;
    }

    @Override
    public void update(T feedObj) {
        list.set(Integer.parseInt(feedObj.getId()), feedObj);
    }

    @Override
    public void delete(T feedObj) {
        list.remove(feedObj);
    }

    @Override
    public void delete(String id) {
        list.remove(Integer.parseInt(id));
    }
}
