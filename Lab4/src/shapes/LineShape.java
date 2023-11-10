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
        addLine(event, currentLine, root.getChildren());
    }

    static void addLine(MouseEvent event, Line currentLine, ObservableList<Node> children) {
        currentLine.setStartX(event.getX());
        currentLine.setStartY(event.getY());
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
        currentLine.setStroke(Color.BLACK);
        currentLine.setStrokeWidth(1.5);
        children.add(currentLine);
    }
}
