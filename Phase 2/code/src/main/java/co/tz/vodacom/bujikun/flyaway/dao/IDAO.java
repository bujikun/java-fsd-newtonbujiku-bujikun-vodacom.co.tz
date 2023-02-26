package co.tz.vodacom.bujikun.flyaway.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    List<T> findAll();
    T findOneById(Integer id);
    void create(T t) throws SQLException;
    void update(Integer id, T t) throws SQLException;
    void delete(Integer id) throws SQLException;
}
