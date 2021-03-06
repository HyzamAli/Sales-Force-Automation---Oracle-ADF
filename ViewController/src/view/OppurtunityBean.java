package view;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.sql.Blob;
import java.sql.Date;

import java.util.Calendar;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class OppurtunityBean {
    private String customerId;
    private String refId;
    private String win_prob = "50";
    private Date close_Date;
    private String salesStage = "Oppurtunity";
    private String salesMethod = "Standard Process";
    private String salesChannel = "Indirect";
    private String salesRevenue;
    private String worstCase;
    private String bestCase;
    private String duration;
    private String budgetedAmount;
    private String riskLevel = "Low";
    private String decisionLevel;
    private String quantity;
    private String managerId;
    private String revenueQuarter;
    private String opName;

    public OppurtunityBean() {
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefId() {
        return refId;
    }

    public void setWin_prob(String win_prob) {
        this.win_prob = win_prob;
    }

    public String getWin_prob() {
        return win_prob;
    }

    public void setClose_Date(Date close_Date) {
        setRevenueQuarter(close_Date);
        this.close_Date = close_Date;
    }

    public Date getClose_Date() {
        return close_Date;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesMethod(String salesMethod) {
        this.salesMethod = salesMethod;
    }

    public String getSalesMethod() {
        return salesMethod;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesRevenue(String salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public String getSalesRevenue() {
        return salesRevenue;
    }

    public void setWorstCase(String worstCase) {
        this.worstCase = worstCase;
    }

    public String getWorstCase() {
        return worstCase;
    }

    public void setBestCase(String bestCase) {
        this.bestCase = bestCase;
    }

    public String getBestCase() {
        return bestCase;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setBudgetedAmount(String budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    public String getBudgetedAmount() {
        return budgetedAmount;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setDecisionLevel(String decisionLevel) {
        this.decisionLevel = decisionLevel;
    }

    public String getDecisionLevel() {
        return decisionLevel;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerId() {
        return managerId;
    }

    private void setRevenueQuarter(Date closeDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(closeDate);
        int month = cal.get(Calendar.MONTH);
        
        if (month >= 0 && month<=2) {
            this.revenueQuarter = "Q1";
        } else if (month <= 5) {
            this.revenueQuarter = "Q2";
        } else if (month <=8) {
            this.revenueQuarter = "Q3";
        } else {
            this.revenueQuarter = "Q4";
        }
    }

    public String getRevenueQuarter() {
        return revenueQuarter;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpName() {
        return opName;
    }
    
    public String commitData() {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        operationBinding.execute();
        return null;
    }
}
