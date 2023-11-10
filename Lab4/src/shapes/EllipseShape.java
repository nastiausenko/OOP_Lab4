package shapes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Shapes {
    private Ellipse currentEllipse;

    public EllipseShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(this::handle);

        root.setOnMouseDragged(event -> {
            if (currentEllipse != null) {
                currentEllipse.setRadiusX(event.getX() - currentEllipse.getCenterX());
                currentEllipse.setRadiusY(event.getY() - currentEllipse.getCenterY());
            }
        });

        root.setOnMouseReleased(event -> {
            clear(currentEllipse);
            currentEllipse.setFill(Color.LIGHTGRAY);
        });
    }

    private void handle(MouseEvent event) {
        currentEllipse = new Ellipse();
        show(event, root.getChildren(), currentEllipse);
    }

    protected static void show(MouseEvent event, ObservableList<Node> children, Ellipse... ellipses) {
        for (Ellipse currentEllipse: ellipses) {
            currentEllipse.setCenterX(event.getX());
            currentEllipse.setCenterY(event.getY());
            currentEllipse.setRadiusX(0);
            currentEllipse.setRadiusY(0);
            currentEllipse.setStroke(Color.BLACK);
            currentEllipse.setStrokeWidth(1.5);
            currentEllipse.setFill(null);
            children.add(currentEllipse);
        }
    }
}
