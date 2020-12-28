package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

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
        RichPopup rp = (RichPopup) dialogComponent.getParent();
        rp.hide();
    }
}
