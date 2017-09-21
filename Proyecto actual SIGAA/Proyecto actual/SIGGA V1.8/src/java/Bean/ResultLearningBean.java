/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.ResultLearningDao;
import Model.ResultLearning;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class ResultLearningBean {
    
    private ResultLearning person = new ResultLearning();
    private List<ResultLearning> lstResultLearning;
    private List<SelectItem> list;
    
        public List<SelectItem> getList() throws Exception {
        ResultLearningDao dao=new ResultLearningDao();
        list=new ArrayList<SelectItem>();
        person=new ResultLearning();
        lstResultLearning=dao.listar();
        list.clear();
        for(ResultLearning es:lstResultLearning){
            SelectItem item=new SelectItem(es.getIdResultLearning(),es.getNameResultLearning());
            list.add(item);
        }
        return list;
    }
    

    public ResultLearningBean() {
        try{this.listar();
        }catch(Exception e){}
    }


    public ResultLearning getResultLearning() {
        return person;
    }

    public void setResultLearning(ResultLearning person) {
        this.person = person;
    }

    public List<ResultLearning> getLstResultLearning() {
        return lstResultLearning;
    }

    public void setLstResultLearning(List<ResultLearning> lstResultLearning) {
        this.lstResultLearning = lstResultLearning;
    }

    public void registrar() throws Exception{
        ResultLearningDao dao;
    try{
        dao = new ResultLearningDao();
        dao.registrar(person);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        ResultLearningDao dao;
    try{
        dao = new ResultLearningDao();
        lstResultLearning = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(ResultLearning per) throws Exception{
         ResultLearningDao dao;
         ResultLearning temp;
    try{
        dao = new ResultLearningDao();
        temp = dao.leerId(per);
        
        if(temp !=null){
            this.person = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        ResultLearningDao dao;
    try{
        dao = new ResultLearningDao();
        dao.modificar(person);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(ResultLearning per) throws Exception{
        ResultLearningDao dao;
    try{
        dao = new ResultLearningDao();
        dao.eliminar(per);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}