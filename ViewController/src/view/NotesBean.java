package view;

import java.sql.Date;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class NotesBean {
    private String title;
    private String description;
    private String contactID;
    private String repID;
    private String oppurtunityID;
    private Date createdOn=new Date(System.currentTimeMillis());
    private String customerId;   
    private String customerName;
    private String opName;
    private RichDialog component;
    private RichDialog deleteComponent;
    

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
        if (oppurtunityID != null) findOpNameById();
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
        if (customerId != null) findCustomerNameById();
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

    public void setDeleteComponent(RichDialog deleteComponent) {
        this.deleteComponent = deleteComponent;
    }

    public RichDialog getDeleteComponent() {
        return deleteComponent;
    }
    
    public void closeDeleteDialog() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup rp = (RichPopup) deleteComponent.getParent();
        rp.hide();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpName() {
        return opName;
    }
    
    public void findOpNameById() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("OppurtunitiesVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { oppurtunityID});
        Row row = rsi.findByKey(key, 1)[0];
        opName = (String) row.getAttribute("OpName");
    }
    
    public void findCustomerNameById() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("CustomersVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { customerId});
        Row row = rsi.findByKey(key, 1)[0];
        customerName = (String) row.getAttribute("AccName");
    }
}
