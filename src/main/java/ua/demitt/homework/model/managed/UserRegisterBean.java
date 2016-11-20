package ua.demitt.homework.model.managed;

import ua.demitt.homework.model.Const;
import ua.demitt.homework.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "userRegisterBean")
@ViewScoped
public class UserRegisterBean {

    @ManagedProperty("#{userService}")
    private UserService userService;

    @ManagedProperty("#{userLoginBean}")
    private UserLoginBean userLoginBean;

    private String email;
    private String password;
    private String passwordRepeat;
    private String message;

    public UserRegisterBean() {   }

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

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserLoginBean(UserLoginBean userLoginBean) {
        this.userLoginBean = userLoginBean;
    }

    public String registerAction() {
        this.message = null;
        boolean registerCompleted =
            this.userService.register(this.email, this.password, this.passwordRepeat);
        if (registerCompleted) {
            this.message = Const.Message.Register.COMPLETED;
            this.userLoginBean.setEmail(this.email);
            this.email = null;
        } else {
            this.message = Const.Message.Register.ERROR;
        }
        return null;
    }

}
