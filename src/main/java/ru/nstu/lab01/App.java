package ru.nstu.lab01;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nstu.lab01.Entities.MegaMatka;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Scene.fxml"));
        Parent loader = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        Scene scene = new Scene(loader, 880, 640);
        stage.setTitle("Labs v8");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}