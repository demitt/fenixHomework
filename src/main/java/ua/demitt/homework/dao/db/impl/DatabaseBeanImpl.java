package ua.demitt.homework.dao.db.impl;

import ua.demitt.homework.dao.db.DatabaseBean;
import ua.demitt.homework.model.Const;
import ua.demitt.homework.model.Item;
import ua.demitt.homework.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* Database emulation:) */

@ManagedBean(name = "databaseBean", eager = true)
@ApplicationScoped
public class DatabaseBeanImpl implements DatabaseBean {

    private Map<String, User> users;
    private NavigableMap<LocalDate, Item> items;

    public DatabaseBeanImpl() {   }

    @PostConstruct
    public void initialize() {
        this.users = new HashMap<>();
        createUser("user@ukr.net", "1"); //TODO: tmp!
        this.items = generateItemsIntern();
    }

    //Returns null if user has not fount
    @Override
    public String getPasswordByEmail(String email) {
        User user = this.users.get(email);
        if (user == null) {
            return null;
        }
        return user.getPassword();
    }

    @Override
    public void createUser(String email, String password) {
        User newUser = new User(email, password);
        this.users.put(email, newUser);
    }

    @Override
    public boolean isUserExists(String email) {
        return this.users.get(email) != null;
    }

    private NavigableMap<LocalDate, Item> generateItemsIntern() {
        Map<LocalDate, Item> items = new HashMap<>();
        long minDate = Const.ITEM_MIN_DATE.toEpochDay();
        long deltaDate = LocalDate.now().toEpochDay() - minDate;
        long epochDay;
        int value;
        boolean itemAdded;
        LocalDate date;
        int counter = 1;
        while (counter <= Const.ITEMS_COUNT) {
            epochDay = minDate + (long)(deltaDate * Math.random());
            date = LocalDate.ofEpochDay(epochDay);
            value = (int)(Const.ITEM_MAX_VALUE * Math.random());
            Item item = new Item(counter, date, value, Const.ITEM_DEFAULT_PREFIX + counter);
            itemAdded = addItemIntern(items, item);
            if (itemAdded) {
                counter++;
            }
        }

        return new TreeMap<>(items);
    }

    @Override
    public boolean addItem(Item item) {
        return addItemIntern(this.items, item);
    }

    private boolean addItemIntern(Map<LocalDate, Item> items, Item item) {
        Item oldItem = items.putIfAbsent(item.getDate(), item);
        return oldItem == null;
    }

    @Override
    public List<Item> generateItems() {
        this.items = generateItemsIntern();
        return getItemsList();
    }

    public List<Item> getItemsList() {
        return new ArrayList<>(this.items.values());
    }

    @Override
    public List<Item> getItemsList(LocalDate from, LocalDate to) {
        Map<LocalDate, Item> items = needsAllItems(from, to) ? this.items : this.items.subMap(from, true, to, true);
        return new ArrayList<>(items.values());
    }

    private boolean needsAllItems(LocalDate from, LocalDate to) {
        if (this.items.isEmpty()) {
            return true;
        }
        LocalDate firstKey = this.items.firstKey();
        LocalDate lastKey = this.items.lastKey();
        return
            ( from.isBefore(firstKey) || from.isEqual(firstKey) ) &&
            ( to.isAfter(lastKey) || to.isEqual(lastKey) );
    }

    @Override
    public void clearItems() {
        this.items.clear();
    }

    @Override
    public int getItemsCount() {
        return this.items.size();
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

}
