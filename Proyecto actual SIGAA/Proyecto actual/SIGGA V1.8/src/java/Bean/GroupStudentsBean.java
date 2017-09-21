/*
 * To gronge this license header, choose License Headers in Project Properties.
 * To gronge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.GroupStudentsDao;
import Model.GroupStudents;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class GroupStudentsBean {
    
    private GroupStudents groupStudents = new GroupStudents();
    private List<GroupStudents> lstGroupStudents;
    private List<SelectItem> list;
    
     public List<SelectItem> getList() throws Exception {
        GroupStudentsDao dao=new GroupStudentsDao();
        list=new ArrayList<SelectItem>();
        groupStudents=new GroupStudents();
        lstGroupStudents=dao.listar();
        list.clear();
        for(GroupStudents es:lstGroupStudents){
            SelectItem item=new SelectItem(es.getIdGroup());
            list.add(item);
        }
        return list;
    }
    

    public GroupStudentsBean() {
        try{this.listar();
        }catch(Exception e){}
    }

    public GroupStudents getGroupStudents() {
        return groupStudents;
    }

    public void setGroupStudents(GroupStudents groupStudents) {
        this.groupStudents = groupStudents;
    }

    public List<GroupStudents> getLstGroupStudents() {
        return lstGroupStudents;
    }

    public void setLstGroupStudents(List<GroupStudents> lstGroupStudents) {
        this.lstGroupStudents = lstGroupStudents;
    }

    public void registrar() throws Exception{
        GroupStudentsDao dao;
    try{
        dao = new GroupStudentsDao();
        dao.registrar(groupStudents);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        GroupStudentsDao dao;
    try{
        dao = new GroupStudentsDao();
        lstGroupStudents = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(GroupStudents gro) throws Exception{
         GroupStudentsDao dao;
         GroupStudents temp;
    try{
        dao = new GroupStudentsDao();
        temp = dao.leerId(gro);
        
        if(temp !=null){
            this.groupStudents = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        GroupStudentsDao dao;
    try{
        dao = new GroupStudentsDao();
        dao.modificar(groupStudents);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(GroupStudents gro) throws Exception{
        GroupStudentsDao dao;
    try{
        dao = new GroupStudentsDao();
        dao.eliminar(gro);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}