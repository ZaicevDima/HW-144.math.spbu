package group144.zaicev;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller extends Calculator{
    @FXML
    private TextField expression = new TextField();

    @FXML
    Button button1 = new Button();

    @FXML
    Button button2 = new Button();

    @FXML
    Button button3 = new Button();

    @FXML
    Button button4 = new Button();

    @FXML
    Button button5 = new Button();

    @FXML
    Button button6 = new Button();

    @FXML
    Button button7 = new Button();

    @FXML
    Button button8 = new Button();

    @FXML
    Button button9 = new Button();

    @FXML
    Button button0 = new Button();

    @FXML
    Button buttonClear = new Button();

    @FXML
    Button buttonSum = new Button();

    @FXML
    Button buttonMinus = new Button();

    @FXML
    Button buttonMulti = new Button();

    @FXML
    Button buttonDiv = new Button();

    @FXML
    Button buttonResult = new Button();


    @FXML
    Button buttonOpenBracket = new Button();

    @FXML
    Button buttonCloseBracket = new Button();

    private void pressNumberButton(Button button) {
        button.setOnAction(event -> expression.textProperty().setValue(expression.textProperty().getValue().concat(button.getText())));
    }

    @FXML
    private void initialize() {
        pressNumberButton(button0);
        pressNumberButton(button1);
        pressNumberButton(button2);
        pressNumberButton(button3);
        pressNumberButton(button4);
        pressNumberButton(button5);
        pressNumberButton(button6);
        pressNumberButton(button7);
        pressNumberButton(button8);
        pressNumberButton(button9);
        pressNumberButton(buttonSum);
        pressNumberButton(buttonMinus);
        pressNumberButton(buttonMulti);
        pressNumberButton(buttonDiv);
        pressNumberButton(buttonOpenBracket);
        pressNumberButton(buttonCloseBracket);
        buttonClear.setOnAction(event -> expression.textProperty().setValue(""));
        buttonResult.setOnAction(event -> expression.textProperty().setValue(String.valueOf(calculate(expression.getText()))));
    }
}
