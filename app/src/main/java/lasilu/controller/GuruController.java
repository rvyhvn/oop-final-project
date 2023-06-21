package lasilu.controller;

import lasilu.dao.*;
import lasilu.model.*;
import java.sql.*;
import java.util.List;

public class GuruController {

    private GuruDAO guruDAO;
    private Connection connection;

    public GuruController() {
        guruDAO = new GuruDAO(connection);
    }

    public List<Guru> getAllGuru() {
        try {
            return guruDAO.getAllGuru();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Guru> getGuruById(int idGuru) {
        try {
            return guruDAO.getGuruById(idGuru);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
