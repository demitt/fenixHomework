package ua.demitt.homework.service.impl;

import ua.demitt.homework.dao.ItemDao;
import ua.demitt.homework.model.Item;
import ua.demitt.homework.service.ItemService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "itemService")
@ApplicationScoped
public class ItemServiceImpl implements ItemService {

    @ManagedProperty("#{itemDao}")
    private ItemDao itemDao;

    public ItemServiceImpl() {   }

    @Override
    public List<Item> getItems() {
        return this.itemDao.getItems();
    }

    @Override
    //TODO: по хорошему здесь (в случае, если дата "с" находится после даты "до") необходимо
    //  бросать исключение, ловить его в глобальном ExceptionHandler-е и сообщать об этом пользователю
    public List<Item> getItems(LocalDate from, LocalDate to) {
        return from.isAfter(to) ? new ArrayList<>() : this.itemDao.getItems(from, to);
    }

    @Override
    //Returns null, if items is not empty
    //TODO: здесь также было бы неплохо бросить исключение вместо return null
    public List<Item> generateItems() {
        if (this.itemDao.getItemsCount() != 0 ) {
            return null;
        }
        return this.itemDao.generateItems();
    }

    @Override
    public boolean addItem(LocalDate date, int value, String stringIdPrefix) {
        int id = this.itemDao.getItemsCount() + 1;
        String stringId = String.valueOf(stringIdPrefix == null ? "" : stringIdPrefix) + id;
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
