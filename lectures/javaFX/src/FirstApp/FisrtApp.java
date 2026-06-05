package FirstApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FisrtApp extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        // Stackpane - one container
        // Vbox - vertical containers
        StackPane root = new StackPane(makeLabel());
        // Create scene
        Scene scene = new Scene(root, 400, 400, Color.CRIMSON);
        // Choose scene
        arg0.setScene(scene);
        // Give name to it
        arg0.setTitle("FIRST APP");
        // Show it
        arg0.show();
    }

    private Node makeLabel() {
        Label label = new Label("Hello World!");
        Image image = new Image("./img.jpg");
        label.setGraphic(new ImageView(image));
        label.setFont(new Font("Cambria", 50));

        BackgroundFill bFill = new BackgroundFill(Color.GREY, new CornerRadii(10), null);
        Background bg =  new Background(bFill);
        label.setPadding(new Insets(50));
        label.setBackground(bg);

        return label;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
