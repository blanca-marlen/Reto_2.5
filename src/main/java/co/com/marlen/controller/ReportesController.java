package co.com.marlen.controller;

import java.sql.SQLException;
import java.util.List;

import co.com.marlen.model.dao.*;
import co.com.marlen.model.vo.*;

public class ReportesController {
    private PrimerInformeDao PrimerInformeDao;
    private SegundoInformeDao SegundoInformeDao;
    private TercerInformeDao TercerInformeDao;

    public ReportesController() {
        PrimerInformeDao = new PrimerInformeDao();
        SegundoInformeDao = new SegundoInformeDao();
        TercerInformeDao = new TercerInformeDao();

    }

    public List<PrimerInformeVo> listarPrimerInforme() throws SQLException {
        return PrimerInformeDao.toList();
    }

    public List<SegundoInformeVo> listarSegundoInforme() throws SQLException {
        return SegundoInformeDao.toList();
    }

    public List<TercerInformeVo> listarTercerInforme() throws SQLException {
        return TercerInformeDao.toList();
    }

}
