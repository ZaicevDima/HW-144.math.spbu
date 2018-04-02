package group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends Calculator{

    @Test
    public void calculateTest() {
        assertEquals(-1, calculate("1+(2/1-3)*2"));
    }

}