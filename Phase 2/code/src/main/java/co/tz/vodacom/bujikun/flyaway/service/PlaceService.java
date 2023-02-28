package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PlaceDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.sql.SQLException;
import java.util.List;

public class PlaceService implements IService<Place>{
    private final PlaceDAO placeDAO;

    {
        placeDAO = new PlaceDAO();
    }

    @Override
    public List<Place> findAll() {
        try {
            return placeDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Place findOneById(Integer id) {
        try {
            return placeDAO.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String create(Place place) {
        try {
            placeDAO.create(place);
            return "Place Successfully Added";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Added";
    }

    @Override
    public String update(Integer id, Place place) {
        try {
            placeDAO.update(id, place);
            return "Place Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            placeDAO.delete(id);
            return "Place Successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Deleted";
    }
}
