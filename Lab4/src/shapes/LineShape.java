package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape extends Shape {

    private Line currentLine;
    public LineShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentLine = new Line();
            currentLine.setStartX(event.getX());
            currentLine.setStartY(event.getY());
            currentLine.setEndX(event.getX());
            currentLine.setEndY(event.getY());
            currentLine.setStroke(Color.BLACK);
            currentLine.setStrokeWidth(1.5);
            root.getChildren().add(currentLine);
        });

        root.setOnMouseDragged(event -> {
            if (currentLine != null) {
                currentLine.setEndX(event.getX());
                currentLine.setEndY(event.getY());
            }
        });
        root.setOnMouseReleased(event -> currentLine = null);
    }
}
