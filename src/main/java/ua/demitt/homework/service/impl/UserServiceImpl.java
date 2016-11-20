package ua.demitt.homework.service.impl;

import ua.demitt.homework.dao.UserDao;
import ua.demitt.homework.service.UserService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;

@ManagedBean(name = "userService")
@ApplicationScoped
public class UserServiceImpl implements UserService, Serializable {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public boolean login(String email, String password) {
        String passwordFromDB = this.userDao.getPasswordByEmail(email);
        return passwordFromDB != null && passwordFromDB.equals(password);
    }

    @Override
    public boolean register(String email, String password, String passwordRepeat) {
        if ( !password.equals(passwordRepeat) ) {
            return false;
        }
        if (this.userDao.isUserExists(email)) {
            return false;
        }
        this.userDao.createUser(email, password);
        return true;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
