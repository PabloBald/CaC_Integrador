package web;

import entities.Empanada;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import logic.ServiciosEmpanada;

@WebServlet(name = "PanelControlServlet", urlPatterns = {"/panel"})
public class PanelControlServlet extends HttpServlet {

    ServiciosEmpanada empServices = new ServiciosEmpanada();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            
            int auth = (int)session.getAttribute("auth");
            if (auth == 1) {
                List<Empanada> listaEmpanadas = empServices.listarEmpanadasAdmin();
                req.setAttribute("empanadas", listaEmpanadas);
                req.getRequestDispatcher("WEB-INF/pages/private/panel.jsp").forward(req, res);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, res);
            }
        }catch(Exception e){
            req.getRequestDispatcher("error.jsp").forward(req, res);
        }

    }
}
