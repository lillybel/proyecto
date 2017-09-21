/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserDao {
      public static boolean login(String UserPerson, String PasswordPerson) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
             con = Dao.getConnection();
            ps = con.prepareStatement("select UserPerson, PasswordPerson from Person where UserPerson= ? and PasswordPerson= ? ");
            ps.setString(1, UserPerson);
            ps.setString(2, PasswordPerson);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("UserPerson"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error al iniciar sesión() -->" + ex.getMessage());
            return false;
        } finally {
            Dao.close(con);
        }
    }
    
}
