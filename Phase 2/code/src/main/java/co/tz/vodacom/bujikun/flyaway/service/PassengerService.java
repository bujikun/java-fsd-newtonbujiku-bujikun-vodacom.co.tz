package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PassengerDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Passenger;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
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
        try {
            return passengerDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();

    }

    @Override
    public Passenger findOneById(Integer id) {
        try {
            return passengerDAO.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String create(Passenger passenger) {
        try{
            passengerDAO.create(passenger);
            return "Passenger Successfully Added";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Added";
    }

    @Override
    public String update(Integer id, Passenger passenger){
        try{
            passengerDAO.update(id,passenger);
            return "Passenger Successfully Updated";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try{
            passengerDAO.delete(id);
            return "Passenger Successfully Deleted";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Passenger Could Not Be Deleted";
    }
    public int createAndGetId(Passenger passenger) {
        try {
            return passengerDAO.createAndGetId(passenger);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
