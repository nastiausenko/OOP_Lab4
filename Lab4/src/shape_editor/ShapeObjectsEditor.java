package shape_editor;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import shapes.*;

public class ShapeObjectsEditor {

    public void startRectangleEditor(Scene scene, Pane root) {
        Shape rectangle = new RectangleShape(scene, root);
        rectangle.draw();
    }

    public void startLineEditor(Scene scene, Pane root){
        Shape line= new LineShape(scene, root);
        line.draw();
    }

    public void startPointEditor(Scene scene, Pane root){
        Shape point = new PointShape(scene, root);
        point.draw();
    }

    public void startEllipseEditor(Scene scene, Pane root){
        Shape ellipseShape = new EllipseShape(scene, root);
        ellipseShape.draw();
    }
}