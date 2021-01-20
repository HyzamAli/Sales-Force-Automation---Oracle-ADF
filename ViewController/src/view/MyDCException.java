package view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCErrorHandlerImpl;

import oracle.binding.OperationBinding;

public class MyDCException extends DCErrorHandlerImpl {
    public MyDCException(boolean b) {
        super(b);
    }

    public MyDCException() {
        super();
    }

    @Override
    public void reportException(DCBindingContainer dCBindingContainer, Exception exception) {
        System.out.println("DEBUG "+ exception.getMessage());
        String error_message = exception.getMessage();
        if (error_message.startsWith("JBO-26048: Constraint \"PRODUCTS_PER_OPPURTUNITY_UK1\" is violated")) {
            error_message="Product is already added, try  a different product or change quantity"; 
        }
        if (error_message.startsWith("JBO-26048: Constraint \"SALES_TEAM_UK1\" is violated")) {
            error_message="Employee is already added, try  a different employee"; 
        }
        else if (error_message.startsWith("JBO-26048: Constraint \"CONTACTSOPS_UK1\" is violated")) {
            error_message="Contact is already added, try  a different contact"; 
        }
        if (error_message.startsWith("JBO-26048: Constraint \"ROLES_PER_EMPLOYEES_UK1\" is violated")) {
            error_message="Role is already assigned, try  a different role"; 
        }
        else if (error_message.startsWith("JBO-26048")) {
            error_message="Cannot delete entry because it has dependant entries, please clear dependants first"; 
        }
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
        FacesContext context  =FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,error_message,"");
        context.addMessage(null,message);
    }
}
