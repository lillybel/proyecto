/*
 * To pernge this license header, choose License Headers in Project Properties.
 * To pernge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.ResultLearning;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 
public class ResultLearningDao extends Dao{
    public void registrar(ResultLearning per) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO ResultLearning (IdResultLearning, NameResultLearning,StartDate,EndDate,IdState,IdProgram) values(?,?,?,?,?,?)");
        st.setInt(1, per.getIdResultLearning());
        st.setString(2, per.getNameResultLearning());
        st.setDate(3,per.getStartDate());
        st.setDate(4, per.getEndDate());
        st.setInt(5, per.getIdState());
        st.setInt(6, per.getIdProgram());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<ResultLearning> listar() throws Exception{
        List<ResultLearning> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdResultLearning, NameResultLearning, StartDate, EndDate, IdState, IdProgram FROM ResultLearning");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ResultLearning rl = new ResultLearning();
                rl.setIdResultLearning(rs.getInt("IdResultLearning"));
                rl.setNameResultLearning(rs.getString("NameResultLearning"));
                rl.setStartDate(rs.getDate("StartDate"));
                rl.setEndDate(rs.getDate("EndDate"));
                rl.setIdState(rs.getInt("IdState"));
                rl.setIdProgram(rs.getInt("IdProgram"));               
               
                lista.add(rl);
                
            
            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public ResultLearning leerId(ResultLearning rl) throws Exception{
        ResultLearning rll = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdResultLearning, NameResultLearning, StartDate, EndDate, IdState, IdProgram FROM ResultLearning where IdResultLearning=?");
        st.setInt(1, rl.getIdResultLearning());
        rs = st.executeQuery();
        while(rs.next()){
            rll = new ResultLearning();
            rll.setIdResultLearning(rs.getInt("IdResultLearning"));
            rll.setNameResultLearning(rs.getString("NameResultLearning"));
            rll.setStartDate(rs.getDate("StartDate"));            
            rll.setEndDate(rs.getDate("EndDate"));            
            rll.setIdState(rs.getInt("IdState"));
            rll.setIdProgram(rs.getInt("IdProgram"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return rll;
    }
       public void modificar(ResultLearning rl) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("UPDATE ResultLearning SET NameResultLearning = ?, StartDate = ?, EndDate = ?, IdState = ?, IdProgram WHERE IdResultLearning = ?" );
        
        st.setString(1, rl.getNameResultLearning());
        st.setDate(2, rl.getStartDate());
        st.setDate(3, rl.getStartDate());
        st.setInt(4, rl.getIdState());
        st.setInt(4, rl.getIdProgram());
        st.setInt(5, rl.getIdResultLearning());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(ResultLearning per) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM ResultLearning WHERE IdResultLearning = ?" );
        
      
        st.setInt(1, per.getIdResultLearning());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
}
