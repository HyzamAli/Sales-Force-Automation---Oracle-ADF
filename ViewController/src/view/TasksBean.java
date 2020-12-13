package view;

import java.sql.Date;

public class TasksBean {
    private String contactID;
    private String repID;
    private String priority;
    private Date dueDate;
    private String percentageDone;
    private String details;
    private String oppurtunityID;

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
    }

    public String getOppurtunityID() {
        return oppurtunityID;
    }
}
