package tz.co.vodacom.bujikun.kitchenstories.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T,U> extends PagingAndSortingRepository<T,U>, CrudRepository<T,U> {

}
