package data;

import entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(username,password) VALUES (?,?)";
    private static final String SQL_UPDATE_PASSWORD = "UPDATE usuarios SET password = ? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";
    private static final String SQL_LOGIC_DELETE = "UPDATE usuarios SET baja=1 WHERE id=?";
    private static final String SQL_GET_USER_BY_ID = "SELECT username,password FROM usuarios WHERE id =?";

    public Usuario obtenerUsuarioPorId(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user = null;
        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new Usuario();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return user;

    }

    /**
     * Lista completamente los usuarios en la base de datos, incluye los que
     * tengan la baja lógica. Utilizado por los administradores.
     *
     * @return Retorna una lista de usuarios completa.
     */
    public List<Usuario> listarUsuariosAdmin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> list = new ArrayList<>();

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("baja")));
            }

            return list;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return list;
    }

    /**
     * Lista los usuarios que no esten dados de baja.
     *
     * @return Retorna una lista de Usuarios si la operacion se completo con
     * éxito, de lo contrario retorna un arreglo vacío.
     */
    public List<Usuario> listarUsuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> list = new ArrayList<>();

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }

            return list;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return list;
    }

    /**
     * Crea un usuario en la base de datos.
     *
     * @param user Recibe un usuario que contiene username y password
     * @return Retorna 1 si la operacion se completó correctamente, en caso
     * contrario retorna -1.
     */
    public int altaUsuario(Usuario user) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registrosInsertados;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            registrosInsertados = stmt.executeUpdate();

            return registrosInsertados;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return -1;
    }

    /**
     * Modifica el password de un usuario con un id determinado.
     *
     * @param id Id del usuario a modificar
     * @param password Nuevo password
     * @return Retorna 1 en caso de que la operacion se haya completado
     * correctamente, de lo contrario retorna -1.
     */
    public int modificarPassword(int id, String password) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int modificado;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_PASSWORD);
            stmt.setString(1, password);
            stmt.setInt(2, id);
            modificado = stmt.executeUpdate();

            return modificado;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return -1;
    }

    /**
     * Elimina un usuario de la base de datos. HARD DELETE
     *
     * @param id Id del usuario a eliminar.
     * @return Retorna 1 si la operación se completo con éxito, en caso
     * contrario retorna -1.
     */
    public int bajaUsuario(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return -1;
    }

    /**
     * Realiza una baja lógica de un usuario con el id especificado.
     *
     * @param id
     * @return Retorna 1 si la operación se completo correctamente, de lo
     * contrario retorna -1.
     */
    public int bajaLogicaUsuario(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int modificado;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_LOGIC_DELETE);
            stmt.setInt(1, id);
            modificado = stmt.executeUpdate();

            return modificado;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return -1;
    }
}

/*TEMPLATE METODO
    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
    try{
    conn = Conexion.openConnection();
    stmt = conn.prepareStatement(SQL_SELECT_ALL);
    rs = stmt.executeQuery();
    
    *CODIGO ACA*
    
    }catch(SQLException e){
    e.printStackTrace(System.out);
    }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    
    return algo;
 */
