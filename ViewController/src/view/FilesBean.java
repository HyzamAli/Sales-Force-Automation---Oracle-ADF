package view;


import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class FilesBean {
    private UploadedFile file;
    private String OpId;
    private String description;
    private RichDialog component;
    private RichDialog deleteComponent;
    private List<UploadedFile> list;

    public FilesBean() {
        list=new ArrayList<>();
    }

    public void setFile(UploadedFile file1) {
        this.file = file1;
    }

    public UploadedFile getFile() {
        return file;
    }
    
    public String uploadAttach() {
            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer bindings = bindingctx.getCurrentBindingsEntry();
            DCBindingContainer bindingsImpl = (DCBindingContainer)bindings;
            DCIteratorBinding iter = bindingsImpl.findIteratorBinding("FilesVO2Iterator");
            
            Row row = iter.getCurrentRow();
            row.setAttribute("OppId",OpId);
            row.setAttribute("FileName", getFile().getFilename());
            row.setAttribute("FileContent", createBlobDomain(getFile()));
            row.setAttribute("FileDescription", description);
           
            //Commit Transaction
            OperationBinding method = bindings.getOperationBinding("Commit");  
            method.execute(); 
            RichPopup rp = (RichPopup) component.getParent();
            rp.hide();
            
            return null;
        }
    
    private BlobDomain createBlobDomain(UploadedFile file) {
            InputStream in = null;
            BlobDomain blobDomain = null;
            OutputStream out = null;
            try {
                in = file.getInputStream();
                blobDomain = new BlobDomain();
                out = blobDomain.getBinaryOutputStream();
                byte[] buffer = new byte[8192];
                int bytesRead = 0;
                while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
            return blobDomain;
    }
    
    public void downloadBlobFile(FacesContext facesContext, OutputStream outputStream)  {         
         BindingContext bindingctx = BindingContext.getCurrent();
         BindingContainer bindings = bindingctx.getCurrentBindingsEntry();
         DCBindingContainer bindingsImpl = (DCBindingContainer)bindings;
         DCIteratorBinding iter = bindingsImpl.findIteratorBinding("FilesVO2Iterator");
         Row row = iter.getCurrentRow();
         BlobDomain blob = (BlobDomain) row.getAttribute("FileContent");
         if (blob != null) {
                 try  
                 {  // copy the data from the blobDomain to the output stream   
                   IOUtils.copy(blob.getInputStream(), outputStream);  
                   blob.closeInputStream();  
                   outputStream.flush();  
                 }  
                 catch (IOException e)  
                 {  
                   // handle errors  
                   e.printStackTrace();  
                   FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");  
                   FacesContext.getCurrentInstance().addMessage(null, msg);  
                 }  
             }
    }  

    public void setOpId(String OpId) {
        this.OpId = OpId;
    }

    public String getOpId() {
        return OpId;
    }

    public void setComponent(RichDialog component) {
        this.component = component;
    }

    public RichDialog getComponent() {
        return component;
    }

    public void setList(List<UploadedFile> list) {
        this.list = list;
        this.file=list.get(0);
    }

    public List<UploadedFile> getList() {
        return list;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
