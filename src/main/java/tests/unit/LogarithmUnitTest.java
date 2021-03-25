package tests.unit;

import exceptions.FunctionsException;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogarithmUnitTest {
    private final double accuracy = 1e-8;
    private LogarithmN logarithmN = new LogarithmN(accuracy);
    private Logarithm3 logarithm3 = new Logarithm3(accuracy);
    private Logarithm5 logarithm5 = new Logarithm5(accuracy);
    private Logarithm10 logarithm10 = new Logarithm10(accuracy);
    

    @Test
    @DisplayName("Ln: The accuracy below zero")
    void test1() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithmN.calcLogN(value, -1));
    }

    @Test
    @DisplayName("Ln: The accuracy zero")
    void test2(){
        double value = 2.543;
        assertDoesNotThrow(() -> logarithmN.calcLogN(value, 0));
    }

    @DisplayName("Ln: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {3.02, 17.043, 3.324, 12.2, 1.23, 10.21313})
    void test3(double value) throws FunctionsException {
        assertEquals(Math.log(value), logarithmN.calcLogN(value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Log3: The accuracy below zero")
    void test4() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithm3.calcLog3(value, -1));
    }

    @Test
    @DisplayName("Log3: The accuracy zero")
    void test5(){
        double value = 2.543;
        assertDoesNotThrow(() -> logarithm3.calcLog3(value, 0));
    }

    @DisplayName("Log3: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {3.02, 17.043, 3.324, 12.2, 1.23, 10.21313})
    void test6(double value) throws FunctionsException {
        assertEquals(Math.log(value)/Math.log(3), logarithm3.calcLog3(value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Log5: The accuracy below zero")
    void test7() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithm5.calcLog5(value, -1));
    }

    @Test
    @DisplayName("Log5: The accuracy zero")
    void test8(){
        double value = 2.543;
        assertDoesNotThrow(() -> logarithm5.calcLog5(value, 0));
    }

    @DisplayName("Log5: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {3.02, 17.043, 3.324, 12.2, 1.23, 10.21313})
    void test9(double value) throws FunctionsException {
        assertEquals(Math.log(value)/Math.log(5), logarithm5.calcLog5(value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Log10: The accuracy below zero")
    void test10() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithm10.calcLog10(value, -1));
    }

    @Test
    @DisplayName("Log10: The accuracy zero")
    void test11(){
        double value = 2.543;
        assertDoesNotThrow(() -> logarithm10.calcLog10(value, 0));
    }

    @DisplayName("Log10: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {3.02, 17.043, 3.324, 12.2, 1.23, 10.21313})
    void test12(double value) throws FunctionsException {
        assertEquals(Math.log(value)/Math.log(10), logarithm10.calcLog10(value, accuracy), accuracy);
    }
}
