package group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class CheckingWinTest extends CheckingWin {

    private String[][] valueFromButtons = new String[][]{{"", "", ""}, {"", "", ""}, {"", "", ""}};

    @Test
    public void winFromRowTest() {
        valueFromButtons[0][0] = "X";
        valueFromButtons[0][1] = "O";
        valueFromButtons[0][2] = "O";
        valueFromButtons[1][0] = "X";
        valueFromButtons[1][1] = "X";
        valueFromButtons[1][2] = "X";
        valueFromButtons[2][0] = "O";
        Assert.assertTrue(isWinner(valueFromButtons));
    }

    @Test
    public void winFromColumnTest() {
        valueFromButtons[0][0] = "O";
        valueFromButtons[0][1] = "O";
        valueFromButtons[0][2] = "X";
        valueFromButtons[1][0] = "X";
        valueFromButtons[1][1] = "O";
        valueFromButtons[1][2] = "X";
        valueFromButtons[2][2] = "X";
        Assert.assertTrue(isWinner(valueFromButtons));
    }

    @Test
    public void winFromFirstDiagonalTest() {
        valueFromButtons[0][0] = "O";
        valueFromButtons[0][1] = "X";
        valueFromButtons[0][2] = "X";
        valueFromButtons[1][0] = "X";
        valueFromButtons[1][1] = "O";
        valueFromButtons[1][2] = "X";
        valueFromButtons[2][0] = "X";
        valueFromButtons[2][2] = "O";
        Assert.assertTrue(isWinner(valueFromButtons));
    }

    @Test
    public void winFromSecondDiagonalTest() {
        valueFromButtons[0][0] = "O";
        valueFromButtons[0][1] = "O";
        valueFromButtons[0][2] = "X";
        valueFromButtons[1][0] = "O";
        valueFromButtons[1][1] = "X";
        valueFromButtons[1][2] = "X";
        valueFromButtons[2][0] = "X";
        valueFromButtons[2][2] = "";
        Assert.assertTrue(isWinner(valueFromButtons));
    }

    @Test
    public void DrawTest() {
        valueFromButtons[0][0] = "O";
        valueFromButtons[0][1] = "O";
        valueFromButtons[0][2] = "X";
        valueFromButtons[1][0] = "X";
        valueFromButtons[1][1] = "O";
        valueFromButtons[1][2] = "X";
        valueFromButtons[2][0] = "X";
        valueFromButtons[2][1] = "X";
        valueFromButtons[2][0] = "O";
        Assert.assertFalse(isWinner(valueFromButtons));
    }
}