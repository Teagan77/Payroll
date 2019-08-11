package org.randall.teagan.Services.ServiceInterfaces;

import java.util.HashMap;

public interface IService<T, ID> {

    T create(T type);

    T update(T type);

    void delete(ID id);

    T read(ID id);

    void removeAll();

    HashMap<String, T> getAll();
}
