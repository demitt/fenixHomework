package ua.demitt.homework.model;

import java.time.LocalDate;

public class Item {

    private int id;
    private LocalDate date;
    private int value;
    private String stringId;

    public Item() {   }

    public Item(int id, LocalDate date, int value, String stringId) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.stringId = stringId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        return date == item.date;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + value;
        result = 31 * result + (stringId != null ? stringId.hashCode() : 0);
        return result;
    }

}
