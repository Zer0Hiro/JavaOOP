package images;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnimatedDisplayer extends Application {

    // Set the window size to match your background dimensions
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) {
        WritableImage writableImage = new WritableImage(WIDTH, HEIGHT);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        ImageView imageView = new ImageView(writableImage);

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Animated Space Nebula");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            private double time = 0;

            @Override
            public void handle(long now) {
                // Move time forward
                time += 0.05; 

                // 1. Create the background
                Image i1 = new Gradient(WIDTH, HEIGHT, RGB.BLUE, RGB.BLACK);
                Image i2 = new Transpose(new Gradient(WIDTH, HEIGHT, RGB.RED, RGB.BLACK));
                Image i3 = new Mix(i1, i2, 0.5);

                
                // Yellow circle: make it fly in a circular orbit
                int x4 = 175 + (int)(Math.cos(time) * 50); // Moves left/right by 50px
                int y4 = 175 + (int)(Math.sin(time) * 50); // Moves up/down by 50px
                Image i4 = new Circle(WIDTH, HEIGHT, x4, y4, 150, new RGB(1, 1, 0), RGB.BLACK);

                // Blue circle: make it fly in a figure-eight shape 
                int x5 = 100 + (int)(Math.sin(time * 1.5) * 60);
                int y5 = 100 + (int)(Math.cos(time * 0.8) * 40);
                Image i5 = new Circle(WIDTH, HEIGHT, x5, y5, 100, new RGB(0, 0.5, 1), RGB.BLACK);

                // White circle backround center
                int r6 = 200 + (int)(Math.sin(time * 3) * 35); // Radius varies from 185 to 215
                Image i6 = new Circle(WIDTH, HEIGHT, 250, 250, r6, RGB.WHITE, RGB.BLACK);

                // Combine everything into one image
                Image i7 = new Superpose(i3, i4);
                Image i8 = new Superpose(i5, i6);
                Image finalImage = new Superpose(i7, i8);

                // Draw the frame pixel by pixel
                for (int x = 0; x < WIDTH; x++) {
                    for (int y = 0; y < HEIGHT; y++) {
                        
                        // Get the color from final composite image
                        RGB pixelColor = finalImage.get(x, y);
                        
                        // if Superpose outputs values greater than 1.0
                        double r = Math.min(1.0, Math.max(0.0, pixelColor.getRed()));
                        double g = Math.min(1.0, Math.max(0.0, pixelColor.getGreen()));
                        double b = Math.min(1.0, Math.max(0.0, pixelColor.getBlue()));
                        
                        pixelWriter.setColor(x, y, Color.color(r, g, b));
                    }
                }
            }
        };
        
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}