package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

public class ContactsBean {
    private String name;
    private String phone;
    private String email;
    private String isPrimary = "0";
    private String influenceLevel = "1";
    private String customerId;
    private RichDialog contactComponent;
    private String countryCode = "+91";

    public ContactsBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setInfluenceLevel(String influenceLevel) {
        this.influenceLevel = influenceLevel;
    }

    public String getInfluenceLevel() {
        return influenceLevel;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setContactComponent(RichDialog contactComponent) {
        this.contactComponent = contactComponent;
    }

    public RichDialog getContactComponent() {
        return contactComponent;
    }
    
    public void closeDeleteDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup rp = (RichPopup) contactComponent.getParent();
        rp.hide();
    }

    public String commitData() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        return null;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
