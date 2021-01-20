package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;

public class ProductsOpBean {
    private String prodId;
    private String quantity;
    private String category;
    private RichDialog component;
    private RichDialog deleteComponent;

    public ProductsOpBean() {
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setComponent(RichDialog component) {
        this.component = component;
    }

    public RichDialog getComponent() {
        return component;
    }
    
    public void closeDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        operationBinding = bindings.getOperationBinding("Execute");
        operationBinding.execute();
        operationBinding = bindings.getOperationBinding("Execute1");
        operationBinding.execute();
        RichPopup rp = (RichPopup) component.getParent();
        rp.hide();
    }
    
    public void closeDeleteDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        operationBinding = bindings.getOperationBinding("Execute");
        operationBinding.execute();
        operationBinding = bindings.getOperationBinding("Execute1");
        operationBinding.execute();
        RichPopup rp = (RichPopup) deleteComponent.getParent();
        rp.hide();
    }
    
    public void onUpdate(DialogEvent dialogEvent) {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding;
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.yes)
         {
            operationBinding = bindings.getOperationBinding("Commit");
            operationBinding.execute();
            operationBinding = bindings.getOperationBinding("Execute");
            operationBinding.execute();
            operationBinding = bindings.getOperationBinding("Execute1");
            operationBinding.execute();
        } else {
            operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public void setDeleteComponent(RichDialog deleteComponent) {
        this.deleteComponent = deleteComponent;
    }

    public RichDialog getDeleteComponent() {
        return deleteComponent;
    }
}
