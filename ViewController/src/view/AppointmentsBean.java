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

public class AppointmentsBean {
    private String name;
    private String description;
    private Date start;
    private Date end;
    private String location;
    private String resolution;
    private String type;
    private String direction;
    private String contactID;
    private RichDialog component;
    private RichDialog deleteComponent;
    private String customerID;
    private String oppurtunityID;
    private String customerName;
    private String opName;

    public AppointmentsBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStart() {
        return start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getContactID() {
        return contactID;
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

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        if (customerID != null) findCustNameById();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setOppurtunityID(String oppurtunityID) {
        this.oppurtunityID = oppurtunityID;
        if (oppurtunityID != null) findOpNameById();
    }

    public String getOppurtunityID() {
        return oppurtunityID;
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

    private void findOpNameById() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("OppurtunitiesVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { oppurtunityID});
        Row row = rsi.findByKey(key, 1)[0];
        opName = (String) row.getAttribute("OpName");
    }

    private void findCustNameById() {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter =
              (DCIteratorBinding)bc.findIteratorBinding("CustomersVO1Iterator");
        RowSetIterator rsi = iter.getRowSetIterator();
        Key key = new Key(new Object[] { customerID});
        Row row = rsi.findByKey(key, 1)[0];
        customerName = (String) row.getAttribute("AccName");
    }
}
