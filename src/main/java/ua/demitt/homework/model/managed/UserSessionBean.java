package ua.demitt.homework.model.managed;

import ua.demitt.homework.service.NavigationBean;
import ua.demitt.homework.util.Util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {

    @ManagedProperty("#{navigationBean}")
    private NavigationBean navigationBean;

    private String email;

    public UserSessionBean() {   }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String logoutAction() {
        Util.getExternalContext().invalidateSession();
        return this.navigationBean.loginPage();
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
}
