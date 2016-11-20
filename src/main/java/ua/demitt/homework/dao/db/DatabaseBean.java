package ua.demitt.homework.dao.db;

import ua.demitt.homework.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface DatabaseBean {

    boolean isUserExists(String email);
    void createUser(String email, String password);
    String getPasswordByEmail(String email);

    List<Item> getItemsList();
    List<Item> getItemsList(LocalDate from, LocalDate to);
    boolean addItem(Item item);
    void clearItems();
    List<Item> generateItems();
    int getItemsCount();

}
