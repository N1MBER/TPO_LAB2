package tests.integration;

import exceptions.FunctionsException;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import services.RangeChecker;
import system.SecondFunction;
import system.SystemFunctions;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class SecondIntegrationTest {
    private static final double accuracy = 10e-5;
    static SecondFunction secondFunction;
    static LogarithmN logarithmN;
    static Logarithm3 logarithm3;
    static Logarithm5 logarithm5;
    static Logarithm10 logarithm10;
    static SystemFunctions systemFunctions;

    @BeforeAll
    static void setUp() {
        logarithmN = mock(LogarithmN.class);
        logarithm3 = mock(Logarithm3.class);
        logarithm5 = mock(Logarithm5.class);
        logarithm10 = mock(Logarithm10.class);
        systemFunctions = new SystemFunctions(accuracy);
        secondFunction = new SecondFunction(accuracy);
        secondFunction.logarithmN = logarithmN;
        secondFunction.logarithm3 = logarithm3;
        secondFunction.logarithm5 = logarithm5;
        secondFunction.logarithm10 = logarithm10;
        systemFunctions.secondFunction = secondFunction;
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(1e-05, 429685.8288665115),
                arguments(0.040006, 319.206253847386),
                arguments(0.060004, 154.98910563701008),
                arguments(0.1, 54.06989564695053),
                arguments(0.43999999999999995, 0.4415688768441257),
                arguments(1.1199999999999999, -4.925495014565685E-4),
                arguments(1.46, -0.018194345691916986),
                arguments(1.8, -0.0715064409972431),
                arguments(2.72, -0.39839529931779116),
                arguments(3.6400000000000006, -0.8878243618092458),
                arguments(4.5600000000000005, -1.3824592978586097),
                arguments(5.48, -1.7594423808277198),
                arguments(6.4, -1.9368806934099014),
                arguments(7.5200000000000005, -1.8113631902074128),
                arguments(8.64, -1.2639512933544148),
                arguments(9.76, -0.2714121757701894),
                arguments(10.879999999999999, 1.1723444822429507)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_0(double value, double expected) throws FunctionsException {
        when(secondFunction.logarithmN.calc(value)).thenReturn(Math.log(value));
        when(secondFunction.logarithm3.calc(value)).thenReturn(Math.log(value)/Math.log(3));
        when(secondFunction.logarithm5.calc(value)).thenReturn(Math.log(value)/Math.log(5));
        when(secondFunction.logarithm10.calc(value)).thenReturn(Math.log(value)/Math.log(10));
        assertEquals(expected, secondFunction.calc(value), accuracy);
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(0, true),
                arguments(-2,true)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values with exceptions, x = {0}")
    @MethodSource("withExceptionsProvider")
    void test_1(double value, boolean sinE) throws FunctionsException {
        assertThrows(FunctionsException.class, () -> secondFunction.calc(value));
    }

    @DisplayName("Integration Test: System")
    @ParameterizedTest(name = "{index}: Check values in system, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_3(double value, double expected) throws FunctionsException{
        when(secondFunction.logarithmN.calc(value)).thenReturn(Math.log(value));
        when(secondFunction.logarithm3.calc(value)).thenReturn(Math.log(value)/Math.log(3));
        when(secondFunction.logarithm5.calc(value)).thenReturn(Math.log(value)/Math.log(5));
        when(secondFunction.logarithm10.calc(value)).thenReturn(Math.log(value)/Math.log(10));
        assertEquals(expected, systemFunctions.calc(value), accuracy);
    }
}
