package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.FlightDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.sql.SQLException;
import java.util.List;

public class FlightService implements IService<Flight> {
    private final FlightDAO flightDAO;

    {
        flightDAO = new FlightDAO();
    }

    @Override
    public List<Flight> findAll() {
        return flightDAO.findAll();
    }

    @Override
    public Flight findOneById(Integer id) {
        return flightDAO.findOneById(id);
    }

    @Override
    public String create(Flight flight) {
        try {
            flightDAO.create(flight);
            return "Flight Successfully Added";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Flight Could Not Be Added";
    }

    @Override
    public String update(Integer id, Flight flight){
        try {
            flightDAO.update(id, flight);
            return "Flight Successfully Updated";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Flight Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            flightDAO.delete(id);
            return "Flight Successfully Deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Flight Could Not Be Deleted";
    }
}
