package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculateArrayStack() {
        Calculator calculator = new Calculator(new ArrayStack<>(), new ArrayStack<>());
        int result = calculator.consider("1+(2/1-3)*2");
        Assert.assertEquals(-1, result);
    }

    @Test
    public void calculateDynamicStack() {
        Calculator calculator = new Calculator(new DynamicStack<>(), new DynamicStack<>());
        int result = calculator.consider("1+(2/1-3)*2");
        Assert.assertEquals(-1, result);
    }
}