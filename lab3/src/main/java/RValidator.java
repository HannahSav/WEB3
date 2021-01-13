import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("rValidator")
public class RValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Double r = Double.parseDouble(o.toString());
        Boolean stepChecked = false;
        if (o.toString().split("\\.")[1].length()==1) stepChecked = true;
        if (!((r>=2)&&(r<=5))||!(stepChecked)){
            FacesMessage msg = new FacesMessage("Failed validation R");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
