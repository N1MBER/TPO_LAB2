package tests.integration;

import exceptions.FunctionsException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import system.FirstFunction;
import system.SecondFunction;
import system.SystemFunctions;

import java.io.IOException;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class SystemFunctionsIntegrationTest {

    private static final double accuracy = 10e-5;
    static FirstFunction firstFunctionMock;
    static SecondFunction secondFunctionMock;
    static SystemFunctions systemFunctions;
// return Stream.of(
//                arguments(-6.282185307179586, 1000.00166667),
//                arguments(-6.082385307179586, 5.31187237538517),
//                arguments(-5.882585307179586, 3.14121327779964),
//                arguments(-5.682785307179586, 2.59038718303791),
//                arguments(-5.482985307179586, 2.40581686035003),
//                arguments(-5.283185307179586, 2.32503458555012),
//                arguments(-5.083185307179586, 2.25285774130266),
//                arguments(-4.883185307179586, 2.143376185808720),
//                arguments(-4.683185307179587, 1.969935227883066),
//                arguments(-4.483185307179586, 1.71439172690238),
//                arguments(-4.283185307179586, 1.36093729929108),
//                arguments(-4.183185307179587, 1.14157092683828),
//                arguments(-3.883185307179586, 0.25924033472324),
//                arguments(-3.140592653589793, -1000.001666685276),
//                arguments(-2.541192653589793, -2.5903871830379077),
//                arguments(-2.141592653589793, -2.325034585550124),
//                arguments(-1.941592653589793, -2.2528577413026576),
//                arguments(-1.341592653589793, -1.7143917269023792),
//                arguments(-0.841592653589793, -0.5979259610559944),
//                arguments(-0.641592653589793, 0.14170384009623915)
//        );
//      arguments(0.040006, 319.206253847386),
//                arguments(0.060004, 154.98910563701008),
//                arguments(0.1, 54.06989564695053),
//                arguments(0.43999999999999995, 0.4415688768441257),
//                arguments(1.1199999999999999, -4.925495014565685E-4),
//                arguments(1.46, -0.018194345691916986),
//                arguments(1.8, -0.0715064409972431),
//                arguments(2.72, -0.39839529931779116),
//                arguments(3.6400000000000006, -0.8878243618092458),
//                arguments(4.5600000000000005, -1.3824592978586097),
//                arguments(5.48, -1.7594423808277198),
//                arguments(6.4, -1.9368806934099014),
//                arguments(7.5200000000000005, -1.8113631902074128),
//                arguments(8.64, -1.2639512933544148),
//                arguments(9.76, -0.2714121757701894),
    @BeforeAll
    static void setUp() throws FunctionsException, IOException {
        firstFunctionMock = mock(FirstFunction.class);
        secondFunctionMock = mock(SecondFunction.class);
        when(firstFunctionMock.calc(-6.283185307179586)).thenThrow(new FunctionsException(""));
        when(firstFunctionMock.calc(-4.71238898038469)).thenThrow(new FunctionsException(""));
        when(firstFunctionMock.calc(-3.141592653589793)).thenThrow(new FunctionsException(""));
        when(firstFunctionMock.calc(-1.5707963267948966)).thenThrow(new FunctionsException(""));
        when(firstFunctionMock.calc(0.0)).thenThrow(new FunctionsException(""));
        when(secondFunctionMock.calc(0)).thenThrow(new FunctionsException(""));
        when(firstFunctionMock.calc(-6.082385307179586)).thenReturn(5.31187237538517);
        when(firstFunctionMock.calc(-5.682785307179586)).thenReturn(2.59038718303791);
        when(firstFunctionMock.calc(-3.883185307179586)).thenReturn(0.25924033472324);
        when(secondFunctionMock.calc(0.060004)).thenReturn(154.98910563701008);
        when(secondFunctionMock.calc(2.72)).thenReturn(-0.3983952993177911);
        when(secondFunctionMock.calc(6.4)).thenReturn(-1.9368806934099014);
        systemFunctions = new SystemFunctions(accuracy);
        systemFunctions.firstFunction = firstFunctionMock;
        systemFunctions.secondFunction = secondFunctionMock;
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(-6.283185307179586),
                arguments(-4.71238898038469),
                arguments(-3.141592653589793),
                arguments(-1.5707963267948966),
                arguments(0.0)
        );
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(-6.082385307179586, 5.31187237538517),
                arguments(-5.682785307179586, 2.59038718303791),
                arguments(-3.883185307179586, 0.25924033472324),
                arguments(0.060004, 154.98910563701008),
                arguments(2.72, -0.3983952993177911),
                arguments(6.4, -1.9368806934099014)
        );
    }

    @DisplayName("Integration Test with Mocks - exceptions")
    @ParameterizedTest(name = "{index}: With PI/2 x = {0}")
    @MethodSource("withExceptionsProvider")
    void test_0(Double value)  {
        assertThrows(FunctionsException.class,() -> systemFunctions.calc(value));
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_1(Double value, Double expected) throws FunctionsException {
        assertEquals(expected, systemFunctions.calc(value), accuracy);
    }
}
