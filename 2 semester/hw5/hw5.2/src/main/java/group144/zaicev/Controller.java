package group144.zaicev;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/** Controller for calculator */
public class Controller {

    /** Spinner - first operator in expression*/
    @FXML
    private Spinner<Integer> operandSpinner1 = new Spinner<>();

    /** Spinner - second operator in expression*/
    @FXML
    private Spinner<Integer> operandSpinner2 = new Spinner<>();

    /** Your arithmetic sign choice */
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    /** Result your expression */
    @FXML
    private TextField resultExpression = new TextField();

    /**
     * calculate and write in resultExpression result your expression
     */
    private void calculate() {
        double result = 0;
        int firstOperand = operandSpinner1.getValue();
        int secondOperand = operandSpinner2.getValue();
        switch (choiceBox.getValue()) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = (double) firstOperand / secondOperand;
        }
        resultExpression.textProperty().setValue(Double.toString(result));
    }

    /** initialize */
    @FXML
    public void initialize() {
        operandSpinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-10000, 10000, 0));
        operandSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-10000, 10000, 0));
        choiceBox.setItems(FXCollections.observableArrayList("+", "-", "*", "/"));
        choiceBox.valueProperty().setValue("+");
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        operandSpinner1.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        operandSpinner2.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
    }
}
