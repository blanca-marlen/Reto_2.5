package co.com.marlen.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.marlen.model.vo.TercerInformeVo;
import co.com.marlen.util.JDBCUtilities;

public class TercerInformeDao {
    public List<TercerInformeVo> toList() throws SQLException {
        ArrayList<TercerInformeVo> reply = new ArrayList<TercerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        String consult = "SELECT c.ID_Compra AS ID, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p USING (ID_Proyecto) WHERE c.Proveedor='Homecenter' AND p.Ciudad='Salento'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consult);
            while (rs.next()) {
                TercerInformeVo object = new TercerInformeVo();
                object.setId(rs.getInt("ID"));
                object.setConstructora(rs.getString("Constructora"));
                object.setBancoVinculado(rs.getString("Banco_Vinculado"));

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
