package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Shape {
    protected Scene scene;
    protected Pane root;
    public abstract void draw();

    public Shape(Scene scene, Pane root) {
        this.scene = scene;
        this.root = root;
    }
}