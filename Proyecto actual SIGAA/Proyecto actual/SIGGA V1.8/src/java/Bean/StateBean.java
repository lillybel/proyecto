package Bean;

import DaoConexion.StateDao;
import Model.State;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class StateBean {
    
    private State estado = new State();
    private List<State> lstState;
    private List<SelectItem> list;

    public List<SelectItem> getList() throws Exception {
        StateDao dao=new StateDao();
        list=new ArrayList<SelectItem>();
        estado=new State();
        lstState=dao.listar();
        list.clear();
        for(State es:lstState){
            SelectItem item=new SelectItem(es.getIdState(),es.getNameState());
            list.add(item);
        }
        return list;
    }
    public void info(){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registrado."));
    }

    public StateBean() {
        try{this.listar();
        }catch(Exception e){}
    }

    
    public List<State> getLstState() {
        return lstState;
    }

    public void setLstState(List<State> lstState) {
        this.lstState = lstState;
    }

  
    

    public State getState() {
        return estado;
    }

    public void setState(State estado) {
        this.estado = estado;
    }
    
    
    public void registrar() throws Exception{
        StateDao dao;
    try{
        dao = new StateDao();
        dao.registrar(estado);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Registrado el estado de: " + estado.getNameState()));
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        StateDao dao;
    try{
        dao = new StateDao();
        lstState = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(State est) throws Exception{
         StateDao dao;
         State temp;
    try{
        dao = new StateDao();
        temp = dao.leerId(est);
        
        if(temp !=null){
            this.estado = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        StateDao dao;
    try{
        dao = new StateDao();
        dao.modificar(estado);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(State est) throws Exception{
        StateDao dao;
    try{
        dao = new StateDao();
        dao.eliminar(est);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}
