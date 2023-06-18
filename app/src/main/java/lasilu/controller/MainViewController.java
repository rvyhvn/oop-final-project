package com.project.controller;

import com.project.model.Guru;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {
    @FXML
    private Label infoLabel;
     
    private Guru guru;

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public void initData() {
        
    }

    // Metode lain untuk mengelola GUI utama
}
