package group144.zaicev;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Random;

/**
 * Controller for tic tac toe game
 */
public class Controller extends CheckingWin {

    int N = 4;

    @FXML
    private
    Button button0 = new Button();

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
    Button button10 = new Button();

    @FXML
    Button button11 = new Button();

    @FXML
    Button button12 = new Button();

    @FXML
    Button button13 = new Button();

    @FXML
    Button button14 = new Button();

    @FXML
    Button button15 = new Button();

    @FXML
    private
    Button[][] buttons = new Button[][]{{button0, button1, button2, button3},
            {button4, button5, button6, button7},
            {button8, button9, button10, button11},
            {button12, button13, button14, button15}};

    private int valuesUnderButton[][] = new int[N][N];
    private boolean isOpened[][] = new boolean[N][N];

    /**
     * initialize
     */
    public void initialize() {
        int amountOnes = N * N / 2;
        int amountZeros = amountOnes;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isOpened[i][j] = false;
                if ((amountOnes > 0) && (amountZeros > 0)) {
                    valuesUnderButton[i][j] = Math.abs(random.nextInt()) % 2;
                    if (valuesUnderButton[i][j] == 0) {
                        amountZeros--;
                    } else {
                        amountOnes--;
                    }
                } else if (amountOnes == 0) {
                    valuesUnderButton[i][j] = 0;
                    amountZeros--;
                } else {
                    valuesUnderButton[i][j] = 1;
                    amountOnes--;
                }
                System.out.print(valuesUnderButton[i][j]);
            }
            System.out.println();
        }


        press(button0,valuesUnderButton[0][0]);
        press(button1,valuesUnderButton[0][1]);
        press(button2,valuesUnderButton[0][2]);
        press(button3,valuesUnderButton[0][3]);
        press(button4,valuesUnderButton[1][0]);
        press(button5,valuesUnderButton[1][1]);
        press(button6,valuesUnderButton[1][2]);
        press(button7,valuesUnderButton[1][3]);
        press(button8,valuesUnderButton[2][0]);
        press(button9,valuesUnderButton[2][1]);
        press(button10,valuesUnderButton[2][2]);
        press(button11,valuesUnderButton[2][3]);
        press(button12,valuesUnderButton[3][0]);
        press(button13,valuesUnderButton[3][1]);
        press(button14,valuesUnderButton[3][2]);
        press(button15,valuesUnderButton[3][3]);
    }

    private void press(Button button, int value) {
        button.setOnAction(event -> pressOnButton(button, value, true));
    }

    private void press2() {
        pressOnButton(button0,valuesUnderButton[0][0], false);
        pressOnButton(button1,valuesUnderButton[0][1], false);
        pressOnButton(button2,valuesUnderButton[0][2], false);
        pressOnButton(button3,valuesUnderButton[0][3], false);
        pressOnButton(button4,valuesUnderButton[1][0], false);
        pressOnButton(button5,valuesUnderButton[1][1], false);
        pressOnButton(button6,valuesUnderButton[1][2], false);
        pressOnButton(button7,valuesUnderButton[1][3], false);
        pressOnButton(button8,valuesUnderButton[2][0], false);
        pressOnButton(button9,valuesUnderButton[2][1], false);
        pressOnButton(button10,valuesUnderButton[2][2], false);
        pressOnButton(button11,valuesUnderButton[2][3], false);
        pressOnButton(button12,valuesUnderButton[3][0], false);
        pressOnButton(button13,valuesUnderButton[3][1], false);
        pressOnButton(button14,valuesUnderButton[3][2], false);
        pressOnButton(button15,valuesUnderButton[3][3], false);
    }

    private void pressOnButton(Button button, int value, boolean isFirstButton) {
        if (!button.getText().equals("")) {
            return;
        }
        button.setText(String.valueOf(value));
        if (isFirstButton) {
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < N; j++) {
                    pressOnButton(buttons[i][j], valuesUnderButton[i][j], false);
                    break;
                }
            }
        } else {
            int firstButtonX = 0;
            int firstButtonY = 0;

            int secondButtonX = 0;
            int secondButtonY = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((!isOpened[i][j]) && (!buttons[i][j].getText().equals(""))) {
                        firstButtonX = i;
                        firstButtonY = j;
                    }
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((!isOpened[i][j]) && (!buttons[i][j].getText().equals("")) && (i != firstButtonX) && (j != firstButtonY)) {
                        secondButtonX = i;
                        secondButtonY = j;
                    }
                }
            }

            if (buttons[firstButtonX][firstButtonY].getText().equals(buttons[secondButtonX][secondButtonY].getText())) {
                isOpened[firstButtonX][firstButtonY] = true;
                isOpened[secondButtonX][secondButtonY] = true;
            } else {
                buttons[firstButtonX][firstButtonY].setText("");
                buttons[secondButtonX][secondButtonY].setText("");
            }
        }
    }

}
