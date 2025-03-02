package ru.nstu.lab01;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.nstu.lab01.Entities.MegaMatka;
import ru.nstu.lab01.Module.ModuleController;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private SplitPane turboBox;
    @FXML
    private Label textTimer;
    @FXML
    private AnchorPane field;
    @FXML
    public Button startButton;
    @FXML
    public Button endButton;
    @FXML
    private Button hintButton;
    private EventObject event;

    MegaMatka matka = new MegaMatka(field);

    @FXML
    private void clickShow() throws IOException {//симуляция должна останавливаться, а не прекращаться. Так же надо добавить две кнопки
        Stage ownerStage = (Stage) startButton.getScene().getWindow();
        Stage stage = new Stage();
        //stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Module.fxml"));
        Parent loader = fxmlLoader.load();
        ModuleController controller = fxmlLoader.getController();
        boolean paused = matka.isPaused;
        matka.pauseTimer();
        matka.isPaused = paused;
        controller.setInfo(matka);
        Scene scene = new Scene(loader);
        stage.setScene(scene);
        stage.setTitle("Stats");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(ownerStage);
        stage.setResizable(false);

        stage.show();
    }
    @FXML
    private void timeShow() throws IOException{
        textTimer.setText(matka.getTime().getCurrentTime());
    }
    @FXML
    private void simStart(){
        matka.motoKill();
        matka.carKill();
        matka.playTimerFromStart();
        startButton.setDisable(true);
        endButton.setDisable(false);
    }

    @FXML
    private void simStop(){
        matka.endTimer();
        startButton.setDisable(false);
        endButton.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        matka.setPane(field);
        field.requestFocus();
        endButton.setDisable(true);
        field.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        switch (keyEvent.getCode()){
                            case B:
                                //start
                                matka.motoKill();
                                matka.carKill();
                                matka.playTimerFromStart();

                                startButton.setDisable(true);
                                endButton.setDisable(false);
                                break;
                            case E:
                                //end
                                matka.endTimer();
                                startButton.setDisable(false);
                                endButton.setDisable(true);
                                break;
                            case T:
                                //timer
                                textTimer.setText(matka.getTime().getCurrentTime());
                                break;
                            default:
                                System.out.println(keyEvent.getCode());
                                break;
                        }
                    }
                });
            }
        });
    }
}