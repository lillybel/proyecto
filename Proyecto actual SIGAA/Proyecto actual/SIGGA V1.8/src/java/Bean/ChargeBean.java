/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.ChargeDao;
import Model.Charge;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class ChargeBean {
    
    private Charge charge = new Charge();
    private List<Charge> lstCharge;
    private List<SelectItem> list;
    
        public List<SelectItem> getList() throws Exception {
        ChargeDao dao=new ChargeDao();
        list=new ArrayList<SelectItem>();
        charge=new Charge();
        lstCharge=dao.listar();
        list.clear();
        for(Charge es:lstCharge){
            SelectItem item=new SelectItem(es.getIdCharge(),es.getNameCharge());
            list.add(item);
        }
        return list;
    }
    

    public ChargeBean() {
        try{this.listar();
        }catch(Exception e){}
    }


    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public List<Charge> getLstCharge() {
        return lstCharge;
    }

    public void setLstCharge(List<Charge> lstCharge) {
        this.lstCharge = lstCharge;
    }

    public void registrar() throws Exception{
        ChargeDao dao;
    try{
        dao = new ChargeDao();
        dao.registrar(charge);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        ChargeDao dao;
    try{
        dao = new ChargeDao();
        lstCharge = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Charge cha) throws Exception{
         ChargeDao dao;
         Charge temp;
    try{
        dao = new ChargeDao();
        temp = dao.leerId(cha);
        
        if(temp !=null){
            this.charge = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        ChargeDao dao;
    try{
        dao = new ChargeDao();
        dao.modificar(charge);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Charge cha) throws Exception{
        ChargeDao dao;
    try{
        dao = new ChargeDao();
        dao.eliminar(cha);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}