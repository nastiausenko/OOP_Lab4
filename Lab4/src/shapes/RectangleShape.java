package shapes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends Shapes {
    private Rectangle currentRectangle = new Rectangle();

    public RectangleShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(this::handle);

        root.setOnMouseDragged(event -> {
            if (currentRectangle != null) {
                dragged(event, currentRectangle);
            }
        });

        root.setOnMouseReleased(event -> {
            clear(currentRectangle);
        });
    }

    protected void show(MouseEvent event, ObservableList<Node> children, Rectangle... rectangles) {
        for (Rectangle currentRectangle: rectangles) {
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

    private void handle(MouseEvent event) {
        currentRectangle = new Rectangle();
        show(event, root.getChildren(), currentRectangle);
    }

    protected void dragged(MouseEvent event, Rectangle currentRectangle) {
        dashed(currentRectangle);
        currentRectangle.setWidth(event.getX() - currentRectangle.getX());
        currentRectangle.setHeight(event.getY() - currentRectangle.getY());
    }
}
