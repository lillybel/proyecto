/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DaoConexion.UserDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String PasswordPerson;
    private String message, UserPerson;
 

    public String getPasswordPerson() {
        return PasswordPerson;
    }

    public void setPasswordPerson(String PasswordPerson) {
        this.PasswordPerson = PasswordPerson;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserPerson() {
        return UserPerson;
    }

    public void setUserPerson(String UserPerson) {
        this.UserPerson = UserPerson;
    }
    
 
 
    public String loginProject() {
        boolean result = UserDao.login(UserPerson, PasswordPerson);
        if (result) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("UserPerson", UserPerson);
 
            return "admin";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Contraseña o Usuario Incorrectos!",
                    "Por Favor intenta nuevamente!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "index";
        }
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "index";
   }
}
