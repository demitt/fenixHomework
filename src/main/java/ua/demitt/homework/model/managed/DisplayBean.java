package ua.demitt.homework.model.managed;

import ua.demitt.homework.model.Item;
import ua.demitt.homework.service.ItemService;
import ua.demitt.homework.service.NavigationBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "displayBean")
@ViewScoped
public class DisplayBean {

    @ManagedProperty("#{itemService}")
    private ItemService itemService;

    @ManagedProperty("#{navigationBean}")
    private NavigationBean navigationBean;

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<Item> items;

    public DisplayBean() {   }

    @PostConstruct
    public void initialize() {
        this.items = this.itemService.getItems();
        setDatesAccordingData();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public void clearItems() {
        this.itemService.clearItems();
        this.items = new ArrayList<>();
    }

    public void generateItems() {
        List<Item> items = this.itemService.generateItems();
        if (items != null) {
            this.items = items;
            setDatesAccordingData();
        }
    }

    public boolean getIsGeneratorDisabled() {
        return this.itemService.isGeneratorDisabled();
    }

    public void getItemsRange() {
        this.items = this.itemService.getItems(this.dateFrom, this.dateTo);
    }

    private void setDatesAccordingData() {
        if (this.items.isEmpty()) {
            this.dateFrom = LocalDate.now();
            this.dateTo = LocalDate.now();
            return;
        }
        this.dateFrom = this.items.get(0).getDate();
        this.dateTo = this.items.get(this.items.size() - 1).getDate();
    }

    public String goToAddPage() {
        return this.navigationBean.addPage();
    }

}
