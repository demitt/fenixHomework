package ua.demitt.homework.service.impl;

import ua.demitt.homework.dao.ItemDao;
import ua.demitt.homework.exception.NegativeDateRangeException;
import ua.demitt.homework.model.Item;
import ua.demitt.homework.service.ItemService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@ManagedBean(name = "itemService")
@ApplicationScoped
public class ItemServiceImpl implements ItemService, Serializable {

    @ManagedProperty("#{itemDao}")
    private ItemDao itemDao;

    public ItemServiceImpl() {   }

    @Override
    public List<Item> getItems() {
        return this.itemDao.getItems();
    }

    @Override
    public List<Item> getItems(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            throw new NegativeDateRangeException();
        }
        return this.itemDao.getItems(from, to);
    }

    @Override
    //Returns null, if items is not empty
    public List<Item> generateItems() {
        if (this.itemDao.getItemsCount() != 0 ) {
            return null;
        }
        return this.itemDao.generateItems();
    }

    @Override
    public boolean addItem(LocalDate date, int value, String stringIdPrefix) {
        int id = this.itemDao.getItemsCount() + 1;
        String stringId = stringIdPrefix + id;
        Item item = new Item(id, date, value, stringId);
        return this.itemDao.addItem(item);
    }

    @Override
    public void clearItems() {
        this.itemDao.clearItems();
    }

    @Override
    public boolean isGeneratorDisabled() {
        return this.itemDao.getItemsCount() != 0;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
