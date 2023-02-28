package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.AirlineDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Airline;
import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.sql.SQLException;
import java.util.List;

public class AirlineService implements IService<Airline> {
    private final AirlineDAO airlineDAO;

    {
        airlineDAO = new AirlineDAO();
    }

    @Override
    public List<Airline> findAll() {
        try {
            return airlineDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Airline findOneById(Integer id) {
        try {
            return airlineDAO.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String create(Airline airline) {
        try {
            airlineDAO.create(airline);
            return "Airline Successfully Added";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Airline Could Not Be Added";
    }

    @Override
    public String update(Integer id, Airline airline){
        try {
            airlineDAO.update(id, airline);
            return "Airline Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Airline Could Not Be Updated";
    }

    @Override
    public String delete(Integer id){
        try {
            airlineDAO.delete(id);
            return "Airline Successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Airline Could Not Be Deleted";
    }
}
