package view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;

public class DialogHandler {
    private RichDialog dialogComponent;

    public DialogHandler() {
    }


    public void setDialogComponent(RichDialog dialogComponent) {
        this.dialogComponent = dialogComponent;
    }

    public RichDialog getDialogComponent() {
        return dialogComponent;
    }

    public void closeDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup rp = (RichPopup) dialogComponent.getParent();
        rp.hide();
    }
    
    public void onUpdate(DialogEvent dialogEvent) {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding;
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.yes)
         {
            operationBinding = bindings.getOperationBinding("Commit");
        } else {
            operationBinding = bindings.getOperationBinding("Rollback");
        }
        operationBinding.execute();

    }
}
