/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import DaoConexion.Dao;
import Model.Charge;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 

public class ChargeDao extends Dao {
    
     public void registrar(Charge cha) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Charge (IdCharge, NameCharge, IdState) values(?,?,?)");
        st.setInt(1, cha.getIdCharge());
        st.setString(2, cha.getNameCharge());
        st.setInt(3, cha.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Charge> listar() throws Exception{
        List<Charge> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdCharge, NameCharge, IdState FROM Charge");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Charge cha = new Charge();
                cha.setIdCharge(rs.getInt("IdCharge"));
                cha.setNameCharge(rs.getString("NameCharge"));
                cha.setIdState(rs.getInt("IdState"));
                lista.add(cha);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Charge leerId(Charge cha) throws Exception{
        Charge ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT NameCharge, IdState FROM Charge where IdCharge=?");
        st.setInt(1, cha.getIdCharge());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new Charge();
            ests.setNameCharge(rs.getString("NameCharge"));
            ests.setIdState(rs.getInt("IdState"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(Charge cha) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE Charge SET NameCharge = ?, IdState = ? WHERE IdCharge = ?" );
        
        st.setString(1, cha.getNameCharge());
        st.setInt(3, cha.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Charge cha) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Charge WHERE IdCharge = ?" );
        
      
        st.setInt(1, cha.getIdCharge());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    
}
