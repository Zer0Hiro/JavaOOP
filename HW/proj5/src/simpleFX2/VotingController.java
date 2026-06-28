package simpleFX2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VotingController {

    private int voteCount = 0;

    // FXML file
    @FXML
    private Label scoreLabel;

    // first button
    @FXML
    void voteBiden(ActionEvent event) {
        voteCount++;
        scoreLabel.setText(String.valueOf(voteCount));
    }

    // second button
    @FXML
    void voteTrump(ActionEvent event) {
        voteCount--;
        scoreLabel.setText(String.valueOf(voteCount));
    }
}