package pl.lublin.wsei.java.cwiczenia.lab2a;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public Label lbFile;
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)","*.xml");

    @FXML
    public void initialize(){
        fileChooser.getExtensionFilters().add(xmlFilter);
    }

    public void btnOpenFileAction(ActionEvent actionEvent){
        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            lbFile.setText(file.getAbsolutePath());
        } else {
            lbFile.setText("Prosz� wczyta� plik ...");
        }
    }
}