package lasilu.controller;

import lasilu.dao.MapelKelasDAO;
import lasilu.model.Kelas;
import lasilu.model.MapelKelas;
import lasilu.model.MataPelajaran;

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

    public void addMapelKelas(int idKelas, int idMapel) {
        try {
            MapelKelas mapelKelas = new MapelKelas();

            MataPelajaran mataPelajaran = new MataPelajaran();
            mataPelajaran.setIdMapel(idMapel);
            mapelKelas.setMapel(mataPelajaran);

            Kelas kelas = new Kelas();
            kelas.setIdKelas(idKelas);
            mapelKelas.setKelas(kelas);

            mapelKelasDAO.addMapelKelas(mapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMapelKelas(int idMapelKelas, int idKelas, int idMapel) {
        try {
            MapelKelas mapelKelas = new MapelKelas();
            mapelKelas.setIdMapelKelas(idMapelKelas);

            Kelas kelas = new Kelas();
            kelas.setIdKelas(idKelas);
            mapelKelas.setKelas(kelas);

            MataPelajaran mataPelajaran = new MataPelajaran();
            mataPelajaran.setIdMapel(idMapel);
            mapelKelas.setMapel(mataPelajaran);

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
