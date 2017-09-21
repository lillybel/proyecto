/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.AssignamentPerson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 

public class AssignamentPersonDao extends Dao{
    public void registrar(AssignamentPerson asp) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO AssignamentPerson (IdProgram, IdPerson) values(?,?)");
        st.setInt(1, asp.getIdProgram());
        st.setInt(2, asp.getIdPerson());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<AssignamentPerson> listar() throws Exception{
        List<AssignamentPerson> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdProgram, IdPerson FROM AssignamentPerson");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                AssignamentPerson asp = new AssignamentPerson();
                asp.setIdProgram(rs.getInt("IdProgram"));
                asp.setIdPerson(rs.getInt("IdPerson"));
                lista.add(asp);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public AssignamentPerson leerId(AssignamentPerson asp) throws Exception{
        AssignamentPerson ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdProgram, IdPerson FROM AssignamentPerson where IdProgram=?");
        st.setInt(1, asp.getIdProgram());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new AssignamentPerson();
            ests.setIdProgram(rs.getInt("IdProgram"));
            ests.setIdPerson(rs.getInt("IdPerson"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(AssignamentPerson asp) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE AssignamentPerson SET IdPerson = ? WHERE IdProgram = ?" );
        
        st.setInt(1, asp.getIdProgram());
        st.setInt(2, asp.getIdPerson());
        
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(AssignamentPerson asp) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM AssignamentPerson WHERE IdProgram = ?" );
        
      
        st.setInt(1, asp.getIdProgram());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    
}
