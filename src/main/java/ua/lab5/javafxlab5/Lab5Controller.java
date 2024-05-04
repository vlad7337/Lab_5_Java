package ua.lab5.javafxlab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ua.lab5.javafxlab5.functions.MyFunctions;
import ua.lab5.javafxlab5.functions.core.Function;

import java.text.NumberFormat;

public class Lab5Controller {
    @FXML
    private Label calculateLabel, derivativeFuncLabel, funcLabel;
    @FXML
    private TextField textFieldX, textFieldBeginGraph, textFieldEndGraph;
    @FXML
    private ToggleGroup SelectFunc;
    @FXML
    private RadioButton rb1, rb2;
    @FXML
    private TabPane tabPane;



    private Function func = MyFunctions.firstFunction();

    @FXML
    protected void onSelectButtonClick(){
        RadioButton selectfunc = (RadioButton) SelectFunc.getSelectedToggle();
        funcLabel.setText(selectfunc.getText());
    }
    @FXML
    protected void onCalculateButtonClick() {
        if (rb1.isSelected()){
            func = MyFunctions.firstFunction();
        }
        else if (rb2.isSelected()){
            func = MyFunctions.secondFunction();
        }
        calculateLabel.setText(String.format("%s", func.calculate(Double.parseDouble(textFieldX.getText()))));
    }

    @FXML
    protected void onDerivativeButtonClick(){
        if (rb1.isSelected()){
            func = MyFunctions.firstFunction();
        }
        else if (rb2.isSelected()){
            func = MyFunctions.secondFunction();
        }
        derivativeFuncLabel.setText(String.format("%s", func.derivative().toPrettyString(NumberFormat.getInstance())));
    }
}
