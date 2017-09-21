
package DaoConexion;

import DaoConexion.Dao;
import Model.Task;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class TaskDao extends Dao {
    public void registrar(Task tk) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO task ( NameTask, IdState) values(?,?)");
        
        st.setString(1, tk.getNameTask());
        st.setInt(2, tk.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Task> listar() throws Exception{
        List<Task> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdTask, NameTask, IdState FROM task");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Task tk = new Task();
                tk.setIdTask(rs.getInt("IdTask"));
                tk.setNameTask(rs.getString("NameTask"));
                tk.setIdState(rs.getInt("IdState"));
                lista.add(tk);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Task leerId(Task tk) throws Exception{
        Task ests = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT NameTask, IdState FROM task where IdTask=?");
        st.setInt(1, tk.getIdTask());
        rs = st.executeQuery();
        while(rs.next()){
            ests = new Task();
            ests.setNameTask(rs.getString("NameTask"));
            ests.setIdState(rs.getInt("IdState"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return ests;
    }
       public void modificar(Task tk) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE task SET NameTask = ? IdState = ? WHERE IdTask = ?" );
        
        st.setString(1, tk.getNameTask());
        st.setInt(2, tk.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Task tk) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM task WHERE IdTask = ?" );
        
      
        st.setInt(1, tk.getIdTask());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }

}
