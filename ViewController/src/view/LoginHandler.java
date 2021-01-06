package view;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import weblogic.security.URLCallbackHandler;
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;

public class LoginHandler {
    private String _username;
    private String _password;


    public void setUsername(String _username) {
        this._username = _username;
    }
    public String getUsername() {
        return _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getPassword() {
        return _password;
    }
    
    public void doLogin(ActionEvent event) {
    FacesContext ctx = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)ctx.getExternalContext().getRequest();
    CallbackHandler handler = new URLCallbackHandler(_username, _password);
    try{
    Subject mySubject = Authentication.login(handler);
    ServletAuthentication.runAs(mySubject, request);
    ServletAuthentication.generateNewSessionID(request);
        String loginUrl="";
    if(_username.equals("admin"))
    {loginUrl = "/adfAuthentication?success_url=/faces/RolesView";}
    else if(_username.equals("user"))
        {loginUrl = "/adfAuthentication?success_url=/faces/sales";}  
        System.out.println();
    HttpServletResponse response = 
               (HttpServletResponse)ctx.getExternalContext().getResponse();
        sendForward(request, response, loginUrl);
    }catch(FailedLoginException e){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Incorrect Username or Password",
                                                "An incorrect Username or Password" +
                                                " was specified");
             ctx.addMessage(null, msg);
    }catch(LoginException e){
        reportUnexpectedLoginError("LoginException", e);
    }
    }
    
    public String onLogout() {

      FacesContext fctx = FacesContext.getCurrentInstance();

      ExternalContext ectx =
    fctx.getExternalContext();

      String url = ectx.getRequestContextPath()
    + 

                 "/adfAuthentication?logout=true&end_url=/faces/Login.jsf";     

      try {

        ectx.redirect(url);

      } catch (IOException e) {

        e.printStackTrace();

      }

      fctx.responseComplete();

      return null;

    }
    
    private void sendForward(HttpServletRequest request, 
                              HttpServletResponse response,
                              String forwardUrl){
       FacesContext ctx = FacesContext.getCurrentInstance();
       RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
       try {
         dispatcher.forward(request, response);
       } catch (ServletException se) {
         reportUnexpectedLoginError("ServletException", se);
       } catch (IOException ie) {
         reportUnexpectedLoginError("IOException", ie);
       }
       ctx.responseComplete();
     }
    
    private void reportUnexpectedLoginError(String errType, Exception e){
      FacesMessage msg =
        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unexpected error                                                        during login",
                         "Unexpected error during login (" + errType + 
                         "), please consult logs for detail");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      e.printStackTrace();
    }
}

