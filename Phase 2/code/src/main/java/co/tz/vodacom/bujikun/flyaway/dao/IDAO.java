package co.tz.vodacom.bujikun.flyaway.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    List<T> findAll() throws Exception;
    T findOneById(Integer id) throws Exception;
    void create(T t) throws Exception;
    void update(Integer id, T t) throws Exception;
    void delete(Integer id) throws Exception;
}
