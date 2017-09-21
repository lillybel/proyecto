/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DaoConexion.ChargePersonDao;
import Model.ChargePerson;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class ChargePersonBean {
     private ChargePerson chargeperson = new ChargePerson();
    private List<ChargePerson> lstChargePerson;
    private List<SelectItem> list;

 

    public ChargePersonBean() {
        try{this.listar();
        }catch(Exception e){}
    }

    
    public List<ChargePerson> getLstChargePerson() {
        return lstChargePerson;
    }

    public void setLstChargePerson(List<ChargePerson> lstChargePerson) {
        this.lstChargePerson = lstChargePerson;
    }

  
    

    public ChargePerson getChargePerson() {
        return chargeperson;
    }

    public void setChargePerson(ChargePerson chargeperson) {
        this.chargeperson = chargeperson;
    }
    
    
    public void registrar() throws Exception{
        ChargePersonDao dao;
    try{
        dao = new ChargePersonDao();
        dao.registrar(chargeperson);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        ChargePersonDao dao;
    try{
        dao = new ChargePersonDao();
        lstChargePerson = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(ChargePerson chg) throws Exception{
         ChargePersonDao dao;
         ChargePerson temp;
    try{
        dao = new ChargePersonDao();
        temp = dao.leerId(chg);
        
        if(temp !=null){
            this.chargeperson = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        ChargePersonDao dao;
    try{
        dao = new ChargePersonDao();
        dao.modificar(chargeperson);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(ChargePerson chg) throws Exception{
        ChargePersonDao dao;
    try{
        dao = new ChargePersonDao();
        dao.eliminar(chg);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
    
}
