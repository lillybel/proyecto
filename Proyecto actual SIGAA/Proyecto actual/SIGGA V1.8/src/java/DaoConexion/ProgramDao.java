/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import Model.Program;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProgramDao extends Dao{
    
         public void registrar(Program prg) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Program (IdProgram, NameProgram, IdState) values(?,?,?)");
        st.setInt(1, prg.getIdProgram());
        st.setString(2, prg.getNameProgram());
        st.setInt(3, prg.getIdState());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    public List<Program> listar() throws Exception{
        List<Program> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdProgram, NameProgram, IdState FROM Program");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Program prg = new Program();
                prg.setIdProgram(rs.getInt("IdProgram"));
                prg.setNameProgram(rs.getString("NameProgram"));
                prg.setIdState(rs.getInt("IdState"));
                lista.add(prg);

            }
        }catch(Exception e){
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
     public Program leerId(Program prg) throws Exception{
        Program prgs = null;
        ResultSet rs;
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("SELECT IdProgram, NameProgram, IdState FROM Program where IdProgram=?");
        st.setLong(1, prg.getIdProgram());
        rs = st.executeQuery();
        while(rs.next()){
            prgs = new Program();
            prgs.setIdProgram(rs.getInt("IdProgram"));
            prgs.setNameProgram(rs.getString("NameProgram"));
             prgs.setIdState(rs.getInt("IdState"));
        }
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
    return prgs;
    }
       public void modificar(Program prg) throws Exception{
    try{
        this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("UPDATE Program SET NameProgram = ?, IdState = ? WHERE IdProgram = ?" );
        st.setString(1, prg.getNameProgram());
        st.setInt(2, prg.getIdState());
        st.setInt(3, prg.getIdProgram());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
       public void eliminar(Program prg) throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Program WHERE IdProgram = ?" );
        
      
        st.setInt(1, prg.getIdProgram());
        st.executeUpdate();
    }catch(Exception e){
        throw e;
    }finally{
        this.Cerrar();
    }
        }
    
    
    
}
