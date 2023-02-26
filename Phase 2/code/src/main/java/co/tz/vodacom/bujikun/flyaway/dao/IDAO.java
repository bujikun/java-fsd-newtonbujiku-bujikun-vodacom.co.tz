package co.tz.vodacom.bujikun.flyaway.dao;

import java.util.List;

public interface IDAO<T> {
    List<T> findAll();
    T findOneById(Integer id);
    void create(T t);
    void update(Integer id, T t);
    void delete(Integer id);
}
