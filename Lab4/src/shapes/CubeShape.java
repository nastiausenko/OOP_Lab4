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
            RectangleShape.addRect(event, frontRectangle, root.getChildren());

            backRectangle = new Rectangle();
            backRectangle.setX(event.getX() + frontRectangle.getWidth()/2);
            backRectangle.setY(event.getY() - frontRectangle.getHeight()/2);
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

                backRectangle.setX(frontRectangle.getX() + frontRectangle.getWidth()/2);
                backRectangle.setY(frontRectangle.getY() - frontRectangle.getHeight()/2);
                backRectangle.setWidth(frontRectangle.getWidth());
                backRectangle.setHeight(frontRectangle.getHeight());
            }
        });
    }
}
