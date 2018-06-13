package com.group144.zaicev;

/**
 * Class for working with operators
 */
class Operator extends Node {

    /**
     * Creates operator node
     *
     * @param expression your expression
     * @throws IncorrectTreeException if expression is incorrect
     */
    Operator(String expression) throws IncorrectTreeException {
        String[] tokens = expression.split(" ");

        if (tokens[0].equals("(")) {
            valueOfNode = tokens[1];
            String left = "";
            if (tokens[2].equals("(")) {
                left = createChild(2, tokens);
                this.leftNode = new Operator(left);
            } else {
                left = tokens[2];
                this.leftNode = new ExpressionTree.Operand(tokens[2]);
            }
            if (left.charAt(0) == '(') {
                if (tokens[3 + amountSpaces(left)].equals("(")) {
                    String right = createChild(3 + amountSpaces(left), tokens);
                    this.rightNode = new Operator(right);
                } else {
                    this.rightNode = new ExpressionTree.Operand(tokens[3 + amountSpaces(left)]);
                }
            } else {
                if (tokens[3].equals("(")) {
                    String right = createChild(3, tokens);
                    this.rightNode = new Operator(right);
                } else {
                    this.rightNode = new ExpressionTree.Operand(tokens[3]);
                }
            }
        } else {
            throw new IncorrectTreeException("Incorrect expression tree");
        }
    }

    /**
     * Calculate amount of the spaces in a string
     *
     * @param string your string
     * @return amount of the spaces
     */
    private int amountSpaces(String string) {
        int amount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                amount++;
            }
        }
        return amount;
    }

    /**
     * Highlights string for child node
     *
     * @param start  index for start
     * @param tokens elements for including in the child node
     * @return child node
     * @throws IncorrectTreeException if node is incorrect
     */
    private String createChild(int start, String[] tokens) throws IncorrectTreeException {
        int amountOpeningBrackets = 0;
        String result = "";
        for (int i = start; i < tokens.length; i++) {
            result = result.concat(tokens[i]);

            if (tokens[i].equals("(")) {
                amountOpeningBrackets++;
            }
            if (tokens[i].equals(")")) {
                amountOpeningBrackets--;
            }
            if (amountOpeningBrackets == 0) {
                return result;
            }

            result = result.concat(" ");
        }
        throw new IncorrectTreeException("Incorrect expression tree");
    }

    @Override
    public int calculate() throws IncorrectTreeException {
        switch (valueOfNode) {
            case ("+"):
                return leftNode.calculate() + rightNode.calculate();
            case ("-"):
                return leftNode.calculate() - rightNode.calculate();
            case ("*"):
                return leftNode.calculate() * rightNode.calculate();
            case ("/"):
                return leftNode.calculate() / rightNode.calculate();
        }
        throw new IncorrectTreeException("Incorrect operation");
    }

    @Override
    public String toString() {
        return "( " + valueOfNode + " " + leftNode.toString() + " " + rightNode.toString() + " )";
    }

    @Override
    public void print() {
        System.out.print("( " + valueOfNode + " ");
        leftNode.print();
        System.out.print(" ");
        rightNode.print();
        System.out.print(" )");
    }
}
