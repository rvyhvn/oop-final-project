package lasilu.controller;

import lasilu.dao.MapelKelasDAO;
import lasilu.model.MapelKelas;
import lasilu.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MapelKelasController {
    private MapelKelasDAO mapelKelasDAO;
    private Connection connection;

    public MapelKelasController() {
        mapelKelasDAO = new MapelKelasDAO(connection);
    }

    public List<MapelKelas> getAllMapelKelas() {
        try {
            return mapelKelasDAO.getAllMapelKelas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MapelKelas getMapelKelasById(int idMapelKelas) {
        try {
            return mapelKelasDAO.getMapelKelasById(idMapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMapelKelas(MapelKelas mapelKelas) {
        try {
            mapelKelasDAO.addMapelKelas(mapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMapelKelas(MapelKelas mapelKelas) {
        try {
            mapelKelasDAO.updateMapelKelas(mapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMapelKelas(int idMapelKelas) {
        try {
            mapelKelasDAO.deleteMapelKelas(idMapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
