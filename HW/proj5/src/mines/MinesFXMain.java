package mines;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MinesFXMain extends Application {
    private Mines game;
    private int height = 10;
    private int width = 10;
    private int numMines = 10;
    private MineButton[][] buttons;
    private MinesController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MinesWindow.fxml"));
        Parent root = loader.load();

        this.controller = loader.getController();
        controller.setMainApp(this);

        startNewGame(height, width, numMines);

        primaryStage.setTitle("The Amazing Mines Sweeper");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void startNewGame(int h, int w, int m) {
        this.height = h;
        this.width = w;
        this.numMines = m;

        game = new Mines(height, width, numMines);
        buttons = new MineButton[height][width];

        GridPane grid = createGrid();
        controller.setGrid(grid);
        refreshUI();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                MineButton btn = new MineButton(i, j);
                buttons[i][j] = btn;
                btn.setOnMouseClicked(this::handleButtonClick);
                grid.add(btn, j, i);
            }
        }
        return grid;
    }

    private void handleButtonClick(MouseEvent event) {
        MineButton clickedButton = (MineButton) event.getSource();
        int x = clickedButton.getX();
        int y = clickedButton.getY();

        // RMB flag
        if (event.getButton() == MouseButton.SECONDARY) {
            game.toggleFlag(x, y);
            refreshUI();
            return;
        }

        // LMB open
        if (event.getButton() == MouseButton.PRIMARY) {
            boolean isSafe = game.open(x, y);
            refreshUI();

            if (!isSafe) {
                game.setShowAll(true);
                refreshUI();

                // Show alert that you lost
                showAlert("Boom! You hit a mine.");

            } else if (game.isDone()) {
                showAlert("OMG, you won!");
            }
        }
    }

    private void refreshUI() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String cellText = game.get(i, j);
                buttons[i][j].setText(cellText);

                // Style elements to match the reference look
                if (cellText.equals(".")) {
                    buttons[i][j].setStyle(
                            "-fx-background-color: #e0e0e0; -fx-background-radius: 4; -fx-text-fill: #333333; -fx-font-weight: bold;");
                } else if (cellText.equals("F")) {
                    buttons[i][j].setStyle(
                            "-fx-background-color: #ffb3b3; -fx-background-radius: 4; -fx-text-fill: #cc0000; -fx-font-weight: bold;");
                } else if (cellText.equals("X")) {
                    buttons[i][j].setStyle(
                            "-fx-background-color: #333333; -fx-background-radius: 4; -fx-text-fill: #ffffff; -fx-font-weight: bold;");
                } else {
                    // Open safe floor grid element
                    buttons[i][j].setStyle(
                            "-fx-background-color: #f5f5f5; -fx-background-radius: 4; -fx-border-color: #dddddd; -fx-border-radius: 4; -fx-font-weight: bold;");
                }
            }
        }
    }

    private void showAlert(String text) {

        Alert alert = new Alert(AlertType.INFORMATION);
       
        alert.setHeaderText(null);
        alert.setContentText(text);
        
        // wait to be closed
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}