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
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Pane drawingArea = new Pane();
        layout.setCenter(drawingArea);
        Scene scene = new Scene(layout, 700, 500);

        ShapeObjectsEditor shapeEditor = new ShapeObjectsEditor();

        MenuBar menuBar = new MenuBar();
        drawingArea.setMaxHeight(scene.getHeight() - menuBar.getHeight());
        Menu file = new Menu("File");
        Menu shapes = new Menu("Shapes");
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        CheckMenuItem point = new CheckMenuItem("Point");
        CheckMenuItem line = new CheckMenuItem("Line");
        CheckMenuItem ellipse = new CheckMenuItem("Ellipse");
        CheckMenuItem rectangle = new CheckMenuItem("Rectangle");
        CheckMenuItem cube = new CheckMenuItem("Cube");
        CheckMenuItem lineOO = new CheckMenuItem("LineOO");


        shapes.getItems().addAll(point, line, ellipse, rectangle, cube, lineOO);

        ToolBar toolBar = new ToolBar();
        Button btnPoint = createToolbarButton("images/point.png", "Point");
        Button btnLine = createToolbarButton("images/line.png", "Line");
        Button btnEllipse = createToolbarButton("images/ellipse.png", "Ellipse");
        Button btnRectangle = createToolbarButton("images/rectangle.png", "Rectangle");

        toolBar.getItems().addAll(btnPoint, btnLine, btnEllipse, btnRectangle);

        VBox menuAndToolbar = new VBox(menuBar, toolBar);
        layout.setTop(menuAndToolbar);

        rectangle.setOnAction(actionEvent -> {
            shapeEditor.startRectangleEditor(scene, drawingArea);
            selection(rectangle, point, ellipse, line);
        });
        line.setOnAction(actionEvent -> {
            shapeEditor.startLineEditor(scene, drawingArea);
            selection(line, point, ellipse, rectangle);
        });
        point.setOnAction(actionEvent -> {
            shapeEditor.startPointEditor(scene, drawingArea);
            selection(point, line, ellipse, rectangle);
        });
        ellipse.setOnAction(actionEvent ->{
            shapeEditor.startEllipseEditor(scene, drawingArea);
            selection(ellipse, line, point, rectangle);
        });
        cube.setOnAction(actionEvent ->{
            shapeEditor.startCubeEditor(scene, drawingArea);
            selection(ellipse, line, point, rectangle);
        });
        lineOO.setOnAction(actionEvent ->{
            shapeEditor.startLineOOEditor(scene, drawingArea);
            selection(ellipse, line, point, rectangle);
        });

        btnRectangle.setOnAction(actionEvent -> shapeEditor.startRectangleEditor(scene, drawingArea));
        btnLine.setOnAction(actionEvent -> shapeEditor.startLineEditor(scene, drawingArea));
        btnPoint.setOnAction(actionEvent -> shapeEditor.startPointEditor(scene, drawingArea));
        btnEllipse.setOnAction(actionEvent -> shapeEditor.startEllipseEditor(scene, drawingArea));

        stage.setScene(scene);
        stage.setTitle("Lab4");
        stage.show();
    }

    private void selection(CheckMenuItem selectedItem, CheckMenuItem... others) {
        selectedItem.setSelected(true);
        for (CheckMenuItem item : others) {
            item.setSelected(false);
        }
    }

    private Button createToolbarButton(String imagePath, String tooltipText) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        ImageView imageView = new ImageView(image);

        Button button = new Button();
        button.setGraphic(imageView);

        Tooltip tooltip = new Tooltip(tooltipText);
        Tooltip.install(button, tooltip);

        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}