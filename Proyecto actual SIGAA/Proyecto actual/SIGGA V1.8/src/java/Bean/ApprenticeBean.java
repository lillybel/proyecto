/*
 * To appnge this license header, choose License Headers in Project Properties.
 * To appnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.ApprenticeDao;
import Model.Apprentice;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ApprenticeBean {
    
    private Apprentice apprentice = new Apprentice();
    private List<Apprentice> lstApprentice;

    public Apprentice getApprentice() {
        return apprentice;
    }

    public void setApprentice(Apprentice apprentice) {
        this.apprentice = apprentice;
    }

    public List<Apprentice> getLstApprentice() {
        return lstApprentice;
    }

    public void setLstApprentice(List<Apprentice> lstApprentice) {
        this.lstApprentice = lstApprentice;
    }

    public void registrar() throws Exception{
        ApprenticeDao dao;
    try{
        dao = new ApprenticeDao();
        dao.registrar(apprentice);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        ApprenticeDao dao;
    try{
        dao = new ApprenticeDao();
        lstApprentice = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Apprentice app) throws Exception{
         ApprenticeDao dao;
         Apprentice temp;
    try{
        dao = new ApprenticeDao();
        temp = dao.leerId(app);
        
        if(temp !=null){
            this.apprentice = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        ApprenticeDao dao;
    try{
        dao = new ApprenticeDao();
        dao.modificar(apprentice);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Apprentice app) throws Exception{
        ApprenticeDao dao;
    try{
        dao = new ApprenticeDao();
        dao.eliminar(app);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}