package ru.nsu.yadrishnikova.task_2_3_1.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.nsu.yadrishnikova.task_2_3_1.SnakeApplication;
import ru.nsu.yadrishnikova.task_2_3_1.model.Direction;
import ru.nsu.yadrishnikova.task_2_3_1.model.Game;
import ru.nsu.yadrishnikova.task_2_3_1.model.GameState;
import ru.nsu.yadrishnikova.task_2_3_1.model.Snake;
import ru.nsu.yadrishnikova.task_2_3_1.view.CanvasPainter;
import ru.nsu.yadrishnikova.task_2_3_1.view.Painter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class GameSceneController implements Initializable {

    private Game game;

    protected static int sizeX;
    protected static int sizeY;
    protected static String fileName = "";
    protected static int obstaclesCount;
    protected static int foodCount;
    protected static int[] foodValues;
    protected static int maxSnakeSize;
    protected static int snakeCount;
    protected static int deltaTime;

    @FXML
    private Canvas canvas;
    @FXML
    private Label selfSizeLabel;
    @FXML
    private Label maxBotSizeLabel;
    @FXML
    private Label needToWinLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Painter painter = new CanvasPainter(canvas.getGraphicsContext2D(), selfSizeLabel, maxBotSizeLabel, needToWinLabel);
        if (!fileName.equals("")) {
            game = new Game(fileName, maxSnakeSize, snakeCount, painter);
        } else {
            game = new Game(
                    sizeX,
                    sizeY,
                    obstaclesCount,
                    foodCount,
                    foodValues,
                    maxSnakeSize,
                    snakeCount,
                    painter
            );
        }
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> game.getSelfSnake().setDirection(Direction.UP);
                case DOWN -> game.getSelfSnake().setDirection(Direction.DOWN);
                case LEFT -> game.getSelfSnake().setDirection(Direction.LEFT);
                case RIGHT -> game.getSelfSnake().setDirection(Direction.RIGHT);
            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ControllerTask(game), 0, deltaTime);
    }

    public void loadGameResultScreen() {
        try {
            GameResultsController.init(
                    game.getGameState(),
                    game.getSelfSnake().getSnakeSize(),
                    game.getSnakes()
                            .stream()
                            .filter(snake -> snake != game.getSelfSnake())
                            .mapToInt(Snake::getSnakeSize)
                            .max()
                            .orElse(0),
                    game.getMaxSnakeSize()
            );
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(SnakeApplication.class.getResource("game_results.fxml")));
            Stage stage = (Stage) selfSizeLabel.getScene().getWindow();
            Scene newScene = new Scene(newRoot);
            stage.hide();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private class ControllerTask extends TimerTask {

        private final Game game;

        public ControllerTask(Game game) {
            this.game = game;
        }

        @Override
        public void run() {
            if (game.getGameState() != GameState.RUNNING) {
                Platform.runLater(GameSceneController.this::loadGameResultScreen);
                cancel();
            }
            Platform.runLater(game::move);
        }

    }

}
