/*
 * To pernge this license header, choose License Headers in Project Properties.
 * To pernge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class PersonDao extends Dao{
    
    public void registrar(Person per) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Person (IdPerson, NamePerson, UserPerson, PasswordPerson, Email, IdState) values(?,?,?,?,?,?)");
        st.setInt(1, per.getIdPerson());
        st.setString(2, per.getNamePerson());
        st.setString(3, per.getUserPerson());
        st.setString(4, per.getPasswordPerson());
        st.setString(5, per.getEmail());
        st.setInt(6, per.getIdState());
        st.executeUpdate();
        
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Person> listar() throws Exception{
        List<Person> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdPerson, NamePerson, PasswordPerson, Email, IdState, UserPerson FROM Person");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Person per = new Person();
                per.setIdPerson(rs.getInt("IdPerson"));
                per.setNamePerson(rs.getString("NamePerson"));
                per.setUserPerson(rs.getString("UserPerson"));
                per.setPasswordPerson(rs.getString("PasswordPerson"));
                per.setEmail(rs.getString("Email"));
                per.setIdState(rs.getInt("IdState"));
                
               
                lista.add(per);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Person leerId(Person per) throws Exception{
        Person ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdPerson, NamePerson,UserPerson, PasswordPerson, Email, IdState  FROM Person where IdPerson=?");
        st.setInt(1, per.getIdPerson());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new Person();
            ests.setIdPerson(rs.getInt("IdPerson"));
            ests.setNamePerson(rs.getString("NamePerson"));
            ests.setUserPerson(rs.getString("UserPerson"));
            ests.setPasswordPerson(rs.getString("PasswordPerson"));
            ests.setEmail(rs.getString("Email"));
            ests.setIdState(rs.getInt("IdState"));
            
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(Person per) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE Person SET NamePerson = ?,  UserPerson = ?, PasswordPerson = ?, Email = ?, idState = ? WHERE IdPerson = ?" );
        
        st.setString(1, per.getNamePerson()); 
        st.setString(2, per.getUserPerson());
        st.setString(3, per.getPasswordPerson());
        st.setString(4, per.getEmail());
        st.setInt(5, per.getIdState());
        st.setInt(6, per.getIdPerson());
       
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Person per) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Person WHERE IdPerson = ?" );
        
      
        st.setInt(1, per.getIdPerson());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
