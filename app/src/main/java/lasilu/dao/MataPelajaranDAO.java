package com.project.dao;

import com.project.model.MataPelajaran;
import com.project.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MataPelajaranDAO {
    private Connection connection;

    public MataPelajaranDAO(Connection connection) {
        this.connection = connection;
    }

    public void addMataPelajaran(MataPelajaran mataPelajaran) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO mapel (id_mapel, nama_mapel) VALUES (?, ?);");
            statement.setInt(1, mataPelajaran.getIdMapel());
            statement.setString(2, mataPelajaran.getNamaMapel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }

    public MataPelajaran getMataPelajaran(int idMapel) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MataPelajaran mataPelajaran = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM mapel WHERE id_mapel = ?;");
            statement.setInt(1, idMapel);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idMpl = resultSet.getInt("id_mapel");
                String namaMpl = resultSet.getString("nama_mapel");

                mataPelajaran = new MataPelajaran(idMpl, namaMpl, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
        return mataPelajaran;
    }

    public void updateMataPelajaran(MataPelajaran mataPelajaran) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE mapel SET nama_mapel = ? WHERE id_mapel = ?;");
            statement.setString(1, mataPelajaran.getNamaMapel());
            statement.setInt(2, mataPelajaran.getIdMapel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void deleteMataPelajaran(int idMapel) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM mapel WHERE id_mapel = ?;");
            statement.setInt(1, idMapel);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
    }

    public List<MataPelajaran> getAllMataPelajaran() {
        List<MataPelajaran> mataPelajaranList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM mapel;");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idMpl = resultSet.getInt("id_mapel");
                String namaMpl = resultSet.getString("nama_mapel");

                MataPelajaran mataPelajaran = new MataPelajaran(idMpl, namaMpl, null);
                mataPelajaranList.add(mataPelajaran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseUtil.closeConnection(connection);
        }
        return mataPelajaranList;
    }
}
