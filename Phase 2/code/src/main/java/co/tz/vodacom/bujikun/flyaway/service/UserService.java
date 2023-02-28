package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PlaceDAO;
import co.tz.vodacom.bujikun.flyaway.dao.UserDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Place;
import co.tz.vodacom.bujikun.flyaway.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;

public class UserService implements IService<User>{
    private final UserDAO userDAO;

    {
        userDAO = new UserDAO();
    }

    @Override
    public List<User> findAll() {
        try {
            return userDAO.findAll();
        } catch (Exception e) {
e.printStackTrace();        }
        return List.of();
    }

    @Override
    public User findOneById(Integer id) {
        try {
            return userDAO.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String create(User user) {
        try {
            userDAO.create(user);
            return "User Successfully Added";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User Could Not Be Added";
    }

    @Override
    public String update(Integer id, User user) {
        try {
            userDAO.update(id, user);
            return "User Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            userDAO.delete(id);
            return "User Successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User Could Not Be Deleted";
    }
    public User doLogin(String username, String password){
        try{
            var user= userDAO.findByUsername(username);
            if(BCrypt.checkpw(password,user.getPassword())){
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
