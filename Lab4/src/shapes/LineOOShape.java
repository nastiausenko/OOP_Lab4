package shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import shapes.interfaces.Drawable;

public class LineOOShape extends LineShape implements Drawable {
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
            show(event, root.getChildren(), currentLine);

            ellipse1 = new Ellipse();
            ellipse2 = new Ellipse();
            show(event, root.getChildren(), ellipse1, ellipse2);

            ellipse1.setRadiusX(radius);
            ellipse1.setRadiusY(radius);
            ellipse1.setFill(Color.WHITESMOKE);
        });

        root.setOnMouseDragged(event -> {
            if (currentLine != null) {
                dashed(ellipse1, ellipse2, currentLine);
                dragged(event, currentLine);

                ellipse2.setCenterX(currentLine.getEndX());
                ellipse2.setCenterY(currentLine.getEndY());
                ellipse2.setRadiusX(radius);
                ellipse2.setRadiusY(radius);
                ellipse2.setFill(Color.WHITESMOKE);
            }
        });

        root.setOnMouseReleased(event -> {
            clear(currentLine, ellipse1, ellipse2);
            ellipse1 = null;
            ellipse2 = null;
            currentLine = null;
        });
    }
}
