package lasilu.dao;

import lasilu.model.MapelKelas;
import lasilu.model.MataPelajaran;
import lasilu.model.Kelas;
import lasilu.util.DatabaseUtil;

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
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM mapelkelas";
            statement = connection.prepareStatement(query); 
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MapelKelas mapelKelas = new MapelKelas();
                mapelKelas.setIdMapelKelas(resultSet.getInt("id_mapelkelas"));

                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setIdMapel(resultSet.getInt("mapel_id"));
                mataPelajaran.setNamaMapel(resultSet.getString("nama_mapel"));
                mataPelajaran.setJurusan(resultSet.getString("jurusan"));
                mapelKelas.setMapel(mataPelajaran);

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                mapelKelas.setMapel(mataPelajaran);
                mapelKelas.setKelas(kelas);

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
            
        }
        return mapelKelasList;
    }

    public MapelKelas getMapelKelasById(int idMapelKelas) throws SQLException {
        MapelKelas mapelKelas = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM mapelkelas WHERE id_mapelkelas = ?";
            statement = connection.prepareStatement(query);
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

                mapelKelas.setKelas(kelas);
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
            
        }
        return mapelKelas;
    }

    public void addMapelKelas(MapelKelas mapelKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO mapelkelas (kelas_id, mapel_id) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, mapelKelas.getKelas().getIdKelas());
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
            
        }
    }

    public void updateMapelKelas(MapelKelas mapelKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE mapelkelas SET kelas_id = ?, mapel_id = ? WHERE id_mapelkelas = ?;");
            statement.setInt(1, mapelKelas.getKelas().getIdKelas());
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
            
        }
    }
}
