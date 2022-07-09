
import data.UsuarioDAO;
import entities.Usuario;
import java.util.List;
import logic.ServiciosUsuario;

public class Test {

    public static void main(String[] args) {

        UsuarioDAO userDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = userDAO.listarUsuarios();
        ServiciosUsuario su = new ServiciosUsuario();

        System.out.println(su.obtenerUsuarioPorId(2));

    }
}
