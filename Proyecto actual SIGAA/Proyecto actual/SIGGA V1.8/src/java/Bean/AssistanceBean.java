/*
 * To assnge this license header, choose License Headers in Project Properties.
 * To assnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.AssistanceDao;
import Model.Assistance;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AssistanceBean {
    
    private Assistance assistance = new Assistance();
    private List<Assistance> lstAssistance;

    public Assistance getAssistance() {
        return assistance;
    }

    public void setAssistance(Assistance assistance) {
        this.assistance = assistance;
    }

    public List<Assistance> getLstAssistance() {
        return lstAssistance;
    }

    public void setLstAssistance(List<Assistance> lstAssistance) {
        this.lstAssistance = lstAssistance;
    }

    public void registrar() throws Exception{
        AssistanceDao dao;
    try{
        dao = new AssistanceDao();
        dao.registrar(assistance);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        AssistanceDao dao;
    try{
        dao = new AssistanceDao();
        lstAssistance = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Assistance ass) throws Exception{
         AssistanceDao dao;
         Assistance temp;
    try{
        dao = new AssistanceDao();
        temp = dao.leerId(ass);
        
        if(temp !=null){
            this.assistance = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        AssistanceDao dao;
    try{
        dao = new AssistanceDao();
        dao.modificar(assistance);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Assistance ass) throws Exception{
        AssistanceDao dao;
    try{
        dao = new AssistanceDao();
        dao.eliminar(ass);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}