package view;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

public class AttendeeCustomerBean {
    private String contactId;
    private RichDialog component;

    public AttendeeCustomerBean() {
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }
    
    public void setComponent(RichDialog component) {
        this.component = component;
    }

    public RichDialog getComponent() {
        return component;
    }
    
    public void closeDialog() {
        RichPopup rp = (RichPopup) component.getParent();
        rp.hide();
    }
}
