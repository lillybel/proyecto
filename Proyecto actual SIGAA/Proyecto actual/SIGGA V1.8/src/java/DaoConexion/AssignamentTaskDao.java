/*
 * To assnge this license header, choose License Headers in Project Proassties.
 * To assnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.AssignamentTask;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class AssignamentTaskDao extends Dao{
    public void registrar(AssignamentTask ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO AssignamentTask (IdTask, IdPerson) values(?,?)");
        st.setInt(1, ass.getIdTask());
        st.setInt(2, ass.getIdPerson());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<AssignamentTask> listar() throws Exception{
        List<AssignamentTask> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdTask, IdPerson FROM AssignamentTask");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                AssignamentTask ass = new AssignamentTask();
                ass.setIdTask(rs.getInt("IdTask"));
                ass.setIdPerson(rs.getInt("IdPerson"));
                lista.add(ass);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public AssignamentTask leerId(AssignamentTask ass) throws Exception{
        AssignamentTask ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdTask, IdPerson FROM AssignamentTask where IdTask=?");
        st.setInt(1, ass.getIdTask());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new AssignamentTask();
            ests.setIdTask(rs.getInt("IdTask"));
            ests.setIdPerson(rs.getInt("IdPerson"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(AssignamentTask ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE AssignamentTask SET IdPerson = ? WHERE IdTask = ?" );
        
        st.setInt(1, ass.getIdPerson());
        st.setInt(2, ass.getIdTask());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(AssignamentTask ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM AssignamentTask WHERE IdTask = ?" );
        
      
        st.setInt(1, ass.getIdTask());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
