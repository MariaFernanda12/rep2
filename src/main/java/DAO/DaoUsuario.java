package DAO;

import Modelo.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Solicitante;
import Util.Conexion;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuario {

    private Connection conexion;

    public DaoUsuario() throws URISyntaxException {
        
        this.conexion= Conexion.getConnection();
        
    }

    public Solicitante validar(long usuario, String clave) {
        Solicitante sol = null;
        try {

            String consulta = "select * from solicitante where identificador="
                    + usuario + " and clave='" + clave + "'";
            Statement statement
                    = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            if (resultado.next()) {
                sol = new Solicitante();
                sol.setIdentificador(resultado.getLong("identificador"));
                sol.setNombre(resultado.getString("nombreSol"));
                sol.setTipo(resultado.getString("tipo"));
                sol.setClave(resultado.getString("clave"));
                sol.setCursoArea(resultado.getString("cursoArea"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sol;
    }

    public boolean cambiarClave(long id, String claveNueva, String claveAntigua) {
        boolean resultado = false;
        try {
            String consulta = "UPDATE solicitante SET clave ='" + claveNueva + "' "
                    + "where identificador=" + id + " and clave='" + claveAntigua + "'";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            resultado = statement.execute();

            System.out.println(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    

}
