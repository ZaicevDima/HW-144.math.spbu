package group144.zaicev;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller for calculator
 */
public class Controller extends Calculator{
    /**
     * TextField - the window of your calculator, in which you write an expression
     */
    @FXML
    private TextField expression = new TextField();

    /** Button with 1 */
    @FXML
    Button button1 = new Button();

    /** Button with 2 */
    @FXML
    Button button2 = new Button();

    /** Button with 3 */
    @FXML
    Button button3 = new Button();

    /** Button with 4 */
    @FXML
    Button button4 = new Button();

    /** Button with 5 */
    @FXML
    Button button5 = new Button();

    /** Button with 6 */
    @FXML
    Button button6 = new Button();

    /** Button with 7 */
    @FXML
    Button button7 = new Button();

    /** Button with 8 */
    @FXML
    Button button8 = new Button();

    /** Button with 9 */
    @FXML
    Button button9 = new Button();

    /** Button with 0 */
    @FXML
    Button button0 = new Button();

    /** Button which clear the window of calculator */
    @FXML
    Button buttonClear = new Button();

    /** Button with + */
    @FXML
    Button buttonSum = new Button();

    /** Button with - */
    @FXML
    Button buttonMinus = new Button();

    /** Button with * */
    @FXML
    Button buttonMulti = new Button();

    /** Button with / */
    @FXML
    Button buttonDiv = new Button();

    /** Button with = */
    @FXML
    Button buttonResult = new Button();

    /** Button with ( */
    @FXML
    Button buttonOpenBracket = new Button();

    /** Button with ) */
    @FXML
    Button buttonCloseBracket = new Button();

    /**
     * Method, to press a button
     * @param button - Button, which you press
     */
    private void pressNumberButton(Button button) {
        button.setOnAction(event -> expression.textProperty().setValue(expression.textProperty().getValue().concat(button.getText())));
    }

    /** initialize */
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
        buttonResult.setOnAction(event -> {
            try {
                expression.textProperty().setValue(String.valueOf(calculate(expression.getText())));
            } catch (WrongExpressionException e) {
                expression.textProperty().setValue("Error, expression is incorrect");
            } catch (DivisionByZeroException e) {
                expression.textProperty().setValue("Error, division by 0");
            }
        });
    }
}
