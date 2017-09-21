
package DaoConexion;


import Model.ChargePerson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ChargePersonDao extends Dao {
    public void registrar(ChargePerson cgh) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO chargeperson (IdPerson, IdCharge) values(?,?)");
        st.setInt(1, cgh.getIdPerson());
        st.setInt(2, cgh.getIdCharge());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<ChargePerson> listar() throws Exception{
        List<ChargePerson> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdPerson, IdCharge FROM chargeperson");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ChargePerson cgh = new ChargePerson();
                cgh.setIdPerson(rs.getInt("IdPerson"));
                cgh.setIdCharge(rs.getInt("IdCharge"));
                lista.add(cgh);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public ChargePerson leerId(ChargePerson cgh) throws Exception{
        ChargePerson ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdPerson, IdCharge FROM chargeperson where IdPerson=?");
        st.setInt(1, cgh.getIdCharge());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new ChargePerson();
            ests.setIdCharge(rs.getInt("IdPerson"));
            ests.setIdPerson(rs.getInt("IdCharge"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(ChargePerson cgh) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE chargePerson SET IdCharge = ? WHERE IdPerson = ?" );       
        st.setInt(1, cgh.getIdCharge());
        st.setInt(2, cgh.getIdPerson());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(ChargePerson cgh) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM chargeperson WHERE IdPerson = ?" );
        
      
        st.setInt(1, cgh.getIdPerson());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }

    
}
