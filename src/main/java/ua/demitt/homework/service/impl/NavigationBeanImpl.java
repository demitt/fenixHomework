package ua.demitt.homework.service.impl;

import ua.demitt.homework.model.Const;
import ua.demitt.homework.service.NavigationBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "navigationBean")
@ApplicationScoped
public class NavigationBeanImpl implements NavigationBean, Serializable {

    @Override
    public String addPage() {
        return Const.View.ADD.getValue();
    }

    @Override
    public String displayPage() {
        return Const.View.DISPLAY.getValue();
    }

    @Override
    public String loginPage() {
        return Const.View.LOGIN.getValue();
    }

    @Override
    public String defaultPage() {
        return displayPage();
    }

}
