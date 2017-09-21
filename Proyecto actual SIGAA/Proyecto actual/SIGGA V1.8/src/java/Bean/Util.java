/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

 
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
 
public class Util {
 
      public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
      }
       
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }
 
      public static String getUserPerson()
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("UserPerson").toString();
      }
       
      public static String getIdPerson()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("IdPerson");
        else
            return null;
      }
}
