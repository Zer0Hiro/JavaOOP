package mines;

import javafx.scene.control.Button;

public class MineButton extends Button {
    private final int x;
    private final int y;

    public MineButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.setPrefSize(40, 40); 
        this.setMinSize(40, 40);
        this.setText(".");
    }

    public int getX() { return x; }
    public int getY() { return y; }
}