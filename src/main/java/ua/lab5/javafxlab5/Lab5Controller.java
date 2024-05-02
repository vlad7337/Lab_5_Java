package ua.lab5.javafxlab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import ua.lab5.javafxlab5.functions.MyFunctions;
import ua.lab5.javafxlab5.functions.core.Function;

public class Lab5Controller {
    @FXML
    private Label calculateLabel;

    private Function func = MyFunctions.firstFunction();

    @FXML
    protected void onSelectButtonClick() {
        calculateLabel.setText(String.format("%s", func.calculate(1.65)));
    }
}
