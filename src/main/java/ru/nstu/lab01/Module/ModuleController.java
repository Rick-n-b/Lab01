package ru.nstu.lab01.Module;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.nstu.lab01.Entities.MegaMatka;
import ru.nstu.lab01.Entities.Motorbike;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ModuleController implements Initializable {
    @FXML
    private AnchorPane module;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;
    @FXML
    private TextArea infoField;
    MegaMatka matkaCopy = null;
    public void setInfo(MegaMatka matka){
        infoField.setText("Жаб на мотоциклах: " + matka.getMotors().toArray().length
                + "\nТип 1: " + matka.getMotoType1() + ", тип 2: " + matka.getMotoType2()
                + "\nЖаб на Белазах: " + matka.getCars().toArray().length
                + "\nТип 1: " + matka.getCarType1() + ", тип 2: " + matka.getCarType2()
                + "\nВремя симуляции: " + matka.getTime().getCurrentTime()
        );
        matkaCopy = matka;
    }
    @FXML
    private void clickUnpause() throws IOException{
        if(!matkaCopy.isPaused)
            matkaCopy.playTimer();
        ((Stage) okButton.getScene().getWindow()).close();
    }
    @FXML
    private void clickExit() throws IOException{
        matkaCopy.endTimer();
        ((Stage) okButton.getScene().getWindow()).close();

    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        infoField.setEditable(false);
    }
}
