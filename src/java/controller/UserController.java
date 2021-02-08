    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Users;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nick
 */
@ManagedBean
@SessionScoped
public class UserController {
    private Users usr = new Users();

    public Users getUsr() {
        return usr;
    }

    public void setUsr(Users usr) {
        this.usr = usr;
    }
    
    public void login() {
	        
	        FacesContext context = FacesContext.getCurrentInstance();

	        if(usr.getUsername().equals("admin") && usr.getPassword().equals("admin")){
	            context.getExternalContext().getSessionMap().put("user", usr.getUsername());
	            try {
                           
					context.getExternalContext().redirect("admindashboard.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        else  {
	            context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));

	        } 
	    }

	    public void logout() {
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	context.getExternalContext().invalidateSession();
	        try {
                     HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                     hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                     hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                     hsr.setDateHeader("Expires", 0);
				context.getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
}
