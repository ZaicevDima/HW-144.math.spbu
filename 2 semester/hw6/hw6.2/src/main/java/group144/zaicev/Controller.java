package group144.zaicev;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 *  Controller for tic tac toe game
 */
public class Controller extends CheckingWin {

    /**
     * Label - The screen on which the current state is recorded
     */
    @FXML
    Label screen = new Label();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button1 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button2 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button3 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button4 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button5 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button6 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button7 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button8 = new Button();

    /**
     * Button - The cell from panel
     */
    @FXML
    Button button9 = new Button();

    /**
     * Method, to press a button
     * @param button - The button which you press
     */
    private  void pressToButton(Button button) {
        button.setOnAction(event -> Game(button));
    }

    /** initialize */
    public void initialize() {
        this.amountUsedButtons = 0;
        screen.setText("X player makes a move");
        pressToButton(button1);
        pressToButton(button2);
        pressToButton(button3);
        pressToButton(button4);
        pressToButton(button5);
        pressToButton(button6);
        pressToButton(button7);
        pressToButton(button8);
        pressToButton(button9);
    }

    private int amountUsedButtons = 0;

    /**
     * Method, which realize the change after a button clicked
     * @param button - The button which you clicked
     */
    private void Game(Button button) {
        if ((screen.getText().charAt(0) == 'X') && (button.getText().equals(""))) {
            button.setText("X");
            amountUsedButtons++;
            this.screen.setText("O player makes a move");
        } else if (button.getText().equals("")){
            button.setText("O");
            amountUsedButtons++;
            this.screen.setText("X player makes a move");
        }

        Button[][] buttons = new Button[][] {{button1, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}};
        String[][] valueFromButtons = new String[][]{{button1.getText(), button2.getText(), button3.getText()},
                {button4.getText(), button5.getText(), button6.getText()},
                {button7.getText(), button8.getText(), button9.getText()}};
        if (isWinner(valueFromButtons)) {
            this.screen.setText(button.getText().concat(" Winner"));
            newGame(buttons);
        }

        if ((amountUsedButtons == 9) && ((!screen.getText().equals("O Winner"))
                || (!screen.getText().equals("X Winner")))) {
            this.screen.setText("Draw");
            newGame(buttons);
        }
    }

    /**
     * Method, which open exit window
     * Window has two button: YES or NO
     * If you click on YES game will continue (buttons and screen will become empty), else game will finish.
     * @param buttons cells from panel
     */
    private void newGame(Button[][] buttons) {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "File already exists. Do you want to override?",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("exit");
        if (screen.getText().equals("Draw")) {
            alert.setHeaderText("Draw");
        } else {
            alert.setHeaderText(screen.getText().charAt(0) + " Winner");
        }

        alert.setContentText("Did you want start the game again?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.NO) {
                System.exit(0);
            }

            if (response == ButtonType.YES) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        this.amountUsedButtons = 0;
                        buttons[i][j].setText("");
                        screen.setText("X player makes a move");
                    }
                }
            }
        });
    }
}
