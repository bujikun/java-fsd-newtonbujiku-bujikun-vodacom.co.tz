package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.util.List;

public interface IService<T> {

    List<T> findAll();
    T findOneById(Integer id);
    String create(T t);
    String update(Integer id, T t);
    String delete(Integer id);
}
