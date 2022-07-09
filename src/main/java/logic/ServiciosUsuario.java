package logic;

import data.UsuarioDAO;
import entities.Usuario;
import java.util.List;

public class ServiciosUsuario {

    private final UsuarioDAO userDAO;

    public ServiciosUsuario() {
        this.userDAO = new UsuarioDAO();
    }

    public int autenticarUsuario(String username, String password) {
        List<Usuario> lista = userDAO.listarUsuarios();

        for (Usuario user : lista) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user.getId();
            }
        }
        return -1;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario user = userDAO.obtenerUsuarioPorId(id);
        return user;
    }
}
