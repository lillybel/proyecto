/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DaoConexion.PersonDao;
import Model.Person;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class PersonBean {
    
    private Person person = new Person();
    private List<Person> lstPerson;
    private List<SelectItem> list;
    
        public List<SelectItem> getList() throws Exception {
        PersonDao dao=new PersonDao();
        list=new ArrayList<SelectItem>();
        person=new Person();
        lstPerson=dao.listar();
        list.clear();
        for(Person es:lstPerson){
            SelectItem item=new SelectItem(es.getIdPerson(),es.getNamePerson());
            list.add(item);
        }
        return list;
    }
    

    public PersonBean() {
        try{this.listar();
        }catch(Exception e){}
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getLstPerson() {
        return lstPerson;
    }

    public void setLstPerson(List<Person> lstPerson) {
        this.lstPerson = lstPerson;
    }

    public void registrar() throws Exception{
        PersonDao dao;
    try{
        dao = new PersonDao();
        dao.registrar(person);
    }catch(Exception e){
        throw e;
    }
    }
     public void listar() throws Exception{
        PersonDao dao;
    try{
        dao = new PersonDao();
        lstPerson = dao.listar();
    }catch(Exception e){
        throw e;
    }
    }
      public void leerID(Person per) throws Exception{
         PersonDao dao;
         Person temp;
    try{
        dao = new PersonDao();
        temp = dao.leerId(per);
        
        if(temp !=null){
            this.person = temp;
        }
    }catch(Exception e){
        throw e;
    }
    }
       public void modificar() throws Exception{
        PersonDao dao;
    try{
        dao = new PersonDao();
        dao.modificar(person);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
       public void eliminar(Person per) throws Exception{
        PersonDao dao;
    try{
        dao = new PersonDao();
        dao.eliminar(per);
        this.listar();
    }catch(Exception e){
        throw e;
    }
    }
}