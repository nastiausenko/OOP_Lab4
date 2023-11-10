package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Shape{
    private Ellipse currentEllipse;

    public EllipseShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentEllipse = new Ellipse();
            currentEllipse.setCenterX(event.getX() - currentEllipse.getCenterX());
            currentEllipse.setCenterY(event.getY() - currentEllipse.getCenterY());
            currentEllipse.setRadiusX(0);
            currentEllipse.setRadiusY(0);
            currentEllipse.setStroke(Color.BLACK);
            currentEllipse.setStrokeWidth(1.5);
            currentEllipse.setFill(null);
            root.getChildren().add(currentEllipse);
        });

        root.setOnMouseDragged(event -> {
            if (currentEllipse != null) {
                currentEllipse.setRadiusX(event.getX() - currentEllipse.getCenterX());
                currentEllipse.setRadiusY(event.getY() - currentEllipse.getCenterY());
            }
        });

        root.setOnMouseReleased(event -> {
            currentEllipse.getStrokeDashArray().clear();
            currentEllipse.setFill(Color.LIGHTGRAY);
            currentEllipse = null;
        });

    }
}
