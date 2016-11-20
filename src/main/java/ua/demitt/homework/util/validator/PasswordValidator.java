package ua.demitt.homework.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

    private static final String PASSWORD_PATTERN = "^[a-zA-Z\\d]{1,10}$";
    private static final String PASSWORD_VALIDATION_ERROR =
        "В пароле можно использовать от 1 до 10 следующих символов: цифры и английские буквы.";

    private Pattern pattern;

    public PasswordValidator() {
        this.pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage(PASSWORD_VALIDATION_ERROR);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
