package ua.demitt.homework.util.validator;

import ua.demitt.homework.model.Const;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("itemValueValidator")
public class ItemValueValidator implements Validator {

    private static final String ITEM_VALUE_VALIDATION_ERROR =
        "Значение должно находиться в диапазоне от " + Const.ITEM_MIN_VALUE + " до " + Const.ITEM_MAX_VALUE + ".";

    public ItemValueValidator()  {   }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Integer valueInt = (Integer) value;
        if ( valueInt == null || valueInt < Const.ITEM_MIN_VALUE || valueInt > Const.ITEM_MAX_VALUE  ) {
            FacesMessage message = new FacesMessage(ITEM_VALUE_VALIDATION_ERROR);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
