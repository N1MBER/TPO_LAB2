package main.java.test;
import main.java.Calculator;
import main.java.logorithm.*;
import main.java.trigonometric.TrigonometricException;
import org.junit.*;

public class LogorithmTest {
    final double EPS = 1.0e-5;
    final double INF = 1.0e8;

    //LN
    @Test
    public void testLN1() throws LogorithmException {
        Assert.assertTrue(Ln.calculateLn(1) < EPS);
    }

    @Test
    public void testLN2() throws LogorithmException {
        Assert.assertTrue(Ln.calculateLn(Math.E) - 1 < EPS);
    }

    @Test
    public void testLN3() throws LogorithmException {
        Assert.assertTrue(Double.isNaN(Ln.calculateLn(-1)));
    }

    @Test
    public void testLN4() throws LogorithmException {
        Assert.assertTrue(Ln.calculateLn(Math.pow(Math.E,2)) - 2 < EPS);
    }


    //LOG3
    @Test
    public void testLog31() throws LogorithmException {
        Assert.assertTrue(Log3.calculateLog3(1) < EPS);
    }

    @Test
    public void testLog32() throws LogorithmException {
        Assert.assertTrue(Log3.calculateLog3(3) - 1 < EPS);
    }

    @Test
    public void testLog33() throws LogorithmException {
        Assert.assertTrue(Log3.calculateLog3(27) - 3 < EPS);
    }
    @Test
    public void testLog34() throws LogorithmException {
        Assert.assertTrue(Double.isNaN(Log3.calculateLog3(0)));
    }

    //LOG5
    @Test
    public void testLog51() throws LogorithmException {
        Assert.assertTrue(Log5.calculateLog5(1) < EPS);
    }

    @Test
    public void testLog52() throws LogorithmException {
        Assert.assertTrue(Log5.calculateLog5(5) - 1 < EPS);
    }

    @Test
    public void testLog53() throws LogorithmException {
        Assert.assertTrue(Log5.calculateLog5(25) - 2 < EPS);
    }
    @Test
    public void testLog54() throws LogorithmException {
        Assert.assertTrue(Double.isNaN(Log5.calculateLog5(0)));
    }

    //LOG10
    @Test
    public void testLog101() throws LogorithmException {
        Assert.assertTrue(Log10.calculateLog10(1) < EPS);
    }

    @Test
    public void testLog102() throws LogorithmException {
        Assert.assertTrue(Log10.calculateLog10(10) - 1 < EPS);
    }

    @Test
    public void testLog103() throws LogorithmException {
        Assert.assertTrue(Log10.calculateLog10(10000) - 4 < EPS);
    }
    @Test
    public void testLog104() throws LogorithmException {
        Assert.assertTrue(Double.isNaN(Log10.calculateLog10(0)));
    }

    // Function
    @Test
    public void funcTest1() throws LogorithmException, TrigonometricException {
        Calculator calculator = new Calculator(1);
        Assert.assertTrue(calculator.calculate()  < EPS);
    }

    @Test
    public void funcTest2() throws LogorithmException, TrigonometricException {
        Calculator calculator = new Calculator(0.0001);
        Assert.assertTrue(calculator.calculate() - INF < EPS);
    }

    @Test
    public void funcTest3() throws LogorithmException, TrigonometricException {
        Calculator calculator = new Calculator(3);
        Assert.assertTrue(calculator.calculate() + 0.537692189 < EPS);
    }
    @Test
    public void funcTest4() throws LogorithmException, TrigonometricException {
        Calculator calculator = new Calculator(10);
        Assert.assertTrue(calculator.calculate()  < EPS);
    }
}
