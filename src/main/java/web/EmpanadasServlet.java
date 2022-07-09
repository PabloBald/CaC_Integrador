package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import logic.ServiciosEmpanada;

@WebServlet(name = "EmpanadasServlet", urlPatterns = {"/empanadas"})
public class EmpanadasServlet extends HttpServlet {

    ServiciosEmpanada emp = new ServiciosEmpanada();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    req.setAttribute("empanada", emp.obtenerEmpanadaPorId(Integer.parseInt(req.getParameter("id"))));
                    req.getRequestDispatcher("/WEB-INF/pages/private/editForm.jsp").forward(req, res);
                    break;
                case "eliminar":
                    emp.eliminarEmpanada(Integer.parseInt(req.getParameter("id")));
                    res.sendRedirect(req.getContextPath() + "/panel");
                    break;
                case "deshabilitar":
                    emp.deshabilitarEmpanada(Integer.parseInt(req.getParameter("id")));
                    res.sendRedirect(req.getContextPath() + "/panel");
                    break;
                case "habilitar":
                    emp.habilitarEmpanada(Integer.parseInt(req.getParameter("id")));
                    res.sendRedirect(req.getContextPath() + "/panel");
                    break;
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/panel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "crear":
                    emp.crearEmpanada(req.getParameter("nombre"), req.getParameter("descripcion"), Double.parseDouble(req.getParameter("precio")), req.getParameter("tipo"));
                    res.sendRedirect(req.getContextPath()+"/panel");
                    break;
                case "editar":
                    emp.modificarEmpanada(Integer.parseInt(req.getParameter("id")), req.getParameter("nombre"), req.getParameter("descripcion"), Double.parseDouble(req.getParameter("precio")), req.getParameter("tipo"));
                    res.sendRedirect(req.getContextPath()+"/panel");
                    break;
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/panel");
                    
        }

    }
}
