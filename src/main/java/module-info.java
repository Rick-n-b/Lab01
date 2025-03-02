module ru.nstu.lab01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.nstu.lab01 to javafx.fxml;
    exports ru.nstu.lab01;
    exports ru.nstu.lab01.Module;
    opens ru.nstu.lab01.Module to javafx.fxml;
}