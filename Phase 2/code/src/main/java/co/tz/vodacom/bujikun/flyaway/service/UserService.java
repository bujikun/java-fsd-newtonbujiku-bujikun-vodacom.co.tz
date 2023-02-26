package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PlaceDAO;
import co.tz.vodacom.bujikun.flyaway.dao.UserDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Place;
import co.tz.vodacom.bujikun.flyaway.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IService<User>{
    private final UserDAO userDAO;

    {
        userDAO = new UserDAO();
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findOneById(Integer id) {
        return userDAO.findOneById(id);
    }

    @Override
    public String create(User user) {
        try {
            userDAO.create(user);
            return "User Successfully Added";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User Could Not Be Added";
    }

    @Override
    public String update(Integer id, User user) {
        try {
            userDAO.update(id, user);
            return "User Successfully Updated";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            userDAO.delete(id);
            return "User Successfully Deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User Could Not Be Deleted";
    }
}
