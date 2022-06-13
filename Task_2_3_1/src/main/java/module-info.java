module ru.nsu.yadrishnikova.task_2_3_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens ru.nsu.yadrishnikova.task_2_3_1 to javafx.fxml;
    exports ru.nsu.yadrishnikova.task_2_3_1;
    opens ru.nsu.yadrishnikova.task_2_3_1.controller to javafx.fxml;
}