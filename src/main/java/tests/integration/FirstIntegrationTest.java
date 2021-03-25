package tests.integration;

import exceptions.FunctionsException;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import system.FirstFunction;
import system.SystemFunctions;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class FirstIntegrationTest {

    private static final double accuracy = 10e-5;
    static FirstFunction firstFunction;
    static Cosinus cos;
    static Sinus sin;
    static Cotangent ctg;
    static SystemFunctions sys;

    @BeforeAll
    static void setUp() {
        cos = mock(Cosinus.class);
        sin = mock(Sinus.class);
        ctg = mock(Cotangent.class);
        firstFunction = new FirstFunction(accuracy);
        firstFunction.cosinus = cos;
        firstFunction.sinus = sin;
        firstFunction.cotangent = ctg;
        sys = new SystemFunctions(accuracy);
        sys.firstFunction = firstFunction;
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(-6.282185307179586, 1000.00166667),
                arguments(-6.082385307179586, 5.31187237538517),
                arguments(-5.882585307179586, 3.14121327779964),
                arguments(-5.682785307179586, 2.59038718303791),
                arguments(-5.482985307179586, 2.40581686035003),
                arguments(-5.283185307179586, 2.32503458555012),
                arguments(-5.083185307179586, 2.25285774130266),
                arguments(-4.883185307179586, 2.143376185808720),
                arguments(-4.683185307179587, 1.969935227883066),
                arguments(-4.483185307179586, 1.71439172690238),
                arguments(-4.283185307179586, 1.36093729929108),
                arguments(-4.183185307179587, 1.14157092683828),
                arguments(-3.883185307179586, 0.25924033472324),
                arguments(-3.140592653589793, -1000.001666685276),
                arguments(-2.541192653589793, -2.5903871830379077),
                arguments(-2.141592653589793, -2.325034585550124),
                arguments(-1.941592653589793, -2.2528577413026576),
                arguments(-1.341592653589793, -1.7143917269023792),
                arguments(-0.841592653589793, -0.5979259610559944),
                arguments(-0.641592653589793, 0.14170384009623915)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test0(double value, double expected) throws FunctionsException {
        when(firstFunction.sinus.calc(value)).thenReturn(Math.sin(value));
        when(firstFunction.cosinus.calc(value)).thenReturn(Math.cos(value));
        when(firstFunction.cotangent.calc(value)).thenReturn((Math.cos(value)/Math.sqrt(1-Math.pow(Math.cos(value),2))));
        assertEquals(expected, firstFunction.calc(value), accuracy);
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(-6.283185307179586, true),
                arguments(-3.141592653589793, true),
                arguments(0.0, true),
                arguments(3.141592653589793, true),
                arguments(6.283185307179586, true)
                );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values with exceptions, x = {0}")
    @MethodSource("withExceptionsProvider")
    void test1(double value, boolean sinE) throws FunctionsException {
        when(firstFunction.cotangent.calc(value)).thenThrow(new FunctionsException(""));
        assertThrows(FunctionsException.class, () -> firstFunction.calc(value));
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test2(double value, double expected) throws FunctionsException {
        when(firstFunction.sinus.calc(value)).thenReturn(Math.sin(value));
        when(firstFunction.cosinus.calc(value)).thenReturn(Math.cos(value));
        when(firstFunction.cotangent.calc(value)).thenReturn((Math.cos(value)/Math.sqrt(1-Math.pow(Math.cos(value),2))));
        assertEquals(expected, sys.calc(value), accuracy);
    }
}
