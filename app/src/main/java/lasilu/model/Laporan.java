package com.project.model;

import java.util.Date;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;

public class Laporan {

  private int idLaporan;
  private Date tanggal;
  private Kelas kelas;
  private Siswa siswa;
  private Guru guru;
  private Nilai nilai;

  public Laporan(int idLaporan, Date tanggal, Kelas kelas, Siswa siswa, Guru guru, Nilai nilai) {
    this.idLaporan = idLaporan;
    this.tanggal = tanggal;
    this.kelas = kelas;
    this.siswa = siswa;
    this.guru = guru;
    this.nilai = nilai;
  }

  public int getIdLaporan(){
    return idLaporan;
  }

  public Date getTanggal(){
    return tanggal;
  }

  public Kelas getKelas(){
    return kelas;
  }

  public void setKelas(Kelas kelas){
    this.kelas = kelas;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public void setSiswa(Siswa siswa){
    this.siswa = siswa;
  }

  public Guru getGuru(){
    return guru;
  }

  public void setGuru(Guru guru){
    this.guru = guru;
  }

  public Nilai getNilai(){
    return nilai;
  }

  public void setNilai(Nilai nilai){
    this.nilai = nilai;
  }

  public void exportToCSV(String filePath) throws IOException {
    try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT)) {
      csvPrinter.printRecord("idLaporan", "tanggal", "idKelas", "namaKelas", "idSiswa", "idGuru", "idNilai", "nilai");

      csvPrinter.printRecord(
              getIdLaporan(),
              getTanggal(),
              getKelas().getIdKelas(),
              getKelas().getNamaKelas(),
              getSiswa().getIdSiswa(),
              getGuru().getIdGuru(),
              getNilai().getIdNilai(),
              getNilai().getNilai()
      );
    }
  }
}
