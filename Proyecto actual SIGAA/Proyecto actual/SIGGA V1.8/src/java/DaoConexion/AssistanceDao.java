/*
 * To assnge this license header, choose License Headers in Project Proassties.
 * To assnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.Assistance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class AssistanceDao extends Dao{
    public void registrar(Assistance ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Assistance (IdAssitenace, Kind, Datea, IdApprentice) values(?,?,?,?)");
        st.setInt(1, ass.getIdAssitenace());
        st.setString(2, ass.getKind());
        st.setDate(3, ass.getDatea());
        st.setInt(4, ass.getIdApprentice());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Assistance> listar() throws Exception{
        List<Assistance> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdAssitenace, Kind FROM Assistance");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Assistance ass = new Assistance();
                ass.setIdAssitenace(rs.getInt("IdAssitenace"));
                ass.setKind(rs.getString("Kind"));
                lista.add(ass);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Assistance leerId(Assistance ass) throws Exception{
        Assistance ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdAssitenace, Kind FROM Assistance where IdAssitenace=?");
        st.setInt(1, ass.getIdAssitenace());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new Assistance();
            ests.setIdAssitenace(rs.getInt("IdAssitenace"));
            ests.setKind(rs.getString("Kind"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(Assistance ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE Assistance SET Kind = ? WHERE IdAssitenace = ?" );
        
        st.setString(1, ass.getKind());
        st.setInt(2, ass.getIdAssitenace());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Assistance ass) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Assistance WHERE IdAssitenace = ?" );
        
      
        st.setInt(1, ass.getIdAssitenace());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
