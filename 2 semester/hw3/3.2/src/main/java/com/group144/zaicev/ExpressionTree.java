package com.group144.zaicev;

import static java.lang.Integer.parseInt;

/**
 * Class for working with expression tree
 */
class ExpressionTree {
    private Node root;

    /**
     * Creates expression tree
     *
     * @param expression your expression
     * @throws IncorrectTreeException if in your expression the opening brackets are greater than the closing or vice versa
     */
    ExpressionTree(String expression) throws IncorrectTreeException {
        String convertExpression = convertString(expression);
        if (!isCorrectBrackets(expression)) {
            throw new IncorrectTreeException("Incorrect brackets");
        }
        root = new Operator(convertExpression);
    }

    /**
     * Calculates your expression
     *
     * @return result your expression
     * @throws IncorrectTreeException if your expression tree is incorrect (e.g. tree has a incorrect symbol)
     */
    int calculateTree() throws IncorrectTreeException {
        return root.calculate();
    }

    /**
     * Prints your expression tree
     */
    void printTree() {
        root.print();
    }

    /**
     * Converts your tree to a string
     *
     * @return your expression tree in the string
     */
    public String toString() {
        return root.toString();
    }

    /**
     * Class for working with the operand of the expression tree
     */
    static class Operand extends Node {

        /**
         * Creates operand
         *
         * @param value new value in the operand
         */
        Operand(String value) {
            valueOfNode = value;
        }

        @Override
        public void print() {
            System.out.print(valueOfNode);
        }

        @Override
        int calculate() throws IncorrectTreeException {
            if (isNumber(valueOfNode)) {
                return parseInt(valueOfNode);
            } else {
                throw new IncorrectTreeException("Incorrect operand");
            }
        }

        @Override
        public String toString() {
            return valueOfNode;
        }

        /**
         * checks if the string is a number
         *
         * @param number string for checking
         * @return true if is a number, else false
         */
        boolean isNumber(String number) {
            try {
                Integer.parseInt(number);
                return true;
            } catch (NumberFormatException exception) {
                return false;
            }
        }
    }

    /**
     * Adds spaces in your string
     *
     * @param string your string for converting
     * @return converting string
     */
    private String convertString(String string) {
        String result = "";

        for (int i = 0; i < string.length() - 1; i++) {
            result = result.concat(String.valueOf(string.charAt(i)));
            if ((string.charAt(i) == '(') || (string.charAt(i + 1) == ')')) {
                result = result.concat(" ");
            }
        }

        result = result.concat(String.valueOf(string.charAt(string.length() - 1)));
        return result;
    }

    /**
     * Checks if the expression is the correct brackets sequence
     *
     * @param expression expression for checking
     * @return true, if is the correct brackets sequence, else false
     */
    private boolean isCorrectBrackets(String expression) {
        int amountOpeningBrackets = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                amountOpeningBrackets++;
            } else if (expression.charAt(i) == ')') {
                amountOpeningBrackets--;
            }
            if (amountOpeningBrackets < 0) {
                return false;
            }
        }
        return amountOpeningBrackets == 0;
    }
}
