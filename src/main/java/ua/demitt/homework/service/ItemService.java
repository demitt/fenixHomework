package ua.demitt.homework.service;

import ua.demitt.homework.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {
    List<Item> generateItems();
    List<Item> getItems();
    List<Item> getItems(LocalDate from, LocalDate to);
    boolean addItem(LocalDate date, int value, String stringIdPrefix);
    void clearItems();
    boolean isGeneratorDisabled();
}
