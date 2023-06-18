package com.project.controller;

import com.project.model.Laporan;
import com.project.util.CSVExporter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LaporanController {
    private List<Laporan> laporanList;

    public LaporanController(List<Laporan> laporanList) {
        this.laporanList = laporanList;
    }

    public void generateCSVReport(String filePath) {
        // Mengkonversi data Laporan menjadi format yang sesuai untuk CSV
        List<List<String>> data = convertLaporanToDataList(laporanList);

        // Membuat file CSV dengan menggunakan CSVExporter
        CSVExporter.export(data, filePath);

        File csvFile = new File(filePath);
        if (csvFile.exists()) {
            System.out.println("File CSV berhasil dibuat: " + csvFile.getAbsolutePath());
        } else {
            System.out.println("Gagal membuat file CSV.");
        }
    }

    private List<List<String>> convertLaporanToDataList(List<Laporan> laporanList) {
        List<List<String>> data = new ArrayList<>();

        for (Laporan laporan : laporanList) {
            List<String> rowData = new ArrayList<>();

            rowData.add(String.valueOf(laporan.getIdLaporan()));
            rowData.add(CSVExporter.formatDate(laporan.getTanggal(), "yyyy-MM-dd"));
            rowData.add(laporan.getKelas().getNamaKelas());
            rowData.add(laporan.getSiswa().getNama());
            rowData.add(laporan.getGuru().getNama());
            rowData.add(String.valueOf(laporan.getNilai().getNilai()));

            data.add(rowData);
        }

        return data;
    }
}
