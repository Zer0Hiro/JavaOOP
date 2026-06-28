package simpleFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Voting extends Application {

    // shared counter for votes
    private int voteCount = 0;

    @Override
    public void start(Stage primaryStage) {

        // UI parts
        Button ofraBtn = new Button("Joe Biden");
        Button yardenaBtn = new Button("Donald Trump");
        Label scoreLabel = new Label("0");

        // set horizontal red line
        scoreLabel.setStyle(
                "-fx-background-color: green; -fx-text-fill: black; -fx-alignment: center; -fx-font-size: 14px;");
        scoreLabel.setMaxWidth(Double.MAX_VALUE);

        // spacing between buttons
        HBox buttonsBox = new HBox(15);
        // center buttons
        buttonsBox.setAlignment(Pos.CENTER); 
        buttonsBox.getChildren().addAll(ofraBtn, yardenaBtn);

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(buttonsBox, scoreLabel);

        // Click action
        ofraBtn.setOnAction(e -> {
            // add to val
            voteCount++;
            scoreLabel.setText(String.valueOf(voteCount));
        });

        yardenaBtn.setOnAction(e -> {
            // retrive from val
            voteCount--;
            scoreLabel.setText(String.valueOf(voteCount));
        });

        
        Scene scene = new Scene(root, 300, 120);
        primaryStage.setTitle("Voting...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}