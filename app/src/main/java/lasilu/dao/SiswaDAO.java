package lasilu.dao;

import lasilu.model.Kelas;
import lasilu.model.Nilai;
import lasilu.model.Siswa;
import lasilu.model.WaliMurid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiswaDAO {
    private Connection connection;

    // Constructor
    public SiswaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Siswa> getAllSiswa() throws SQLException {
        List<Siswa> siswaList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM siswa";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setEmail(resultSet.getString("email"));
                siswa.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("kelas_id"));
                // kelas.setTingkat(resultSet.getString("tingkat"));
                // kelas.setUrutan(resultSet.getInt("urutan"));
                // kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("wali_id"));
                // waliMurid.setNama(resultSet.getString("nama"));
                // waliMurid.setEmail(resultSet.getString("email"));
                // waliMurid.setPhone(resultSet.getString("phone"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);

                siswaList.add(siswa);
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
        return siswaList;
    }

    public Siswa getSiswaById(int idSiswa) throws SQLException {
        Siswa siswa = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM siswa WHERE id_siswa = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idSiswa);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setEmail(resultSet.getString("email"));
                siswa.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("kelas_id"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("wali_id"));
                waliMurid.setNama(resultSet.getString("nama"));
                waliMurid.setEmail(resultSet.getString("email"));
                waliMurid.setPhone(resultSet.getString("phone"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);
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
        return siswa;
    }

    public List<Siswa> getSiswaByKelasId(int idKelas) throws SQLException {
        List<Siswa> siswaList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT siswa.id_siswa AS id, siswa.nama, walimurid.nama AS nama_walimurid, nilai.mean AS nilai_mean, kelas.id_kelas, kelas.tingkat, kelas.urutan, kelas.is_ipa "
                    +
                    "FROM siswa " +
                    "JOIN walimurid ON siswa.wali_id = walimurid.id_wali " +
                    "JOIN nilai ON siswa.nilai_id = nilai.id_nilai " +
                    "JOIN kelas ON siswa.kelas_id = kelas.id_kelas " +
                    "WHERE kelas.id_kelas = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idKelas);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id"));
                waliMurid.setNama(resultSet.getString("nama_walimurid"));
                // waliMurid.setEmail(resultSet.getString("email"));
                // waliMurid.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                Nilai nilai = new Nilai();
                nilai.setNilaiMean(resultSet.getDouble("nilai_mean"));

                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id"));
                siswa.setNama(resultSet.getString("nama"));

                siswa.setKelas(kelas);
                siswa.setWaliMurid(waliMurid);
                siswa.setNilaiMean(nilai);
                siswaList.add(siswa);
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
        return siswaList;
    }

    public void addSiswa(Siswa siswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO siswa (nama, email, phone, kelas_id, wali_id, nilai_id) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, siswa.getNama());
            statement.setString(2, siswa.getEmail());
            statement.setString(3, siswa.getPhone());
            statement.setInt(4, siswa.getKelas().getIdKelas());
            statement.setInt(5, siswa.getWaliMurid().getIdWali());
            statement.setInt(6, siswa.getNilaiMean().getIdNilai());
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

    public void updateSiswa(Siswa siswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE siswa SET nama = ?, email = ?, phone = ?, kelas_id = ?, wali_id = ?, nilai_id = ? WHERE id_siswa = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, siswa.getNama());
            statement.setString(2, siswa.getEmail());
            statement.setString(3, siswa.getPhone());
            statement.setInt(4, siswa.getKelas().getIdKelas());
            statement.setInt(5, siswa.getWaliMurid().getIdWali());
            statement.setInt(6, siswa.getNilaiMean().getIdNilai());
            statement.setInt(7, siswa.getIdSiswa());
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

    public void deleteSiswa(int idSiswa) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM siswa WHERE id_siswa = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idSiswa);
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