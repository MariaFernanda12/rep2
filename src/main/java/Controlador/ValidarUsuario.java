package Controlador;

import DAO.DaoUsuario;
import Modelo.Solicitante;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long textoId;
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        textoId = new Long(Long.parseLong(usuario));
        DaoUsuario daoUser = null;
        try {
            daoUser = new DaoUsuario();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ValidarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Solicitante sol = new Solicitante();
        sol = daoUser.validar(textoId, clave);

        if (sol != null) {
            request.setAttribute("Exito", sol);
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("Failed", "NOK");
            RequestDispatcher rd = request.getRequestDispatcher("indexU.jsp");
            rd.forward(request, response);
        }

        HttpSession sesion = request.getSession();
        sol = (Solicitante) sesion.getAttribute("usuario");
        if (sol == null) {
            sol = new Solicitante();
            sol.setIdentificador(textoId);
            sol.setClave(clave);
            sesion.setAttribute("usuario", sol);
        } else {
            sol.setIdentificador(textoId);
            sol.setClave(clave);
            sesion.setAttribute("usuario", sol);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
