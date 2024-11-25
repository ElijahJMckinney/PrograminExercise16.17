package progexec;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorSliderApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label to display the text whose color will change
        Label colorText = new Label("Adjust the sliders to change the text color!");
        colorText.setStyle("-fx-font-size: 24px;");

        // Create sliders for red, green, blue, and opacity
        Slider redSlider = new Slider(0, 255, 0);
        redSlider.setBlockIncrement(1);
        redSlider.setShowTickMarks(true);
        redSlider.setShowTickLabels(true);

        Slider greenSlider = new Slider(0, 255, 0);
        greenSlider.setBlockIncrement(1);
        greenSlider.setShowTickMarks(true);
        greenSlider.setShowTickLabels(true);

        Slider blueSlider = new Slider(0, 255, 0);
        blueSlider.setBlockIncrement(1);
        blueSlider.setShowTickMarks(true);
        blueSlider.setShowTickLabels(true);

        Slider opacitySlider = new Slider(0, 1, 1);
        opacitySlider.setBlockIncrement(0.01);
        opacitySlider.setShowTickMarks(true);
        opacitySlider.setShowTickLabels(true);

        // Create a VBox layout to hold the sliders and the text label
        VBox vbox = new VBox(10, colorText, redSlider, greenSlider, blueSlider, opacitySlider);
        vbox.setStyle("-fx-padding: 20;");

        // Add listeners to the sliders to update the text color dynamically
        redSlider.valueProperty().addListener((obs, oldValue, newValue) -> updateColor(colorText, redSlider, greenSlider, blueSlider, opacitySlider));
        greenSlider.valueProperty().addListener((obs, oldValue, newValue) -> updateColor(colorText, redSlider, greenSlider, blueSlider, opacitySlider));
        blueSlider.valueProperty().addListener((obs, oldValue, newValue) -> updateColor(colorText, redSlider, greenSlider, blueSlider, opacitySlider));
        opacitySlider.valueProperty().addListener((obs, oldValue, newValue) -> updateColor(colorText, redSlider, greenSlider, blueSlider, opacitySlider));

        // Set up the scene
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to update the color of the label based on slider values
    private void updateColor(Label label, Slider redSlider, Slider greenSlider, Slider blueSlider, Slider opacitySlider) {
        // Get the values from the sliders
        double red = redSlider.getValue() / 255;
        double green = greenSlider.getValue() / 255;
        double blue = blueSlider.getValue() / 255;
        double opacity = opacitySlider.getValue();

        // Update the color of the label text
        label.setTextFill(Color.color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
