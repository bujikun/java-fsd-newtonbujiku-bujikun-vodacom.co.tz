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
        return placeDAO.findAll();
    }

    @Override
    public Place findOneById(Integer id) {
        return placeDAO.findOneById(id);
    }

    @Override
    public String create(Place place) {
        try {
            placeDAO.create(place);
            return "Place Successfully Added";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Added";
    }

    @Override
    public String update(Integer id, Place place) {
        try {
            placeDAO.update(id, place);
            return "Place Successfully Updated";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            placeDAO.delete(id);
            return "Place Successfully Deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Place Could Not Be Deleted";
    }
}
