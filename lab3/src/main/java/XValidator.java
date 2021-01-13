import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("xValidator")
public class XValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Double x = Double.parseDouble(o.toString());
        Boolean stepChecked = false;
        if (o.toString().split("\\.")[1].equals("0")) stepChecked = true;
        if (!((x>=-4)&&(x<=4))||!(stepChecked)){
            FacesMessage msg = new FacesMessage("Failed validation X");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
