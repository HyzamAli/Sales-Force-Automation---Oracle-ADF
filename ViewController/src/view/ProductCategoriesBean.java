package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

public class ProductCategoriesBean {
    private String productCategory;
    private RichDialog component;
    
    public ProductCategoriesBean() {
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }
    
    public void closeDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup rp = (RichPopup) component.getParent();
        rp.hide();
    }

    public void setComponent(RichDialog component) {
        this.component = component;
    }

    public RichDialog getComponent() {
        return component;
    }
}
