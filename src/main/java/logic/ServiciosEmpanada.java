package logic;

import data.EmpanadaDAO;
import entities.Empanada;
import java.util.List;

public class ServiciosEmpanada {

    private final EmpanadaDAO empanadaDAO;

    public ServiciosEmpanada() {
        this.empanadaDAO = new EmpanadaDAO();
    }

    public List<Empanada> listarEmpanadasCliente() {
        List<Empanada> lista;
        lista = empanadaDAO.listarEmpanadas();
        return lista;
    }
    
    public List<Empanada> listarEmpanadasClientePorTipo(String tipo) {
        List<Empanada> lista;
        lista = empanadaDAO.listarEmpanadasPorTipoCliente(tipo);
        return lista;
    }
    
    public List<Empanada> listarEmpanadasClientePorTipoAdmin(String tipo) {
        List<Empanada> lista;
        lista = empanadaDAO.listarEmpanadasPorTipoAdmin(tipo);
        return lista;
    }

    public List<Empanada> listarEmpanadasAdmin() {
        List<Empanada> lista;
        lista = empanadaDAO.listarEmpanadasAdmin();
        return lista;
    }

    public Empanada obtenerEmpanadaPorId(int id) {
        Empanada emp = empanadaDAO.obtenerEmpanadaPorId(id);
        return emp;
    }

    public int crearEmpanada(String nombre, String descripcion, Double precio, String tipo) {
        int resultado;
        Empanada emp = new Empanada(nombre, descripcion, precio, tipo);
        resultado = empanadaDAO.altaEmpanada(emp);
        return resultado;
    }

    public int eliminarEmpanada(int id) {
        int resultado;
        resultado = empanadaDAO.bajaEmpanada(id);
        return resultado;
    }

    public int deshabilitarEmpanada(int id) {
        int resultado;
        resultado = empanadaDAO.bajaLogicaEmpanada(id);
        return resultado;
    }
    
     public int habilitarEmpanada(int id) {
        int resultado;
        resultado = empanadaDAO.altaLogicaEmpanada(id);
        return resultado;
    }

    public int modificarEmpanada(int id,String nombre, String descripcion, Double precio, String tipo) {
        int resultado;
        Empanada emp = new Empanada(nombre,descripcion,precio,tipo);
        resultado = empanadaDAO.modificarEmpanada(id,emp);
        return resultado;
    }
}
