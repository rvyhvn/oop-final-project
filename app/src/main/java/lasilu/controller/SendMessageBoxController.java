package lasilu.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SendMessageBoxController implements Initializable {

    @FXML
    private TextField toTextField;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendButton;

    @FXML
    private Button clearButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inisialisasi controller
    }

    @FXML
    private void sendButtonClicked() {
        // Logika untuk mengirim pesan
    }

    @FXML
    private void clearButtonClicked() {
        toTextField.clear();
        fromTextField.clear();
        subjectTextField.clear();
        messageTextArea.clear();
    }

    @FXML
    private void closeButtonClicked() {
        Stage stage = (Stage) sendButton.getScene().getWindow();
        stage.close();
    }
}