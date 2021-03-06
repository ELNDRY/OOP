package ru.nsu.yadrishnikova.task_2_3_1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.nsu.yadrishnikova.task_2_3_1.SnakeApplication;
import ru.nsu.yadrishnikova.task_2_3_1.model.field.Level;

import java.io.IOException;
import java.util.Objects;

public class LevelSceneController {

    @FXML
    private Button levelOneButton;
    @FXML
    private Button levelTwoButton;
    @FXML
    private Button levelThreeButton;

    @FXML
    private void levelOneButtonClicked(ActionEvent event) throws IOException {
        initGameScene(Level.LEVEL_1);
        loadGameScene(event);
    }

    @FXML
    private void levelTwoButtonClicked(ActionEvent event) throws IOException {
        initGameScene(Level.LEVEL_2);
        loadGameScene(event);
    }

    @FXML
    private void levelThreeButtonClicked(ActionEvent event) throws IOException {
        initGameScene(Level.LEVEL_3);
        loadGameScene(event);
    }

    private void initGameScene(Level level) {
        GameSceneController.fileName = level.getFileName();
        GameSceneController.maxSnakeSize = level.getMaxSnakeSize();
        GameSceneController.snakeCount = level.getSnakeCount();
        GameSceneController.deltaTime = level.getDeltaTime();
    }


    private void loadGameScene(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(SnakeApplication.class.getResource("game_scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newRoot);
        stage.hide();
        stage.setScene(newScene);
        stage.show();
    }

}
