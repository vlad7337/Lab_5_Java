package ua.lab5.javafxlab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import ua.lab5.javafxlab5.functions.MyFunctions;
import ua.lab5.javafxlab5.functions.core.Function;

public class Lab5Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    private Function func = MyFunctions.firstFunction();

    @FXML
    public void init(){
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
    }

    @FXML
    protected void onSelectButtonClick() {
        welcomeText.setText(String.format("%s", func.calculate(1.65)));
    }
}
