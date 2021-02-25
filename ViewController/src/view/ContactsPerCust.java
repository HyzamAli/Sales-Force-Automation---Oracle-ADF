package view;

import java.math.BigDecimal;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class ContactsPerCust {
    private String contactId;
    private String contactName;
    private String phone;
    private String email;
    private String isPrimary = "0";
    private RichDialog component;
    private RichDialog deleteComponent;

    public void setContactId(String contactId) {
        this.contactId = contactId;
        if (contactId != null) findNameByKey();
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
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

    public void setComponent(RichDialog component) {
        this.component = component;
    }

    public RichDialog getComponent() {
        return component;
    }

    public void setDeleteComponent(RichDialog deleteComponent) {
        this.deleteComponent = deleteComponent;
    }

    public RichDialog getDeleteComponent() {
        return deleteComponent;
    }
    
    public void updatePrimary(ActionEvent actionEvent) {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("ContactsByCustomersVO2Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Row currentRow = rsi.getCurrentRow();
        if (currentRow == null) return;
        
        Row[] rows = rsi.getAllRowsInRange();
        for (Row row : rows) {
            BigDecimal rowValue = (BigDecimal)row.getAttribute("IsPrimary");
            if (rowValue.intValue() == 1) {
                row.setAttribute("IsPrimary", 0);
            }
        }

        currentRow.setAttribute("IsPrimary", 1);
        OperationBinding operationBinding = bc.getOperationBinding("Commit");
        operationBinding.execute();
        operationBinding = bc.getOperationBinding("Execute");
        operationBinding.execute();
    }
    
    public void closeDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        operationBinding = bindings.getOperationBinding("Execute");
        operationBinding.execute();
        RichPopup rp = (RichPopup) component.getParent();
        rp.hide();        
    }
    
    public void closeDeleteDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup rp = (RichPopup) deleteComponent.getParent();
        rp.hide();
    }
    
    public void findNameByKey() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("CustomerContactsVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { contactId});
        Row row = rsi.findByKey(key, 1)[0];
        contactName = (String) row.getAttribute("ContactName");
        email = (String) row.getAttribute("ContactEmail");
        phone = (String) row.getAttribute("ContactPhone");
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

}
