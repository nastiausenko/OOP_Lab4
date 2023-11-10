package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class PointShape extends Shape {
    private Ellipse currentPoint;

    public PointShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentPoint = new Ellipse();
            currentPoint.setCenterX(event.getX());
            currentPoint.setCenterY(event.getY());
            currentPoint.setRadiusX(5);
            currentPoint.setRadiusY(5);
            currentPoint.setFill(Color.BLACK);
            root.getChildren().add(currentPoint);
        });

        root.setOnMouseReleased(event -> currentPoint = null);
    }
}
