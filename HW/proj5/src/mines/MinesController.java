package mines;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;

public class MinesController {

    @FXML
    private TextField widthInput;

    @FXML
    private TextField heightInput;

    @FXML
    private TextField minesInput;

    @FXML
    private StackPane gridContainer;

    private MinesFXMain mainApp;

    public void setMainApp(MinesFXMain mainApp) {
        this.mainApp = mainApp;
    }

    public void setGrid(GridPane grid) {
        gridContainer.getChildren().clear();
        gridContainer.getChildren().add(grid);
    }

    @FXML
    public void handleReset() {
        try {
            int w = Integer.parseInt(widthInput.getText().trim());
            int h = Integer.parseInt(heightInput.getText().trim());
            int m = Integer.parseInt(minesInput.getText().trim());

            mainApp.startNewGame(h, w, m);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing reset fields. Use integer inputs.");
        }
    }
}