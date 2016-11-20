package ua.demitt.homework.util.converter;

import ua.demitt.homework.model.Const;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String dateString) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, Const.ITEM_DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ConverterException("Can't convert " + dateString + "to LocalDate.");
        }
        return date;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        LocalDate date = (LocalDate) o;
        String dayString = String.valueOf(date.getDayOfMonth());
        String monthString = String.valueOf(date.getMonthValue());
        String yearString = String.valueOf(date.getYear());
        if (dayString.length() == 1) {
            dayString = "0" + dayString;
        }
        if (monthString.length() == 1) {
            monthString = "0" + monthString;
        }

        return  //according Const.ITEM_DATE_FORMATTER format
            dayString + Const.ITEM_DATE_DELIMITER +
            monthString + Const.ITEM_DATE_DELIMITER +
            yearString;
    }

}
