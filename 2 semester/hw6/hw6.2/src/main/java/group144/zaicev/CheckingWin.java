package group144.zaicev;

/**
 * Class, to check the state of winnings
 */
class CheckingWin {
    /**
     * Method which checks if the column "X" or "O" is filled
     * @param valueFromButtons value from cells from panel
     * @param indexOfColumn column index
     * @return true, if filled, else false
     */
    private boolean isColumnFill(String[][] valueFromButtons, int indexOfColumn) {
        return  (valueFromButtons[indexOfColumn][0].equals(valueFromButtons[indexOfColumn][1]))
                && (valueFromButtons[indexOfColumn][1].equals(valueFromButtons[indexOfColumn][2]))
                && (!valueFromButtons[indexOfColumn][0].equals(""));
    }

    /**
     * Method which checks if the row "X" or "O" is filled
     * @param valueFromButtons value from cells from panel
     * @param indexRow row index
     * @return true, if filled, else false
     */
    private boolean isRowFill(String[][] valueFromButtons, int indexRow) {
        return (valueFromButtons[0][indexRow].equals(valueFromButtons[1][indexRow]))
                && (valueFromButtons[1][indexRow].equals(valueFromButtons[2][indexRow]))
                && (!valueFromButtons[0][indexRow].equals(""));
    }

    /**
     * Method which checks if the first diagonal "X" or "O" is filled
     * @param valueFromButtons value from cells from panel
     * @return true, if filled, else false
     */
    private boolean isFirstDiagonalFill(String[][] valueFromButtons) {
        boolean isFirstDiagonalFill = (valueFromButtons[0][0].equals(valueFromButtons[1][1]))
                && (valueFromButtons[1][1].equals(valueFromButtons[2][2]))
                && (!valueFromButtons[0][0].equals(""));

        boolean isSecondDiagonalFill = (valueFromButtons[2][0].equals(valueFromButtons[1][1]))
                && (valueFromButtons[1][1].equals(valueFromButtons[0][2]))
                && (!valueFromButtons[2][0].equals(""));
        return isFirstDiagonalFill || isSecondDiagonalFill;
    }

    /**
     * Method, which checks the state of winnings
     * @param valueFromButtons value from cells from panel
     * @return true, if there is a win, else false
     */
    boolean isWinner(String[][] valueFromButtons) {
        boolean isWin = false;
        for (int i = 0; i < 3; i++) {
            isWin = isWin || isColumnFill(valueFromButtons, i);
        }

        for (int i = 0; i < 3; i++) {
            isWin = isWin || isRowFill(valueFromButtons, i);
        }

        isWin = isWin || isFirstDiagonalFill(valueFromButtons);

        return isWin;
    }

}
