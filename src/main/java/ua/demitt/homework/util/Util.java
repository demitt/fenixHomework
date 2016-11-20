package ua.demitt.homework.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Util {

    private Util() {   };

    public static ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }
}
