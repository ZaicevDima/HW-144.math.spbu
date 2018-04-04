package group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends Calculator{

    @Test
    public void expressionWithoutBracketsTest() throws WrongExpressionException, DivisionByZeroException {
        int actualValue = Integer.parseInt(calculate("1-2*4/2+5-3"));
        int expectedValue = -1;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void expressionWithBrackets() throws WrongExpressionException, DivisionByZeroException {
        int actualValue = Integer.parseInt(calculate("((1+2)*4-(9+9)/2)+(1-2)/(2-1)"));
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);
    }
    @Test (expected = DivisionByZeroException.class)
    public void expressionWithDivisionByZeroTest() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("1/0");
        String expectedValue = "Error, division by 0";

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = WrongExpressionException.class)
    public void incorrectExpressionWithoutBrackets() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("1+");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = WrongExpressionException.class)
    public void incorrectExpressionWithBrackets() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("((1+2)");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = WrongExpressionException.class)
    public void incorrectExpressionWithoutNumbers() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("+");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = WrongExpressionException.class)
    public void incorrectExpression() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("((1+2)/3+))))");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test (expected = WrongExpressionException.class)
    public void expressionWithDoubleCoefficients() throws WrongExpressionException, DivisionByZeroException {
        String actualValue = calculate("(1.5*2)/3");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }
}