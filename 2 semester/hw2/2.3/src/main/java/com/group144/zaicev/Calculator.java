package com.group144.zaicev;

public class Calculator {
    private static Stack<Character> operations;
    private static Stack<Integer> result;

    Calculator(Stack<Character> symbolStack, Stack<Integer> integerStack) {
        operations = symbolStack;
        result = integerStack;
    }

    public int consider(String expression) {
        String toPostfix = toPostfix(expression);
        return resultExpression(toPostfix, false);
    }

    private boolean isOperator(char symbol) {
        return (symbol == '*') || (symbol == '+') || (symbol == '-') || (symbol == '/');
    }

    private int getPriority(char symbol) {
        if (symbol == '(')
            return 0;
        if (symbol == ')')
            return 1;
        if ((symbol == '+') || (symbol == '-'))
            return 2;
        if ((symbol == '*') || (symbol == '/'))
            return 3;
        return -1;
    }

    private boolean isDigit(char symbol) {
        return ((symbol >= '0') && (symbol <= '9'));
    }

    private int getNumeral(char symbol) {
        return symbol - '0';
    }

    private String toPostfix(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (isDigit(symbol)) {
                result = result.concat(String.valueOf(symbol));
            } else if (isOperator(symbol)) {
                while ((!operations.isEmpty()) && (getPriority(operations.top()) >= getPriority(symbol))) {
                    result = result.concat(String.valueOf(operations.top()));
                    operations.pop();
                }
                operations.push(symbol);
            } else if (symbol == '(') {
                operations.push(symbol);
            } else if (symbol == ')') {
                while (!(operations.top() == '(')) {
                    result = result.concat(String.valueOf(operations.top()));
                    operations.pop();
                }
                operations.pop();
            }
        }

        while (!operations.isEmpty()) {
            result = result.concat(String.valueOf(operations.top()));
            operations.pop();
        }

        return result;
    }

    private int resultExpression(String expression, boolean error) {
        int size = expression.length();
        for (int i = 0; (i < size) && (!error); i++) {
            char symbol = expression.charAt(i);
            if (isDigit(symbol)) {
                result.push(getNumeral(symbol));
            } else {
                int front = result.top();
                result.pop();
                int beforeFront = result.top();
                result.pop();
                int resultOperation = action(symbol, beforeFront, front);
                result.push(resultOperation);
            }
        }

        return result.top();
    }

    private int action(char operation, int number1, int number2) {
        if (operation == '+')
            return number1 + number2;
        if (operation == '-')
            return number1 - number2;
        if (operation == '*')
            return number1 * number2;
        if ((operation == '/'))
            return number1 / number2;

        throw new IllegalArgumentException("Unsupported operation: " + operation);
    }
}