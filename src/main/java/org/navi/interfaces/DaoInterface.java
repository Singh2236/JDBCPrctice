package org.navi.interfaces;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
