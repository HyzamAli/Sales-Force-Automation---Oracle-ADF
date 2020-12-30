package view;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

public class SalesTeamBean {
    private String empId;
    private RichDialog component;

    public SalesTeamBean() {
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
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
