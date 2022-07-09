package data;

import entities.Empanada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpanadaDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM empanadas";
    private static final String SQL_INSERT = "INSERT INTO empanadas(nombre,descripcion,precio,tipo) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empanadas SET nombre=?,descripcion=?,precio=?,tipo=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM empanadas WHERE id=?";
    private static final String SQL_LOGIC_DELETE = "UPDATE empanadas SET baja=1 WHERE id=?";
    private static final String SQL_SELECT_EMPANADA_BY_ID = "SELECT id,nombre,descripcion,precio,tipo FROM empanadas WHERE id =?";
    private static final String SQL_SELECT_EMPANADA_BY_NOMBRE = "SELECT nombre,descripcion,precio,tipo FROM empanadas WHERE nombre =?";
    private static final String SQL_SELECT_EMPANADA_BY_TIPO_CLIENTE = "SELECT id,nombre,descripcion,precio,tipo FROM empanadas WHERE tipo = ? AND baja = 0";
    private static final String SQL_SELECT_EMPANADA_BY_TIPO_ADMIN = "SELECT id,nombre,descripcion,precio,tipo,baja FROM empanadas WHERE tipo = ?";
    private static final String SQL_LOGIC_RECOVER = "UPDATE empanadas SET baja=0 WHERE id=?";

    public List<Empanada> listarEmpanadasPorTipoCliente(String tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empanada> lista = new ArrayList<>();
        Empanada emp = null;
        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPANADA_BY_TIPO_CLIENTE);
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                emp = new Empanada();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDescripcion(rs.getString("descripcion"));
                emp.setPrecio(rs.getDouble("precio"));
                emp.setTipo(rs.getString("tipo"));
                lista.add(emp);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lista;
    }

    public List<Empanada> listarEmpanadasPorTipoAdmin(String tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empanada> lista = new ArrayList<>();
        Empanada emp = null;
        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPANADA_BY_TIPO_ADMIN);
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                emp = new Empanada();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDescripcion(rs.getString("descripcion"));
                emp.setPrecio(rs.getDouble("precio"));
                emp.setTipo(rs.getString("tipo"));
                lista.add(emp);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lista;
    }

    public Empanada obtenerEmpanadaPorNombre(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empanada emp = null;
        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPANADA_BY_NOMBRE);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while (rs.next()) {
                emp = new Empanada();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDescripcion(rs.getString("descripcion"));
                emp.setPrecio(rs.getDouble("precio"));
                emp.setTipo(rs.getString("tipo"));
            }
            return emp;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return emp;

    }

    public Empanada obtenerEmpanadaPorId(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empanada emp = null;
        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPANADA_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                emp = new Empanada();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDescripcion(rs.getString("descripcion"));
                emp.setPrecio(rs.getDouble("precio"));
                emp.setTipo(rs.getString("tipo"));
            }
            return emp;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return emp;
    }

    /**
     * Lista completamente las empanadas en la base de datos, incluye las no
     * disponibles. Utilizado por los administradores.
     *
     * @return Retorna una lista de empanadas completa.
     */
    public List<Empanada> listarEmpanadasAdmin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Empanada> list = new ArrayList<>();

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Empanada(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("baja")));
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
     * Lista las empanadas que no esten dadas de baja.
     *
     * @return Retorna una lista de Empanadas si la operacion se completo con
     * éxito, de lo contrario retorna un arreglo vacío.
     */
    public List<Empanada> listarEmpanadas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Empanada> list = new ArrayList<>();

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Empanada(rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"), rs.getString("tipo")));
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
     * Crea una empanada en la base de datos.
     *
     * @param emp Recibe una empanada que contiene nombre,descripcion y precio
     * @return Retorna 1 si la operacion se completó correctamente, en caso
     * contrario retorna -1.
     */
    public int altaEmpanada(Empanada emp) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registrosInsertados;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getDescripcion());
            stmt.setDouble(3, emp.getPrecio());
            stmt.setString(4, emp.getTipo());

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
     * Modifica una empanada con un id determinado.
     *
     * @param id Id de la empanada a modificar
     * @param emp Recibe una nueva empanada con los atributos modificados
     * @return Retorna 1 en caso de que la operacion se haya completado
     * correctamente, de lo contrario retorna -1.
     */
    public int modificarEmpanada(int id, Empanada emp) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int modificado;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getDescripcion());
            stmt.setDouble(3, emp.getPrecio());
            stmt.setString(4, emp.getTipo());
            stmt.setInt(5, id);
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
     * Elimina una empanada de la base de datos. HARD DELETE
     *
     * @param id Id de la empanada a eliminar.
     * @return Retorna 1 si la operación se completo con éxito, en caso
     * contrario retorna -1.
     */
    public int bajaEmpanada(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            resultado = stmt.executeUpdate();
            return resultado;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return -1;
    }

    /**
     * Realiza una baja lógica de una empanada con el id especificado.
     *
     * @param id
     * @return Retorna 1 si la operación se completo correctamente, de lo
     * contrario retorna -1.
     */
    public int bajaLogicaEmpanada(int id) {
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

    /**
     * Realiza una alta lógica de una empanada con el id especificado.
     *
     * @param id
     * @return Retorna 1 si la operación se completo correctamente, de lo
     * contrario retorna -1.
     */
    public int altaLogicaEmpanada(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int modificado;

        try {
            conn = Conexion.openConnection();
            stmt = conn.prepareStatement(SQL_LOGIC_RECOVER);
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
