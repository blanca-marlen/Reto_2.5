package co.com.marlen.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.marlen.model.vo.SegundoInformeVo;
import co.com.marlen.util.JDBCUtilities;

public class SegundoInformeDao {
    public List<SegundoInformeVo> toList(Double limit) throws SQLException {
        ArrayList<SegundoInformeVo> reply = new ArrayList<SegundoInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // second consult from Cycle_2\Unit_2.3\Script_Challenge_2.3.sql
        String consult = "SELECT ID_Proyecto AS ID, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto p WHERE (p.Clasificacion='Casa Campestre' AND (p.Ciudad='Santa Marta' OR p.Ciudad='Cartagena' OR p.Ciudad='Barranquilla'))";

        try {
            stmt = conn.prepareStatement(consult);
            stmt.setDouble(1, limit);
            rs = stmt.executeQuery();
            while (rs.next()) {
                SegundoInformeVo object = new SegundoInformeVo();
                object.setId(rs.getInt("ID"));
                object.setConstructora(rs.getString("Constructora"));
                object.setnHabitaciones(rs.getInt("Numero_Habitaciones"));
                object.setCiudad(rs.getString("Ciudad"));

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
