package group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends Calculator {

    @Test
    public void expressionWithoutBracketsTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        int actualValue = Integer.parseInt(calculate("1-20*4/2+5-3"));
        int EXPECTED = -37;

        assertEquals(EXPECTED, actualValue);
    }

    @Test
    public void expressionWithBracketsTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        int actualValue = Integer.parseInt(calculate("((123+231)*4-(901+9)/2)+(1-2)/(2-1)"));
        int EXPECTED = 960;

        assertEquals(EXPECTED, actualValue);
    }

    @Test
    public void expressionWithNumberAfterOpeningBracketTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String result = calculate("2(52*2)3");
        String EXPECTED = "624";

        assertEquals(EXPECTED, result);
    }

    @Test(expected = DivisionByZeroException.class)
    public void expressionWithDivisionByZeroTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("1/0");
        String expectedValue = "Error, division by 0";

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = WrongExpressionException.class)
    public void incorrectExpressionWithoutBracketsTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("1+");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = WrongExpressionException.class)
    public void incorrectExpressionWithoutNumbersTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("+");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = WrongExpressionException.class)
    public void incorrectExpressionTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("((1+2)/3+)");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = WrongExpressionException.class)
    public void expressionWithDoubleCoefficientsTest() throws WrongExpressionException, DivisionByZeroException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("(1.5*2)/3");
        String expectedValue = "Error, expression is incorrect";

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = WrongBracketSequenceExeption.class)
    public void expressionWithWrongBracketSequenceTest() throws DivisionByZeroException, WrongBracketSequenceExeption, WrongExpressionException, EmptyExpressionExeption {
        String actualValue = calculate(")3*4(");
        String EXPECTED = "Incorrect bracket sequence";

        assertEquals(EXPECTED, actualValue);
    }

    @Test(expected = EmptyExpressionExeption.class)
    public void calculateNullExpressionTest() throws DivisionByZeroException, WrongExpressionException, WrongBracketSequenceExeption, EmptyExpressionExeption {
        String actualValue = calculate("");
        String EXPECTED = "Exeption is empty";

        assertEquals(EXPECTED, actualValue);
    }
}