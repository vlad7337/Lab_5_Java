package ua.lab5.javafxlab5;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import ua.lab5.javafxlab5.functions.MyFunctions;
import ua.lab5.javafxlab5.functions.core.Function;

import java.text.NumberFormat;
import java.util.List;

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
    @FXML
    private LineChart lineChart;

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
        String derivative = func.derivative().toPrettyString(NumberFormat.getInstance());
        derivative = derivative.replaceAll("\\s+", "");
        derivative = derivative.replaceAll("\\*1.0", "");
        derivativeFuncLabel.setText(String.format("%s", derivative));
    }

    @FXML
    protected void onBuildButtonClick(){
        tabPane.getSelectionModel().select(1);
        if (rb1.isSelected()){
            func = MyFunctions.firstFunction();
        }
        else if (rb2.isSelected()){
            func = MyFunctions.secondFunction();
        }
        List<Double> pointsRange = MyFunctions.getPointsInRange(Double.parseDouble(textFieldBeginGraph.getText()), Double.parseDouble(textFieldEndGraph.getText()), 100, func);
//
//        final XYChart.Series<String, Double> series = new XYChart.Series<>();
//        series.setName(null);
//        for (int i = 0; i < 100; i++) {
//            final double x = pointsRange.get(i);
//            final double y = pointsRange.get(i + 1);
//            series.getData().add(new XYChart.Data<>(String.format("%.2f", x), y));
//            lineChart.getData().add(series);
//        }
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < 200; i+=2) {
            series.getData().add(new XYChart.Data(String.format("%s", pointsRange.get(i)), pointsRange.get(i+1)));
        }

        lineChart.getData().add(series);
    }
}
