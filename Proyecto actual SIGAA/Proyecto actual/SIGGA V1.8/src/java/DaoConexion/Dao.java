
package DaoConexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {
    
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    public void Conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdaprendices?user=root&password=teamomicarcel29");

        }catch(Exception e){
        throw e;
        }
        }
    public void Cerrar() throws Exception{
                 try{
                     if(cn != null){
                     if(cn.isClosed() == false){
                                    cn.close();
                                        }
                            }
                    }catch(Exception e){
                        throw e;
                        }
        }
      public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdaprendices",
                    "root","teamomicarcel29");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    
}
