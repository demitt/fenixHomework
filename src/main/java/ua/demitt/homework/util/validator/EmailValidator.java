package ua.demitt.homework.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-]+(\\." +
        "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
        "(\\.[A-Za-z]{2,})$";
    private static final String EMAIL_VALIDATION_ERROR = "Введен неправильный e-mail.";

    private Pattern pattern;

    public EmailValidator() {
        this.pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage(EMAIL_VALIDATION_ERROR);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
