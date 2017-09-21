/*
 * To gronge this license header, choose License Headers in Project Progroties.
 * To gronge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.GroupStudents;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class GroupStudentsDao extends Dao{
    public void registrar(GroupStudents gro) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO GroupStudents (IdGroup,IdState,IdProgram) values(?,?,?)");
        st.setInt(1, gro.getIdGroup());
        st.setInt(2, gro.getIdState());
        st.setInt(3, gro.getIdProgram());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<GroupStudents> listar() throws Exception{
        List<GroupStudents> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdGroup, IdState, IdProgram FROM GroupStudents");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                GroupStudents gro = new GroupStudents();
                gro.setIdGroup(rs.getInt("IdGroup"));
                gro.setIdState(rs.getInt("IdState"));
                gro.setIdProgram(rs.getInt("IdProgram"));
                lista.add(gro);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public GroupStudents leerId(GroupStudents gro) throws Exception{
        GroupStudents ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdGroup, IdState, IdProgram FROM GroupStudents where IdGroup=?");
        st.setInt(1, gro.getIdGroup());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new GroupStudents();
            ests.setIdGroup(rs.getInt("IdGroup"));
            ests.setIdState(rs.getInt("IdState"));
            ests.setIdProgram(rs.getInt("IdProgram"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(GroupStudents gro) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE GroupStudents SET IdState = ? , IdProgram = ? WHERE IdGroup=?" );
        
        st.setInt(1, gro.getIdState());
        st.setInt(2, gro.getIdProgram());
        st.setInt(3, gro.getIdGroup());
        
        
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(GroupStudents gro) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM GroupStudents WHERE IdGroup = ?" );
        
      
        st.setInt(1, gro.getIdGroup());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
