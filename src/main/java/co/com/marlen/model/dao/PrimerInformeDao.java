package co.com.marlen.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.marlen.model.vo.PrimerInformeVo;
import co.com.marlen.util.JDBCUtilities;

public class PrimerInformeDao {
    public List<PrimerInformeVo> toList() throws SQLException {
        ArrayList<PrimerInformeVo> reply = new ArrayList<PrimerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        // second consult from Cycle_2\Unit_2.3\Script_Challenge_2.3.sql
        String consult = "SELECT ID_Lider AS ID, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consult);
            while (rs.next()) {
                PrimerInformeVo object = new PrimerInformeVo();
                object.setId(rs.getInt("ID"));
                object.setNombre(rs.getString("Nombre"));
                object.setPrimerApellido(rs.getString("Primer_Apellido"));
                object.setCiudadResidencia(rs.getString("Ciudad_Residencia"));

                reply.add(object);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return reply;
    }
}
