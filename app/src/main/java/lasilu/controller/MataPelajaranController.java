package com.project.controller;

import com.project.dao.MataPelajaranDAO;
import com.project.model.MataPelajaran;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MataPelajaranController {
    private MataPelajaranDAO mataPelajaranDAO;
    private Connection connection;

    public MataPelajaranController(Connection connection) {
        this.connection = connection;
        mataPelajaranDAO = new MataPelajaranDAO(connection);
    }

    public List<MataPelajaran> getAllMataPelajaran() throws SQLException {
        return mataPelajaranDAO.getAllMataPelajaran();
    }

    public void addMataPelajaran(MataPelajaran mataPelajaran) throws SQLException {
        mataPelajaranDAO.addMataPelajaran(mataPelajaran);
    }

    public void updateMataPelajaran(MataPelajaran mataPelajaran) throws SQLException {
        mataPelajaranDAO.updateMataPelajaran(mataPelajaran);
    }

    public void deleteMataPelajaran(int idMapel) throws SQLException {
        mataPelajaranDAO.deleteMataPelajaran(idMapel);
    }
}
