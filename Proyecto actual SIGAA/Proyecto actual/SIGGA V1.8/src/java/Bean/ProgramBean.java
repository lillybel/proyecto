/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DaoConexion.ProgramDao;
import Model.Program;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class ProgramBean {
    private Program program = new Program();
    private List<Program> lstProgram;
    private List<SelectItem> list;

    public List<SelectItem> getList() throws Exception {
        ProgramDao dao=new ProgramDao();
        list=new ArrayList<SelectItem>();
        program=new Program();
        lstProgram=dao.listar();
        list.clear();
        for(Program es:lstProgram){
            SelectItem item=new SelectItem(es.getIdProgram(),es.getNameProgram());
            list.add(item);
        }
        return list;
    }
    

    public ProgramBean() {
        try{this.listar();
        }catch(Exception e){}
    }

    
    public List<Program> getLstProgram() {
        return lstProgram;
    }

    public void setLstProgram(List<Program> lstProgram) {
        this.lstProgram = lstProgram;
    }

  
    

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    
    
    public void registrar() throws Exception{
        ProgramDao dao;
    try{
        dao = new ProgramDao();
        dao.registrar(program);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        ProgramDao dao;
    try{
        dao = new ProgramDao();
        lstProgram = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Program prg) throws Exception{
         ProgramDao dao;
         Program temp;
    try{
        dao = new ProgramDao();
        temp = dao.leerId(prg);
        
        if(temp !=null){
            this.program = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        ProgramDao dao;
    try{
        dao = new ProgramDao();
        dao.modificar(program);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Program prg) throws Exception{
        ProgramDao dao;
    try{
        dao = new ProgramDao();
        dao.eliminar(prg);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
    
}
