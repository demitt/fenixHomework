package ua.demitt.homework.util.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.time.LocalDate;

@ManagedBean(name = "localDateToEpochDayConverter")
public class LocalDateToEpochDayConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String dateString) {
        throw new UnsupportedOperationException("Must not be used.");
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        LocalDate date = (LocalDate) o;
        return String.valueOf( date.toEpochDay() );
    }

}
