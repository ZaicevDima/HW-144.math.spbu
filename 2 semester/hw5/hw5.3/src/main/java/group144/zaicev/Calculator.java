package group144.zaicev;

import java.util.Stack;

import static java.lang.String.copyValueOf;

class Calculator {

    private boolean isOperator(char symbol)
    {
        return (symbol == '*') || (symbol == '+') || (symbol == '-') || (symbol == '/');
    }


    private int priority(char symbol)
    {
        if (symbol == '(')
            return 0;
        if (symbol == ')')
            return 1;
        if ((symbol == '+') || (symbol == '-'))
            return 2;
        if ((symbol == '*') || (symbol == '/'))
            return 3;
        return 0;
    }

    private int amountBrackets(String expression) {
        int amount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ((expression.charAt(i) == '(') || (expression.charAt(i) == ')')) {
                amount++;
            }
        }
        return amount;
    }

    private int resultTopIndex;

    private String toPostfix(String expression) {
        char[] result = new char[expression.length() - amountBrackets(expression)];
        char[] symbols = expression.toCharArray();
        Stack<Character> operation = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (!isOperator(symbols[i]) && (symbols[i] != '(') && (symbols[i] != ')')) {
                result[resultTopIndex] = symbols[i];
                resultTopIndex++;
            } else if (isOperator(symbols[i])) {
                actionOnOperator(symbols[i], operation, result);
            } else if (symbols[i] == '(') {
                actionOnOpeningBracket(operation, symbols[i]);
            } else if (symbols[i] == ')') {
                actionOnClosingBracket(operation, result);
            }

            if (i == expression.length() - 1) {
                actionOnRemainingOperations(result, operation);
            }
        }
        return copyValueOf(result);
    }

    private void actionOnRemainingOperations(char[] result, Stack<Character> operation) {
        while (!operation.empty())
        {
            result[this.resultTopIndex] = operation.peek();
            this.resultTopIndex++;
            operation.pop();
        }
    }

    private void actionOnClosingBracket(Stack<Character> operations, char[] result) {
        while ((!operations.empty()) && (operations.peek() != '(')) {
            result[resultTopIndex] = operations.peek();
            resultTopIndex++;
            operations.pop();
        }
        if (!operations.empty()) {
            operations.pop();
        }
    }

    private void actionOnOpeningBracket(Stack<Character> operations, char symbol) {
        operations.push(symbol);
    }

    private void actionOnOperator(char symbol, Stack<Character> operations, char[] result) {
        if ((operations.empty()) || (operations.peek() == '(')) {
            operations.push(symbol);
        } else if ((!operations.empty()) && (priority(symbol) > priority(operations.peek()))) {
            operations.push(symbol);
        } else {
            while ((!operations.empty()) && (operations.peek() != '(') && (priority(operations.peek()) >= priority(symbol))) {
                result[resultTopIndex] = operations.peek();
                resultTopIndex++;
                operations.pop();
            }
            operations.push(symbol);
        }
    }

    private boolean isDigit(char symbol) {
        return ((symbol >= '0') && (symbol <= '9'));
    }

    private boolean isSpace(char symbol) {
        return symbol == ' ';
    }

    private int numeral(char symbol) {
        return symbol - '0';
    }

    private int action(char symbol, int number1, int number2) {
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
            return number1 / number2;
        }

        return 0;
    }
    private int resultExpression(String expression) {
        char[] symbols = expression.toCharArray();
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (isDigit(symbols[i])) {
                result.push(numeral(symbols[i]));
            } else if (!isSpace(symbols[i])) {
                int front = result.peek();
                result.pop();
                int beforeFront = result.peek();
                result.pop();
                int resultOperation = action(symbols[i], beforeFront, front);
                result.push(resultOperation);
            }
        }

        return result.peek();
    }

    int calculate(String expression) {
        this.resultTopIndex = 0;
        String postfix = toPostfix(expression);
        System.out.println(postfix);
        return resultExpression(postfix);
    }
}
