package view;

import java.sql.Date;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class TasksBean {
    private String contactID;
    private String repID;
    private String priority;
    private Date dueDate;
    private String percentageDone;
    private String details;
    private String oppurtunityID;
    private String customerId;
    private RichDialog component;
    private RichDialog deleteComponent;
    private String custName;
    private String opName;

    public TasksBean() {
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

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setPercentageDone(String percentageDone) {
        this.percentageDone = percentageDone;
    }

    public String getPercentageDone() {
        return percentageDone;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setOppurtunityID(String oppurtunityID) {
        this.oppurtunityID = oppurtunityID;
        if(oppurtunityID != null) findOpNameById();
    }

    public String getOppurtunityID() {
        return oppurtunityID;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
        if (customerId != null) findCustNameById();
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

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustName() {
        return custName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpName() {
        return opName;
    }
    
    public void findCustNameById() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("CustomersVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { customerId});
        Row row = rsi.findByKey(key, 1)[0];
        custName = (String) row.getAttribute("AccName");
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
}
