package main.java.test;

import main.java.Calculator;
import main.java.logorithm.LogorithmException;
import main.java.trigonometric.Cot;
import main.java.trigonometric.Sin;
import main.java.trigonometric.TrigonometricException;
import org.junit.*;

public class TrigonometricTest {
    final double EPS = 1.0e-5;
    final double INF = 1.0e8;
    //SIN
    @Test
    public void test1() throws TrigonometricException {
        Assert.assertTrue(Sin.calculateSin(Math.PI / 2) - 1 < EPS);
    }

    @Test
    public void test2() throws TrigonometricException {
        Assert.assertTrue(Sin.calculateSin(0) < EPS);
    }

    @Test
    public void test3() throws TrigonometricException {
        Assert.assertTrue(Sin.calculateSin(Math.PI / 4) - Math.sqrt(2)/2 < EPS);
    }

    @Test
    public void test4() throws TrigonometricException {
        Assert.assertTrue(Sin.calculateSin(Math.PI /6 ) - 0.5 < EPS);
    }


    //COT
    @Test
    public void test5() throws TrigonometricException {
        Assert.assertTrue(Double.isNaN(Cot.calculateCot(0)));
    }

    @Test
    public void test6() throws TrigonometricException {
        Assert.assertTrue(Cot.calculateCot(Math.PI / 6) - Math.sqrt(3) < EPS);
    }

    @Test
    public void test7() throws TrigonometricException {
        Assert.assertTrue(Cot.calculateCot(Math.PI / 4) - 1 < EPS);
    }

    @Test
    public void test8() throws TrigonometricException {
        Assert.assertTrue(Cot.calculateCot(Math.PI /3 ) - Math.sqrt(3)/3 < EPS);
    }

    //FUNCTION
    @Test
    public void funcTest1() throws TrigonometricException, LogorithmException {
        Calculator calculator = new Calculator(-0.1);
        Assert.assertTrue(calculator.calculate() - INF < EPS);
    }

    @Test
    public void funcTest2() throws TrigonometricException, LogorithmException {
        Calculator calculator = new Calculator(- Math.PI/3);
        Assert.assertTrue(calculator.calculate() + 2.309401 < EPS);
    }

    @Test
    public void funcTest3() throws TrigonometricException, LogorithmException {
        Calculator calculator = new Calculator(0);
        Assert.assertTrue(Double.isNaN(calculator.calculate()));
    }

    @Test
    public void funcTest4() throws TrigonometricException, LogorithmException {
        Calculator calculator = new Calculator(- 3 *Math.PI/2);
        Assert.assertTrue(calculator.calculate() - 2 < EPS);
    }
}
