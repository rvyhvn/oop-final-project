package com.project.dao;

import com.project.model.MapelKelas;
import com.project.model.MataPelajaran;
import com.project.model.Kelas;
import com.project.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MapelKelasDAO {
    private Connection connection;

    // Constructor
    public MapelKelasDAO(Connection connection) {
        this.connection = connection;
    }

    public List<MapelKelas> getAllMapelKelas() throws SQLException {
        List<MapelKelas> mapelKelasList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT mk.id_mapelkelas, mk.mapel_id, m.nama_mapel, k.id_kelas, k.tingkat, k.urutan, k.is_ipa FROM mapelkelas mk LEFT JOIN mapel m ON mk.mapel_id = m.id_mapel LEFT JOIN kelas k ON mk.kelas_id = k.id_kelas;");
            while (resultSet.next()) {
                MapelKelas mapelKelas = new MapelKelas();
                mapelKelas.setIdMapelKelas(resultSet.getInt("id_mapelkelas"));

                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setIdMapel(resultSet.getInt("mapel_id"));
                mataPelajaran.setNamaMapel(resultSet.getString("nama_mapel"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                ArrayList<Kelas> kelasList = new ArrayList<>();
                kelasList.add(kelas);
                mataPelajaran.setKelas(kelasList);

                mapelKelas.setMapel(mataPelajaran);

                mapelKelasList.add(mapelKelas);
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
        return mapelKelasList;
    }

    public MapelKelas getMapelKelasById(int idMapelKelas) throws SQLException {
        MapelKelas mapelKelas = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT mk.id_mapelkelas, mk.mapel_id, m.nama_mapel, k.id_kelas, k.tingkat, k.urutan, k.is_ipa FROM mapelkelas mk LEFT JOIN mapel m ON mk.mapel_id = m.id_mapel LEFT JOIN kelas k ON mk.kelas_id = k.id_kelas WHERE mk.id_mapelkelas = ?;");
            statement.setInt(1, idMapelKelas);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                mapelKelas = new MapelKelas();
                mapelKelas.setIdMapelKelas(resultSet.getInt("id_mapelkelas"));

                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setIdMapel(resultSet.getInt("mapel_id"));
                mataPelajaran.setNamaMapel(resultSet.getString("nama_mapel"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                ArrayList<Kelas> kelasList = new ArrayList<>();
                kelasList.add(kelas);
                mataPelajaran.setKelas(kelasList);

                mapelKelas.setMapel(mataPelajaran);
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
        return mapelKelas;
    }

    public void addMapelKelas(MapelKelas mapelKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO mapelkelas (kelas_id, mapel_id) VALUES (?, ?);");
            statement.setInt(1, mapelKelas.getMapel().getKelas().get(0).getIdKelas());
            statement.setInt(2, mapelKelas.getMapel().getIdMapel());
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

    public void updateMapelKelas(MapelKelas mapelKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE mapelkelas SET kelas_id = ?, mapel_id = ? WHERE id_mapelkelas = ?;");
            statement.setInt(1, mapelKelas.getMapel().getKelas().get(0).getIdKelas());
            statement.setInt(2, mapelKelas.getMapel().getIdMapel());
            statement.setInt(3, mapelKelas.getIdMapelKelas());
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

    public void deleteMapelKelas(int idMapelKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM mapelkelas WHERE id_mapelkelas = ?;");
            statement.setInt(1, idMapelKelas);
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
}
