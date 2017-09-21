/*
 * To assnge this license header, choose License Headers in Project Properties.
 * To assnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.AssignamentTaskDao;
import Model.AssignamentTask;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AssignamentTaskBean {
    
    private AssignamentTask assignamentTask = new AssignamentTask();
    private List<AssignamentTask> lstAssignamentTask;

    public AssignamentTask getAssignamentTask() {
        return assignamentTask;
    }

    public void setAssignamentTask(AssignamentTask assignamentTask) {
        this.assignamentTask = assignamentTask;
    }

    public List<AssignamentTask> getLstAssignamentTask() {
        return lstAssignamentTask;
    }

    public void setLstAssignamentTask(List<AssignamentTask> lstAssignamentTask) {
        this.lstAssignamentTask = lstAssignamentTask;
    }

    public void registrar() throws Exception{
        AssignamentTaskDao dao;
    try{
        dao = new AssignamentTaskDao();
        dao.registrar(assignamentTask);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        AssignamentTaskDao dao;
    try{
        dao = new AssignamentTaskDao();
        lstAssignamentTask = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(AssignamentTask ass) throws Exception{
         AssignamentTaskDao dao;
         AssignamentTask temp;
    try{
        dao = new AssignamentTaskDao();
        temp = dao.leerId(ass);
        
        if(temp !=null){
            this.assignamentTask = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        AssignamentTaskDao dao;
    try{
        dao = new AssignamentTaskDao();
        dao.modificar(assignamentTask);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(AssignamentTask ass) throws Exception{
        AssignamentTaskDao dao;
    try{
        dao = new AssignamentTaskDao();
        dao.eliminar(ass);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}