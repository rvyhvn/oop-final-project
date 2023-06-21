package lasilu.controller;

import lasilu.dao.WaliMuridDAO;
import lasilu.model.WaliMurid;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class waliMuridController {
    @FXML
    private TableView<WaliMurid> tableView;
    @FXML
    private TableColumn<WaliMurid, String> waliMuridColumn;

    private WaliMuridDAO waliMuridDAO;

    public void setWaliMuridDAO(WaliMuridDAO waliMuridDAO) {
        this.waliMuridDAO = waliMuridDAO;
        loadWaliMuridData();
    }

    private void loadWaliMuridData() {
        try {
            List<WaliMurid> waliMuridList = waliMuridDAO.getAllWaliMurid();
            tableView.getItems().addAll(waliMuridList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Menghubungkan kolom tabel dengan atribut WaliMurid
        waliMuridColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
    }
}
