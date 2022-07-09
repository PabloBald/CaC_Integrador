package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import logic.ServiciosUsuario;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    ServiciosUsuario sUsuario = new ServiciosUsuario();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        int id = sUsuario.autenticarUsuario(req.getParameter("email"), req.getParameter("password"));
        if (id > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("auth", 1);
            res.sendRedirect(req.getContextPath() + "/panel");
        } else {
            req.setAttribute("validacion", "is-invalid");
            req.setAttribute("mensaje", "El usuario o la contraseña ingresados son incorrectos.");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}
