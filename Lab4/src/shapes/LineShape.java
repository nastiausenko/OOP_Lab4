package shapes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape extends Shapes {

    private Line currentLine;
    public LineShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(this::handle);

        root.setOnMouseDragged(event -> {
            if (currentLine != null) {
                currentLine.setEndX(event.getX());
                currentLine.setEndY(event.getY());
            }
        });

        root.setOnMouseReleased(event -> currentLine = null);
    }

    private void handle(MouseEvent event) {
        currentLine = new Line();
        show(event, root.getChildren(), currentLine);
    }

    static void show(MouseEvent event, ObservableList<Node> children, Line... lines) {
        for (Line currentLine: lines) {
            currentLine.setStartX(event.getX());
            currentLine.setStartY(event.getY());
            currentLine.setEndX(event.getX());
            currentLine.setEndY(event.getY());
            currentLine.setStroke(Color.BLACK);
            currentLine.setStrokeWidth(1.5);
            children.add(currentLine);
        }
    }
}
