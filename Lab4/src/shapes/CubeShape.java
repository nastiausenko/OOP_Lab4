package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CubeShape extends RectangleShape {
    private Rectangle frontRectangle, backRectangle;
    private Line line1, line2, line3, line4;

    public CubeShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            frontRectangle = new Rectangle();
            backRectangle = new Rectangle();
            line1 = new Line();
            line2 = new Line();
            line3 = new Line();
            line4 = new Line();

            addRect(event, frontRectangle, root.getChildren());
            addRect(event, backRectangle, root.getChildren());
            LineShape.addLine(event, line1, root.getChildren());
            LineShape.addLine(event, line2, root.getChildren());
            LineShape.addLine(event, line3, root.getChildren());
            LineShape.addLine(event, line4, root.getChildren());

            backRectangle.setX(event.getX() + frontRectangle.getWidth() / 2);
            backRectangle.setY(event.getY() - frontRectangle.getHeight() / 2);
        });

        root.setOnMouseDragged(event -> {
            if (frontRectangle != null) {
                frontRectangle.setWidth(event.getX() - frontRectangle.getX());
                frontRectangle.setHeight(event.getY() - frontRectangle.getY());

                dashed(frontRectangle);
                dashed(backRectangle);
                dashed(line1);
                dashed(line2);
                dashed(line3);
                dashed(line4);

                backRectangle.setX(frontRectangle.getX() + frontRectangle.getWidth() / 2);
                backRectangle.setY(frontRectangle.getY() - frontRectangle.getHeight() / 2);
                backRectangle.setWidth(frontRectangle.getWidth());
                backRectangle.setHeight(frontRectangle.getHeight());

                line1.setEndX(backRectangle.getX());
                line1.setEndY(backRectangle.getY());

                line2.setStartY(frontRectangle.getY() + frontRectangle.getHeight());
                line2.setEndX(backRectangle.getX());
                line2.setEndY(backRectangle.getY() + backRectangle.getHeight());

                line3.setStartX(frontRectangle.getX() + frontRectangle.getWidth());
                line3.setStartY(frontRectangle.getY());
                line3.setEndX(backRectangle.getX() + backRectangle.getWidth());
                line3.setEndY(backRectangle.getY());

                line4.setStartX(frontRectangle.getX() + frontRectangle.getWidth());
                line4.setStartY(frontRectangle.getY() + frontRectangle.getHeight());
                line4.setEndX(backRectangle.getX() + backRectangle.getWidth());
                line4.setEndY(backRectangle.getY() + backRectangle.getHeight());
            }
        });

        root.setOnMouseReleased(event -> {
            frontRectangle.getStrokeDashArray().clear();
            backRectangle.getStrokeDashArray().clear();
            line1.getStrokeDashArray().clear();
            line2.getStrokeDashArray().clear();
            line3.getStrokeDashArray().clear();
            line4.getStrokeDashArray().clear();
        });
    }
}
