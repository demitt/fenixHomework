package ua.demitt.homework.util.validator;

import ua.demitt.homework.model.Const;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@FacesValidator("localDateValidator")
public class LocalDateValidator implements Validator {

    private static final String DATE_PATTERN =
        "yyyy" + Const.ITEM_DATE_DELIMITER + "MM" + Const.ITEM_DATE_DELIMITER + "dd";
    private static final String DATE_VALIDATION_ERROR = "Введена некорректная дата.";

    private DateTimeFormatter formatter;

    public LocalDateValidator() {
        this.formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        FacesMessage message = new FacesMessage(DATE_VALIDATION_ERROR);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        if (value == null) {
            throw new ValidatorException(message);
        }
        try {
            LocalDate date = LocalDate.parse(String.valueOf(value), formatter);
        } catch (DateTimeParseException e) {
            throw new ValidatorException(message);
        }

    }

}
