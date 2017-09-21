package DaoConexion;

import DaoConexion.Dao;
import Model.State;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StateDao extends Dao {
     public void registrar(State est) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO State (IdState, NameState) values(?,?)");
        st.setLong(1, est.getIdState());
        st.setString(2, est.getNameState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<State> listar() throws Exception{
        List<State> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdState, NameState FROM State");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                State est = new State();
                est.setIdState(rs.getInt("IdState"));
                est.setNameState(rs.getString("NameState"));
                lista.add(est);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public State leerId(State est) throws Exception{
        State ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdState, NameState FROM State where IdState=?");
        st.setLong(1, est.getIdState());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new State();
            ests.setIdState(rs.getInt("IdState"));
            ests.setNameState(rs.getString("NameState"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(State est) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE State SET NameState = ? WHERE IdState = ?" );
        
        st.setString(1, est.getNameState());
        st.setInt(2, est.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(State est) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM State WHERE IdState = ?" );
        
      
        st.setInt(1, est.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    
}
