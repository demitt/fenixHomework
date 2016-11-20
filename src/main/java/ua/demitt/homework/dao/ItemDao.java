package ua.demitt.homework.dao;

import ua.demitt.homework.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemDao {
    List<Item> generateItems();
    List<Item> getItems();
    List<Item> getItems(LocalDate from, LocalDate to);
    boolean addItem(Item item);
    void clearItems();
    int getItemsCount();
}
