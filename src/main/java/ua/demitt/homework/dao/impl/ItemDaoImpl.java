package ua.demitt.homework.dao.impl;

import ua.demitt.homework.dao.ItemDao;
import ua.demitt.homework.dao.db.impl.DatabaseBeanImpl;
import ua.demitt.homework.model.Item;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.time.LocalDate;
import java.util.List;

@ManagedBean(name = "itemDao")
@ApplicationScoped
public class ItemDaoImpl implements ItemDao {

    @ManagedProperty("#{databaseBean}")
    private DatabaseBeanImpl databaseBean;

    public ItemDaoImpl() {   }

    @Override
    public List<Item> getItems() {
        return this.databaseBean.getItemsList();
    }

    @Override
    public List<Item> getItems(LocalDate from, LocalDate to) {
        return this.databaseBean.getItemsList(from, to);
    }

    @Override
    public boolean addItem(Item item) {
        return this.databaseBean.addItem(item);
    }

    @Override
    public void clearItems() {
        this.databaseBean.clearItems();
    }

    @Override
    public List<Item> generateItems() {
        return this.databaseBean.generateItems();
    }

    @Override
    public int getItemsCount() {
        return this.databaseBean.getItemsCount();
    }

    public void setDatabaseBean(DatabaseBeanImpl databaseBean) {
        this.databaseBean = databaseBean;
    }
}
