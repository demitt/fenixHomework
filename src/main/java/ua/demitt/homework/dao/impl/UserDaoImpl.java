package ua.demitt.homework.dao.impl;

import ua.demitt.homework.dao.UserDao;
import ua.demitt.homework.dao.db.impl.DatabaseBeanImpl;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;

@ManagedBean(name = "userDao")
@ApplicationScoped
public class UserDaoImpl implements UserDao, Serializable {

    @ManagedProperty("#{databaseBean}")
    private DatabaseBeanImpl databaseBean;

    @Override
    public String getPasswordByEmail(String email) {
        return this.databaseBean.getPasswordByEmail(email);
    }

    @Override
    public void createUser(String email, String password) {
        this.databaseBean.createUser(email, password);
    }

    @Override
    public boolean isUserExists(String email) {
        return this.databaseBean.isUserExists(email);
    }

    public void setDatabaseBean(DatabaseBeanImpl databaseBean) {
        this.databaseBean = databaseBean;
    }
}
