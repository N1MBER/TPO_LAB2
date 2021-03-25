package tests.integration;

import exceptions.FunctionsException;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import system.SecondFunction;
import system.SystemFunctions;

import java.util.stream.Stream;

import static java.lang.Math.log;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogarithmIntegrationTest {

    private static final double accuracy = 10e-5;
    static SystemFunctions sys;

    @BeforeAll
    static void SetUp(){
        sys = new SystemFunctions(accuracy);
    }

    static Stream<Arguments> valuesRangeProviderLogN() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0200818489848),
                arguments(0.040061386738600005),
                arguments(0.060040924492400005),
                arguments(0.0800204622462),
                arguments(0.1),
                arguments(0.1199795377538),
                arguments(0.19598363020304),
                arguments(0.27198772265228),
                arguments(0.34799181510152),
                arguments(0.42399590755076),
                arguments(0.5),
                arguments(1.2),
                arguments(1.9),
                arguments(2.5999999999999996),
                arguments(3.3),
                arguments(4.0),
                arguments(6.4),
                arguments(8.8),
                arguments(11.200000000000001),
                arguments(13.600000000000001)
        );
    }

    @DisplayName("LogN: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLogN")
    void test1(Double value) throws FunctionsException {
        LogarithmN logarithmN = Mockito.mock(LogarithmN.class);
        when(logarithmN.calcLogN(value,accuracy)).thenReturn(Math.sin(value));
        assertEquals(sin(value), logarithmN.calcLogN(value, accuracy), accuracy);
    }

    static Stream<Arguments> valuesRangeProviderLog3() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0200818489848),
                arguments(0.040061386738600005),
                arguments(0.060040924492400005),
                arguments(0.0800204622462),
                arguments(0.1),
                arguments(0.1),
                arguments(0.28),
                arguments(0.46),
                arguments(0.64),
                arguments(0.8200000000000001),
                arguments(1.1),
                arguments(1.6800000000000002),
                arguments(2.2600000000000002),
                arguments(2.8400000000000003),
                arguments(3.4200000000000004),
                arguments(4.0),
                arguments(6.4),
                arguments(8.8),
                arguments(11.200000000000001),
                arguments(13.600000000000001)
        );
    }

    @DisplayName("Log3: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog3")
    void test2(Double value) throws FunctionsException {
        Logarithm3 logarithm3 = Mockito.mock(Logarithm3.class);
        when(logarithm3.calcLog3(value,accuracy)).thenReturn(Math.sin(value));
        assertEquals(sin(value), logarithm3.calcLog3(value, accuracy), accuracy);
    }

    static Stream<Arguments> valuesRangeProviderLog5() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0400818489848),
                arguments(0.0800613867386),
                arguments(0.1200409244924),
                arguments(0.1600204622462),
                arguments(0.2),
                arguments(0.36),
                arguments(0.52),
                arguments(0.68),
                arguments(0.8400000000000001),
                arguments(1.1),
                arguments(3.08),
                arguments(5.0600000000000005),
                arguments(7.040000000000001),
                arguments(9.020000000000001)
        );
    }

    @DisplayName("Log5: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog5")
    void test3(Double value) throws FunctionsException {
        Logarithm5 logarithm5 = Mockito.mock(Logarithm5.class);
        when(logarithm5.calcLog5(value,accuracy)).thenReturn(Math.sin(value));
        assertEquals(sin(value), logarithm5.calcLog5(value, accuracy), accuracy);
    }

    static Stream<Arguments> valuesRangeProviderLog10() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0400818489848),
                arguments(0.0800613867386),
                arguments(0.1200409244924),
                arguments(0.1600204622462),
                arguments(0.2),
                arguments(0.36),
                arguments(0.52),
                arguments(0.68),
                arguments(0.8400000000000001),
                arguments(1.1),
                arguments(3.08),
                arguments(5.0600000000000005),
                arguments(7.040000000000001),
                arguments(9.020000000000001)
        );
    }

    @DisplayName("Log10 Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog10")
    void test4(Double value) throws FunctionsException {
        Logarithm10 logarithm10 = Mockito.mock(Logarithm10.class);
        when(logarithm10.calcLog10(value,accuracy)).thenReturn(Math.sin(value));
        assertEquals(sin(value), logarithm10.calcLog10(value, accuracy), accuracy);
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

    @DisplayName("System Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test5(double value, double expected) throws FunctionsException {
        SecondFunction secondFunction = Mockito.mock(SecondFunction.class);
        when(secondFunction.calc(value)).thenReturn(getValue(value));
        assertEquals(expected, secondFunction.calc(value), accuracy);

    }

    double getValue(double x){
        return (((((log(x) * log(x)/log(3)) * log(x)) +
                log(x)/log(3))) * ((log(x)/log(10) * log(x)/log(5)) -
                log(x)/log(5))) * log(x)/log(5);
    }
}
