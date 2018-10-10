package group144.zaicev;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Math.abs;

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
     * Button - The button for new game
     */
    @FXML
    Button newGame = new Button();

    /**
     * Button - The button for game with computer
     */
    @FXML
    Button computerGame = new Button();


    /**
     * Method, to press a button
     * @param button - The button which you press
     */
    private  void pressToButton(Button button, boolean isComputer) {
        button.setOnAction(event -> Game(button, isComputer));
    }

    private void pressToButtons(boolean isComputer) {
        pressToButton(button1, isComputer);
        pressToButton(button2, isComputer);
        pressToButton(button3, isComputer);
        pressToButton(button4, isComputer);
        pressToButton(button5, isComputer);
        pressToButton(button6, isComputer);
        pressToButton(button7, isComputer);
        pressToButton(button8, isComputer);
        pressToButton(button9, isComputer);
    }

    /** initialize */
    public void initialize() {
        AtomicBoolean isComputer = new AtomicBoolean(false);
        this.amountUsedButtons = 0;
        screen.setText("X player makes a move");
        pressToButtons(isComputer.get());


        newGame.setOnAction(event -> {
            button1.setText("");
            button2.setText("");
            button3.setText("");
            button4.setText("");
            button5.setText("");
            button6.setText("");
            button7.setText("");
            button8.setText("");
            button9.setText("");
            amountUsedButtons = 0;
            screen.setText("X player makes a move");
        });

        AtomicBoolean isPressed = new AtomicBoolean(false);
        computerGame.setOnAction(event -> {
            isComputer.set(true);
            isPressed.set(true);
            pressToButtons(isComputer.get());
        });

        if (!isPressed.get()) {
            pressToButtons(false);
        }


    }

    private int amountUsedButtons = 0;

    enum State {
        COMPUTER,
        USER,
        CHECKING
    }

    private State currentState = State.USER;

    /**
     * Method, which realize the change after a button clicked
     * @param button - The button which you clicked
     */
    private void Game(Button button, boolean isComputer) {
        Button[][] buttons = new Button[][] {{button1, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}};
        String[][] valueFromButtons = new String[][]{{button1.getText(), button2.getText(), button3.getText()},
                {button4.getText(), button5.getText(), button6.getText()},
                {button7.getText(), button8.getText(), button9.getText()}};
        /*boolean wasUser = amountUsedButtons % 2 == 0;
        switch (currentState) {
            case CHECKING:
                if (isWinner(valueFromButtons)) {
                    this.screen.setText(button.getText().concat(" Winner"));
                    newGame(buttons);
                }

                if ((amountUsedButtons == 9) && ((!screen.getText().equals("O Winner"))
                        || (!screen.getText().equals("X Winner")))) {
                    this.screen.setText("Draw");
                    newGame(buttons);
                }
                if (!isComputer) {
                    currentState = State.USER;
                } else if (wasUser) {
                    currentState = State.COMPUTER;
                }
        }
        */if (isComputer) {

            Random random = new Random();
            int i = abs(random.nextInt()) % 3;
            int j = abs(random.nextInt()) % 3;

            System.out.println(i + " " + j);
            while (!buttons[i][j].getText().equals("")) {

                i = abs(random.nextInt()) % 3;
                j = abs(random.nextInt()) % 3;
            }
            buttons[i][j].setText("O");
            screen.setText("X player makes a move");
            amountUsedButtons++;
        }

        if ((amountUsedButtons % 2 == 1) && (screen.getText().charAt(0) == 'X') && (button.getText().equals(""))) {
            button.setText("X");
            amountUsedButtons++;
            this.screen.setText("O player makes a move");
        } else if ((amountUsedButtons % 2 == 1) && (button.getText().equals(""))){
            button.setText("O");
            amountUsedButtons++;
            this.screen.setText("X player makes a move");
        }


    }

    /**
     * Method, which open exit window
     * Window has two button: YES or NO
     * If you click on YES game will continue (buttons and screen will become empty), else game will finish.
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
