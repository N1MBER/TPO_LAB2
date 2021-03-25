package tests.unit;

import exceptions.FunctionsException;
import functions.trigonometrics.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class TrigonometricUnitTest {

    private final double accuracy = 1e-8;
    private Cosinus cosinus = new Cosinus(accuracy);
    private Sinus sinus = new Sinus(accuracy);
    private Cotangent cotangent = new Cotangent(accuracy);

    @Test
    @DisplayName("Cos: The accuracy below zero")
    void test1() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> cosinus.calcCos(value, -1));
    }

    @Test
    @DisplayName("Cos The accuracy zero")
    void test2(){
        double value = 2.543;
        assertDoesNotThrow(() -> cosinus.calcCos(value, 0));
    }

    @DisplayName("Cos: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {0, 30, 45, 60, 90, 180, 270, 360, 23})
    void test3(double value) throws FunctionsException {
        double x = value/180*Math.PI;
        assertEquals(Math.cos(x), cosinus.calcCos(x, accuracy), accuracy);
    }

    @Test
    @DisplayName("Cos: Parity")
    void test4() throws FunctionsException {
        double value = 2.543;
        assertEquals(cosinus.calcCos(value, accuracy), cosinus.calcCos(-value, accuracy));
    }

    @Test
    @DisplayName("Sin: The accuracy below zero")
    void test5(){
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> sinus.calcSin(value, -1));
    }

    @Test
    @DisplayName("Sin: The accuracy zero")
    void test6(){
        double value = 2.543;
        assertDoesNotThrow(() -> sinus.calcSin(value, 0));
    }

    @DisplayName("Sin: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {0, 30, 45, 60, 90, 180, 270, 360, 23})
    void test7(double value) throws FunctionsException {
        double x = value/180*Math.PI;
        assertEquals(Math.sin(x), sinus.calcSin(x, accuracy), accuracy);
    }

    @Test
    @DisplayName("Sin: Parity")
    void test8() throws FunctionsException {
        double value = 2.543;
        assertEquals(sinus.calcSin(value, accuracy), -sinus.calcSin(-value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Ctg: The accuracy below zero")
    void test9(){
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> cotangent.calcCtg(value, -1));
    }

    @Test
    @DisplayName("Ctg: The accuracy zero")
    void test10(){
        double value = 2.543;
        assertDoesNotThrow(() -> cotangent.calcCtg(value, 0));
    }

    @DisplayName("Ctg: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {30, 45, 60, -30, -250, 123})
    void test11(double value) throws FunctionsException {
        double x = value/180*Math.PI;
        assertEquals(cosinus.calcCos(x,accuracy)/Math.sqrt(1 - Math.pow(cosinus.calcCos(x,accuracy),2)), cotangent.calcCtg(x, accuracy), accuracy);
    }

    @DisplayName("Ctg: params ")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {-180, 0, 180, 360, 720})
    void test12(double value) {
        double x =( value/180)*Math.PI;
        assertThrows(FunctionsException.class, () -> cotangent.calcCtg(x, accuracy));
    }

}
