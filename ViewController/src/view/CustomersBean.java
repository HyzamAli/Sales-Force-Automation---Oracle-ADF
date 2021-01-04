package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.binding.OperationBinding;

public class CustomersBean {
    private String accName;
    private String refID;
    private String addLine1;
    private String addLine2;
    private String parentAccount;
    private String accURL;
    private String email;
    private String phone;
    private String country;
    private String pin;
    private String industry;

    public CustomersBean() {
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccName() {
        return accName;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }

    public String getRefID() {
        return refID;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setAccURL(String accURL) {
        this.accURL = accURL;
    }

    public String getAccURL() {
        return accURL;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }
    
    public String commitData() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        return null;
    }
}
