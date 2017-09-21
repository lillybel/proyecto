/*
 * To appnge this license header, choose License Headers in Project Proappties.
 * To appnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.Apprentice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class ApprenticeDao extends Dao{
    public void registrar(Apprentice app) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Apprentice (IdApprentice, NameApprentice,IdState,IdGroup) values(?,?,?,?)");
        st.setInt(1, app.getIdApprentice());
        st.setString(2, app.getNameApprentice());
        st.setInt(3, app.getIdState());
        st.setInt(4, app.getIdGroup());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Apprentice> listar() throws Exception{
        List<Apprentice> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdApprentice, NameApprentice, IdState, IdGroup FROM Apprentice");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Apprentice app = new Apprentice();
                app.setIdApprentice(rs.getInt("IdApprentice"));
                app.setNameApprentice(rs.getString("NameApprentice"));
                app.setIdState(rs.getInt("IdState"));
                app.setIdGroup(rs.getInt("IdGroup"));
                lista.add(app);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Apprentice leerId(Apprentice app) throws Exception{
        Apprentice ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdApprentice, NameApprentice, IdState, IdGroup FROM Apprentice where IdApprentice=?");
        st.setInt(1, app.getIdApprentice());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new Apprentice();
            ests.setIdApprentice(rs.getInt("IdApprentice"));
            ests.setNameApprentice(rs.getString("NameApprentice"));
            ests.setIdState(rs.getInt("IdState"));
            ests.setIdGroup(rs.getInt("IdGroup"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(Apprentice app) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE Apprentice SET NameApprentice = ? , IdState = ? , IdGroup = ? WHERE IdApprentice = ?" );
        
        st.setString(1, app.getNameApprentice());
        st.setInt(2, app.getIdState());
        st.setInt(3, app.getIdGroup());
        st.setInt(4, app.getIdApprentice());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Apprentice app) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Apprentice WHERE IdApprentice = ?" );
        
      
        st.setInt(1, app.getIdApprentice());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
