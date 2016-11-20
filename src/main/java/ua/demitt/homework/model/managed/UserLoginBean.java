package ua.demitt.homework.model.managed;

import ua.demitt.homework.model.Const;
import ua.demitt.homework.service.NavigationBean;
import ua.demitt.homework.service.UserService;
import ua.demitt.homework.util.Util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "userLoginBean")
@ViewScoped
public class UserLoginBean {

    @ManagedProperty("#{userService}")
    private UserService userService;

    @ManagedProperty("#{navigationBean}")
    private NavigationBean navigationBean;

    @ManagedProperty("#{userSessionBean}")
    private UserSessionBean userSessionBean;

    private String email;
    private String password;
    private String message;

    { //TODO tmp!
        this.email = "user@ukr.net";
        this.password = "1";
    }

    /*@PostConstruct
    public void initialize() {
        if (isUserInSession()) {
            this.navigationBean.defaultPage();
        }
    }

    private boolean isUserInSession() {
        return Util.getExternalContext().getSessionMap().get(Const.SESSION_USER_ID_NAME) != null;
    }*/

    public UserLoginBean() {   }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String loginAction() {
        boolean loginCompleted = this.userService.login(this.email, this.password);
        if (loginCompleted) {
            this.userSessionBean.setEmail(this.email);
            Util.getExternalContext().getSessionMap().put(Const.SESSION_USER_ID_NAME, this.email);
            return this.navigationBean.defaultPage();
        }
        this.message = Const.Message.Login.USER_NOT_FOUND;
        return null;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

}
