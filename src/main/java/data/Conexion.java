package data;

import java.sql.*;

public class Conexion {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/db_cac_java?useTimeZone=true&serverTimeZone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER, PASS);
    }

    public static void close(ResultSet rs) {
       try{
           rs.close();
       }catch(SQLException e){
           System.out.println(System.out);
       }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(System.out);
        }
    }

    public static void close(Connection conn)  {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(System.out);
        }
    }
}