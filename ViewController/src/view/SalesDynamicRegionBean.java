package view;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class SalesDynamicRegionBean implements Serializable {
    @SuppressWarnings("compatibility:3199900865535409507")
    private static final long serialVersionUID = 7190307157417768405L;
    private String taskFlowId = "/WEB-INF/sales-flow-dashboard.xml#sales-flow-dashboard";

    public SalesDynamicRegionBean() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }
    
    public String salesflowdashboard() {
        setDynamicTaskFlowId("/WEB-INF/sales-flow-dashboard.xml#sales-flow-dashboard");
        return null;
    }

    public String salesflowcustomers() {
        setDynamicTaskFlowId("/WEB-INF/sales-flow-customers.xml#sales-flow-customers");
        return null;
    }

    public String salesflowoppurtunities() {
        setDynamicTaskFlowId("/WEB-INF/sales-flow-oppurtunities.xml#sales-flow-oppurtunities");
        return null;
    }
}
