package web;

import entities.Empanada;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import logic.ServiciosEmpanada;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    ServiciosEmpanada sEmpanada = new ServiciosEmpanada();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Empanada> listaVeggie = sEmpanada.listarEmpanadasClientePorTipo("veggie");
        List<Empanada> listaCasa = sEmpanada.listarEmpanadasClientePorTipo("casa");
        List<Empanada> listaClasica = sEmpanada.listarEmpanadasClientePorTipo("clasica");

        req.setAttribute("veggies", listaVeggie);
        req.setAttribute("lacasa", listaCasa);
        req.setAttribute("clasicas", listaClasica);
        req.getRequestDispatcher("/home.jsp").forward(req, res);
    }
}
