import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

import java.util.Objects;

public class Lab4 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Pane drawingArea = new Pane();
        layout.setCenter(drawingArea);
        Scene scene = new Scene(layout, 700, 500);

        ShapeObjectsEditor shapeEditor = new ShapeObjectsEditor();

        MenuBar menuBar = createMenuBar(shapeEditor, scene, drawingArea);
        ToolBar toolBar = createToolBar(shapeEditor, scene, drawingArea);

        VBox menuAndToolbar = new VBox(menuBar, toolBar);
        layout.setTop(menuAndToolbar);

        stage.setScene(scene);
        stage.setTitle("Lab4");
        stage.show();
    }

    private MenuBar createMenuBar(ShapeObjectsEditor shapeEditor, Scene scene, Pane drawingArea) {
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");
        Menu shapes = createShapesMenu(shapeEditor, scene, drawingArea);
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        return menuBar;
    }

    private Menu createShapesMenu(ShapeObjectsEditor shapeEditor, Scene scene, Pane drawingArea) {
        Menu shapes = new Menu("Shapes");

        MenuItem point = createMenuItem("Point", () -> shapeEditor.startPointEditor(scene, drawingArea));
        MenuItem line = createMenuItem("Line", () -> shapeEditor.startLineEditor(scene, drawingArea));
        MenuItem ellipse = createMenuItem("Ellipse", () -> shapeEditor.startEllipseEditor(scene, drawingArea));
        MenuItem rectangle = createMenuItem("Rectangle", () -> shapeEditor.startRectangleEditor(scene, drawingArea));
        MenuItem cube = createMenuItem("Cube", () -> shapeEditor.startCubeEditor(scene, drawingArea));
        MenuItem lineOO = createMenuItem("LineOO", () -> shapeEditor.startLineOOEditor(scene, drawingArea));

        shapes.getItems().addAll(point, line, ellipse, rectangle, cube, lineOO);

        return shapes;
    }

    private MenuItem createMenuItem(String text, Runnable action) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(event -> action.run());
        return menuItem;
    }

    private ToolBar createToolBar(ShapeObjectsEditor shapeEditor, Scene scene, Pane drawingArea) {
        ToolBar toolBar = new ToolBar();

        toolBar.getItems().addAll(
                createToolbarButton("images/point.png", "Point", () -> shapeEditor.startPointEditor(scene, drawingArea)),
                createToolbarButton("images/line.png", "Line", () -> shapeEditor.startLineEditor(scene, drawingArea)),
                createToolbarButton("images/ellipse.png", "Ellipse", () -> shapeEditor.startEllipseEditor(scene, drawingArea)),
                createToolbarButton("images/rectangle.png", "Rectangle", () -> shapeEditor.startRectangleEditor(scene, drawingArea)),
                createToolbarButton("images/cube.png", "Cube", () -> shapeEditor.startCubeEditor(scene, drawingArea)),
                createToolbarButton("images/lineOO.png", "LineOO", () -> shapeEditor.startLineOOEditor(scene, drawingArea))
        );

        return toolBar;
    }

    private Button createToolbarButton(String imagePath, String tooltipText, Runnable action) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        ImageView imageView = new ImageView(image);

        Button button = new Button();
        button.setGraphic(imageView);

        Tooltip tooltip = new Tooltip(tooltipText);
        Tooltip.install(button, tooltip);

        button.setOnAction(event -> action.run());

        return button;
    }
}
