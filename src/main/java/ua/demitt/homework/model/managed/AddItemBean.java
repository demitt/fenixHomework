package ua.demitt.homework.model.managed;

import ua.demitt.homework.model.Const;
import ua.demitt.homework.service.ItemService;
import ua.demitt.homework.service.NavigationBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.time.LocalDate;

@ManagedBean(name = "addItemBean")
@ViewScoped
public class AddItemBean {

    @ManagedProperty("#{itemService}")
    private ItemService itemService;

    @ManagedProperty("#{navigationBean}")
    private NavigationBean navigationBean;

    private LocalDate date;
    private int value;
    private String stringIdPrefix;

    private String message;

    public AddItemBean() {   }

    @PostConstruct
    public void initialize() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStringIdPrefix() {
        return stringIdPrefix;
    }

    public void setStringIdPrefix(String stringIdPrefix) {
        this.stringIdPrefix = stringIdPrefix;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public void addItem() {
        boolean itemAdded = this.itemService.addItem(this.date, this.value, this.stringIdPrefix);
        this.message = itemAdded ? Const.Message.Item.ADDED : Const.Message.Item.HASNT_ADDED;
        if (itemAdded) {
            resetFields();
        }
    }

    private void resetFields() {
        this.value = 0;
        this.stringIdPrefix = null;
    }

    public String goToDisplayPage() {
        return this.navigationBean.displayPage();
    }

}
