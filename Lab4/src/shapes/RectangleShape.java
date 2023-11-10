package shapes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends Shape {
    private Rectangle currentRectangle = new Rectangle();

    public RectangleShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(this::handle);

        root.setOnMouseDragged(event -> {
            if (currentRectangle != null) {
                currentRectangle.setWidth(event.getX() - currentRectangle.getX());
                currentRectangle.setHeight(event.getY() - currentRectangle.getY());
            }
        });
    }

    private void handle(MouseEvent event) {
        currentRectangle = new Rectangle();
        addRect(event, currentRectangle, root.getChildren());
    }

    protected static void addRect(MouseEvent event, Rectangle currentRectangle, ObservableList<Node> children) {
        currentRectangle.setX(event.getX());
        currentRectangle.setY(event.getY());
        currentRectangle.setWidth(0);
        currentRectangle.setHeight(0);
        currentRectangle.setStroke(Color.BLACK);
        currentRectangle.setStrokeWidth(1.5);
        currentRectangle.setFill(null);
        children.add(currentRectangle);
    }
}
