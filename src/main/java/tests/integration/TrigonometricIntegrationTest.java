package tests.integration;

import exceptions.FunctionsException;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import system.FirstFunction;
import system.SystemFunctions;

import java.util.stream.Stream;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrigonometricIntegrationTest {
    private  final double accuracy = 10e-5;

    static Stream<Arguments> valuesRangeProvider() {
        return Stream.of(
                arguments(-1.502476996076938),
                arguments(-1.4341586653589795),
                arguments(-1.3658403346051036),
                arguments(-1.2975220039230626),
                arguments(-1.2292036732051033),
                arguments(-1.0692036732051031),
                arguments(-0.909203673205103),
                arguments(-0.7492036732051028),
                arguments(-0.5892036732051027),
                arguments(-0.2492036732051035),
                arguments(-0.06920367320510357),
                arguments(0.11079632679489637),
                arguments(0.2907963267948963),
                arguments(0.47079632679489647),
                arguments(0.6107963267948965),
                arguments(0.7507963267948965),
                arguments(0.8907963267948965),
                arguments(1.0307963267948965),
                arguments(1.1707963267948966),
                arguments(1.2507963267948965),
                arguments(1.3307963267948966),
                arguments(1.4107963267948966),
                arguments(1.4907963267948965),
                arguments(1.6391148635128552),
                arguments(1.7074333902308139),
                arguments(1.7757519169487725),
                arguments(1.8440704436667312),
                arguments(1.91238897038469),
                arguments(2.004070441666731),
                arguments(2.0957519129487725),
                arguments(2.187433384230814),
                arguments(2.279114855512855),
                arguments(2.3707963267948964),
                arguments(2.6907963267948967),
                arguments(3.0107963267948965),
                arguments(3.3307963267948963),
                arguments(3.650796326794896),
                arguments(4.070796326794897),
                arguments(4.199114837512855),
                arguments(4.327433348230814),
                arguments(4.455751858948773),
                arguments(4.5840703696667315)
        );
    }

    @DisplayName("Sinus: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test1(double value) throws FunctionsException {
        Sinus sinus1 = Mockito.mock(Sinus.class);
        when(sinus1.calcSin(value,accuracy)).thenReturn(Math.sin(value));
        assertEquals(sin(value), sinus1.calcSin(value, accuracy), accuracy);
    }

    @DisplayName("Cosinus: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test2(double value) throws FunctionsException {
        Cosinus cosinus1 = Mockito.mock(Cosinus.class);
        when(cosinus1.calcCos(value, accuracy)).thenReturn(Math.cos(value));
        assertEquals(cos(value), cosinus1.calcCos(value, accuracy), accuracy);
    }


    @DisplayName("Cotangent: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test3(double value) throws FunctionsException {
        Cotangent cotangent1 = Mockito.mock(Cotangent.class);
        when(cotangent1.calcCtg(value,accuracy)).thenReturn(cos(value) / sqrt(1 - pow(cos(value), 2)));
        assertEquals(
                cos(value) / sqrt(1 - pow(cos(value), 2)),
                cotangent1.calcCtg(value, accuracy), accuracy);
    }

    static Stream<Arguments> valuesRangeProviderFunc(){
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

    @DisplayName("Sinus: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderFunc")
    void test4(double value, double expected) throws FunctionsException {
        FirstFunction firstFunction1 = Mockito.mock(FirstFunction.class);
        when(firstFunction1.calc(value)).thenReturn(cos(value) / sqrt(1 - pow(cos(value), 2)) + 2 * sin(value));
        assertEquals(
                expected,
                firstFunction1.calc(value), accuracy);
    }
}
