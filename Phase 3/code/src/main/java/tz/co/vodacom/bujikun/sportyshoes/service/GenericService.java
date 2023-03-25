package tz.co.vodacom.bujikun.sportyshoes.service;

import java.util.List;

public interface GenericService <T,U> {
    void  createNew(T t);
    void delete(U id);
    void update(T t);
    T findById(U id);
    List<T> findAll();
}
