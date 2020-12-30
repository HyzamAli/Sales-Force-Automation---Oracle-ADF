package view;

import java.sql.Date;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;

import oracle.binding.OperationBinding;

public class NotesBean {
    private String title;
    private String description;
    private String contactID;
    private String repID;
    private String oppurtunityID;
    private Date createdOn;
    private String customerId;   
    private RichDialog component;
    

    public NotesBean() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getContactID() {
        return contactID;
    }

    public void setRepID(String repID) {
        this.repID = repID;
    }

    public String getRepID() {
        return repID;
    }

    public void setOppurtunityID(String oppurtunityID) {
        this.oppurtunityID = oppurtunityID;
    }

    public String getOppurtunityID() {
        return oppurtunityID;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
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
        RichPopup rp = (RichPopup) component.getParent();
        rp.hide();
    }
}
