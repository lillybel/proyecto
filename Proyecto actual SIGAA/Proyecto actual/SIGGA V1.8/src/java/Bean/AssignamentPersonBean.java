/*
 * To aspnge this license header, choose License Headers in Project Properties.
 * To aspnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.AssignamentPersonDao;
import Model.AssignamentPerson;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AssignamentPersonBean {
    
    private AssignamentPerson assignamentPerson = new AssignamentPerson();
    private List<AssignamentPerson> lstAssignamentPerson;

    public AssignamentPerson getAssignamentPerson() {
        return assignamentPerson;
    }

    public void setAssignamentPerson(AssignamentPerson assignamentPerson) {
        this.assignamentPerson = assignamentPerson;
    }

    public List<AssignamentPerson> getLstAssignamentPerson() {
        return lstAssignamentPerson;
    }

    public void setLstAssignamentPerson(List<AssignamentPerson> lstAssignamentPerson) {
        this.lstAssignamentPerson = lstAssignamentPerson;
    }

    public void registrar() throws Exception{
        AssignamentPersonDao dao;
    try{
        dao = new AssignamentPersonDao();
        dao.registrar(assignamentPerson);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        AssignamentPersonDao dao;
    try{
        dao = new AssignamentPersonDao();
        lstAssignamentPerson = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(AssignamentPerson asp) throws Exception{
         AssignamentPersonDao dao;
         AssignamentPerson temp;
    try{
        dao = new AssignamentPersonDao();
        temp = dao.leerId(asp);
        
        if(temp !=null){
            this.assignamentPerson = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        AssignamentPersonDao dao;
    try{
        dao = new AssignamentPersonDao();
        dao.modificar(assignamentPerson);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(AssignamentPerson asp) throws Exception{
        AssignamentPersonDao dao;
    try{
        dao = new AssignamentPersonDao();
        dao.eliminar(asp);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}