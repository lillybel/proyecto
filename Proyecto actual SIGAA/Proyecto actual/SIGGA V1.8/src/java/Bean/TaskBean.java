/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.TaskDao;
import Model.Task;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TaskBean {
    
    private Task task = new Task();
    private List<Task> lstTask;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Task> getLstTask() {
        return lstTask;
    }

    public void setLstTask(List<Task> lstTask) {
        this.lstTask = lstTask;
    }

    
    public void registrar() throws Exception{
        TaskDao dao;
    try{
        dao = new TaskDao();
        dao.registrar(task);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        TaskDao dao;
    try{
        dao = new TaskDao();
        lstTask = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Task tk) throws Exception{
         TaskDao dao;
         Task temp;
    try{
        dao = new TaskDao();
        temp = dao.leerId(tk);
        
        if(temp !=null){
            this.task = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        TaskDao dao;
    try{
        dao = new TaskDao();
        dao.modificar(task);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Task tk) throws Exception{
        TaskDao dao;
    try{
        dao = new TaskDao();
        dao.eliminar(tk);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}