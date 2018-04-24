package group144.zaicev;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.Stack;

import static java.lang.Integer.parseInt;
import static java.lang.String.copyValueOf;

/**
 * Class, which calculate your expression
 */
class Calculator {

    /**
     * Method, which checks whether your symbol is an operator
     * @param symbol - symbol, which you want to check
     * @return true, if symbol is an operator, else return false
     */
    private boolean isOperator(char symbol) {
        return (symbol == '*') || (symbol == '+') || (symbol == '-') || (symbol == '/');
    }

    /**
     * Method, which returns the priority of your symbol
     * @param symbol - your symbol
     * @return priority of your symbol
     */
    private int priority(char symbol) throws WrongExpressionException {
        if (symbol == '(') {
            return 0;
        }
        if (symbol == ')') {
            return 1;
        }
        if ((symbol == '+') || (symbol == '-')) {
            return 2;
        }
        if ((symbol == '*') || (symbol == '/')) {
            return 3;
        }
        throw new WrongExpressionException("Operation not found");
    }

    /**
     * Method, which converts your expression to postfix form
     * @param expression - your expression
     * @return your expression in postfix form
     */
    private String toPostfix(String expression) throws WrongExpressionException {
        StringBuffer result = new StringBuffer();
        Stack<Character> operation = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (!isOperator(expression.charAt(i)) && (expression.charAt(i) != '(') && (expression.charAt(i) != ')')) {
                result.append(expression.charAt(i));
            } else if (isOperator(expression.charAt(i))) {
                actionOnOperator(expression.charAt(i), operation, result);
            } else if (expression.charAt(i) == '(') {
                actionOnOpeningBracket(operation, expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                actionOnClosingBracket(operation, result);
            }

            if (i == expression.length() - 1) {
                actionOnRemainingOperations(result, operation);
            }
        }
        return result.toString();
    }

    /**
     * Method for work with remaining operators of your expression
     * @param result variable string in postfix form, in the future the postfix form of your expression
     * @param operation stack of your expression operations
     */
    private void actionOnRemainingOperations(StringBuffer result, Stack<Character> operation) {
        while (!operation.empty())
        {
            result.append(operation.peek());
            operation.pop();
        }
    }

    /**
     * Method for work with action on closing brackets
     * @param operations stack of your expression operations
     * @param result variable string in postfix form, in the future the postfix form of your expression
     */
    private void actionOnClosingBracket(Stack<Character> operations, StringBuffer result) {
        while ((!operations.empty()) && (operations.peek() != '(')) {
            result.append(operations.peek());
            operations.pop();
        }
        if (!operations.empty()) {
            operations.pop();
        }
    }

    /**
     * Method for work with action on opening brackets
     * @param operations stack of your expression operations
     * @param symbol - symbol of opening bracket
     */
    private void actionOnOpeningBracket(Stack<Character> operations, char symbol) {
        operations.push(symbol);
    }

    /**
     * Method for work with action on operators
     * @param symbol - symbol of your operator
     * @param operations stack of your expression operations
     * @param result variable string in postfix form, in the future the postfix form of your expression
     */
    private void actionOnOperator(char symbol, Stack<Character> operations, StringBuffer result) throws WrongExpressionException {
        if ((operations.empty()) || (operations.peek() == '(')) {
            operations.push(symbol);
        } else if ((!operations.empty()) && (priority(symbol) > priority(operations.peek()))) {
            operations.push(symbol);
        } else {
            while ((!operations.empty()) && (operations.peek() != '(')
                    && (priority(operations.peek()) >= priority(symbol))) {
                result.append(operations.peek());
                operations.pop();
            }
            operations.push(symbol);
        }
    }

    /**
     * Method, which checks whether your symbol is a digit
     * @param symbol - symbol, which you want to check
     * @return true, if symbol is a digit, else return false
     */
    private boolean isDigit(char symbol) {
        return ((symbol >= '0') && (symbol <= '9'));
    }

    /**
     * Method, which checks whether your symbol is a space
     */
    private boolean isSpace(char symbol) {
        return symbol == ' ';
    }

    /**
     * Method, which checks whether your symbol is a numeral
     */
    private int numeral(char symbol) {
        return symbol - '0';
    }

    private boolean divByZero = false;

    /**
     * Method, for calculate number1 action number2
     * @param symbol - operation
     * @param number1 - first number
     * @param number2 - second number
     * @return result this expression
     * @throws DivisionByZeroException if you division by zero
     */
    private int action(char symbol, int number1, int number2) throws DivisionByZeroException {
        if (symbol == '+') {
            return number1 + number2;
        }

        if (symbol == '-') {
            return number1 - number2;
        }

        if (symbol == '*') {
            return number1 * number2;
        }

        if (symbol == '/') {
            if (number2 == 0) {
                divByZero = true;
                throw new DivisionByZeroException("Error, division by 0");
            }
            return number1 / number2;
        }
        return 0;
    }

    private boolean incorrect = false;

    /**
     * Method. which calculate your expression of postfix form
     * @param expression your expression
     * @return result of your expression
     * @throws WrongExpressionException if your expression is incorrect
     * @throws DivisionByZeroException if you division by zero
     */
    private int resultExpression(String expression) throws WrongExpressionException, DivisionByZeroException {
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (isDigit(expression.charAt(i))) {
                result.push(numeral(expression.charAt(i)));
            } else if (!isSpace(expression.charAt(i))) {
                if (result.size() == 0) {
                    incorrect = true;
                    throw new WrongExpressionException("Error, expression is incorrect");
                }

                int front = result.peek();
                result.pop();
                if (result.size() == 0) {
                    incorrect = true;
                    throw new WrongExpressionException("Error, expression is incorrect");
                }

                int beforeFront = result.peek();
                result.pop();
                int resultOperation = action(expression.charAt(i), beforeFront, front);
                result.push(resultOperation);
            }
        }
        return result.peek();
    }

    /**
     * Method, which convert the expression: add * between the number and (
     * @param expression your expression
     * @return converting expression
     */
    private String convertExpression(String expression) {
        String result = "";
        for (int i = 0; i < expression.length() - 1; i++) {
            result = result.concat(String.valueOf(expression.charAt(i)));

            if ((isDigit(expression.charAt(i))) && (expression.charAt(i + 1) == '(')) {
                result = result.concat("*");
            }

            if ((isDigit(expression.charAt(i + 1))) && (expression.charAt(i) == ')')) {
                return "(";
            }
        }
        result = result.concat(String.valueOf(expression.charAt(expression.length() - 1)));
        return result;
    }

    /**
     * Method, which  calculate your expression using postfix form
     * @param expression your expression
     * @return result your expression and error, if expression is incorrect
     * @throws WrongExpressionException if expression is incorrect
     * @throws DivisionByZeroException if you division by zero
     */
    String calculate(String expression) throws WrongExpressionException, DivisionByZeroException {
        this.divByZero = false;
        this.incorrect = false;
        expression = convertExpression(expression);
        String postfixForm = toPostfix(expression);
        int result = resultExpression(postfixForm);
        if ((!divByZero) && (!incorrect)) {
            return String.valueOf(result);
        } else if (incorrect) {
            return "Error, expression is incorrect";
        } else {
            return "Error, division by 0";
        }
    }
}
