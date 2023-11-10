package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CubeShape extends Shape {
    private Rectangle frontRectangle;
    private Rectangle backRectangle;
    public CubeShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            frontRectangle = new Rectangle();
            frontRectangle.setX(event.getX());
            frontRectangle.setY(event.getY());
            frontRectangle.setWidth(0);
            frontRectangle.setHeight(0);
            frontRectangle.setStroke(Color.BLACK);
            frontRectangle.setStrokeWidth(1.5);
            frontRectangle.setFill(null);
            root.getChildren().add(frontRectangle);

            backRectangle = new Rectangle();
            backRectangle.setX(event.getX() + 50);
            backRectangle.setY(event.getY() - 50);
            backRectangle.setWidth(0);
            backRectangle.setHeight(0);
            backRectangle.setStroke(Color.BLACK);
            backRectangle.setStrokeWidth(1.5);
            backRectangle.setFill(null);
            root.getChildren().add(backRectangle);
        });

        root.setOnMouseDragged(event -> {
            if (frontRectangle != null) {
                frontRectangle.setWidth(event.getX() - frontRectangle.getX());
                frontRectangle.setHeight(event.getY() - frontRectangle.getY());

                backRectangle.setX(frontRectangle.getX() + 50);
                backRectangle.setY(frontRectangle.getY() - 50);
                backRectangle.setWidth(frontRectangle.getWidth());
                backRectangle.setHeight(frontRectangle.getHeight());
            }
        });

        root.setOnMouseReleased(event -> {
            frontRectangle.getStrokeDashArray().clear();
            frontRectangle = null;
        });
    }
}
