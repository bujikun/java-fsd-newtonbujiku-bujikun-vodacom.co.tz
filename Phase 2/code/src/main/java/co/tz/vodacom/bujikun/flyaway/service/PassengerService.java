package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PassengerDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Passenger;
import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.sql.SQLException;
import java.util.List;

public class PassengerService implements IService<Passenger> {
    private final PassengerDAO passengerDAO;
    {
        passengerDAO = new PassengerDAO();
    }
    @Override
    public List<Passenger> findAll() {
        return passengerDAO.findAll();
    }

    @Override
    public Passenger findOneById(Integer id) {
        return passengerDAO.findOneById(id);
    }

    @Override
    public String create(Passenger passenger) {
        try{
            passengerDAO.create(passenger);
            return "Passenger Successfully Added";
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Added";
    }

    @Override
    public String update(Integer id, Passenger passenger){
        try{
            passengerDAO.update(id,passenger);
            return "Passenger Successfully Updated";
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try{
            passengerDAO.delete(id);
            return "Passenger Successfully Deleted";
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Deleted";
    }
}
