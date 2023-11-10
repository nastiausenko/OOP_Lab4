package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class LineOOShape extends LineShape {
    private Line currentLine;
    private Ellipse ellipse1, ellipse2;
    private final int radius = 10;

    public LineOOShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentLine = new Line();
            addLine(event, currentLine, root.getChildren());

            ellipse1 = new Ellipse();
            ellipse1.setCenterX(currentLine.getStartX());
            ellipse1.setCenterY(currentLine.getStartY());
            ellipse1.setRadiusX(radius);
            ellipse1.setRadiusY(radius);
            ellipse1.setFill(Color.WHITESMOKE);
            ellipse1.setStroke(Color.BLACK);
            ellipse1.setStrokeWidth(1.5);

            ellipse2 = new Ellipse();
            ellipse2.setCenterX(currentLine.getEndX());
            ellipse2.setCenterY(currentLine.getEndY());
            ellipse2.setRadiusX(radius);
            ellipse2.setRadiusY(radius);
            ellipse2.setStrokeWidth(1.5);
            ellipse2.setFill(Color.WHITESMOKE);
            ellipse2.setStroke(Color.BLACK);

            root.getChildren().add(ellipse2);
            root.getChildren().add(ellipse1);
        });

        root.setOnMouseDragged(event -> {
            dashed(ellipse1);
            dashed(ellipse2);
            dashed(currentLine);

            ellipse1.setCenterX(currentLine.getStartX());
            ellipse1.setCenterY(currentLine.getStartY());
            ellipse1.setRadiusX(radius);
            ellipse1.setRadiusY(radius);

            currentLine.setEndX(event.getX());
            currentLine.setEndY(event.getY());

            ellipse2.setCenterX(currentLine.getEndX());
            ellipse2.setCenterY(currentLine.getEndY());
            ellipse2.setRadiusX(radius);
            ellipse2.setRadiusY(radius);


        });

        root.setOnMouseReleased(event -> {
            currentLine.getStrokeDashArray().clear();
            ellipse1.getStrokeDashArray().clear();
            ellipse2.getStrokeDashArray().clear();
        });
    }
}
