package executors;

import functions.Function;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import system.FirstFunction;
import system.SecondFunction;
import system.SystemFunctions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double accuracy = 1e-8;
        Function function0 = new LogarithmN(accuracy);
        Function function1 = new Logarithm3(accuracy);
        Function function2 = new Logarithm5(accuracy);
        Function function3 = new Logarithm10(accuracy);
        Function function4 = new Sinus(accuracy);
        Function function5 = new Cosinus(accuracy);
        Function function6 = new Cotangent(accuracy);
        Function function7 = new FirstFunction(accuracy);
        Function function8 = new SecondFunction(accuracy);
        Function function9 = new SystemFunctions(accuracy);
        Function function = function0;
        String file_name = function.getClass().getSimpleName().toString();
        CSVWriter csvWriter = new CSVWriter(file_name + ".csv", function);
        csvWriter.writeRangeFunctionsValue(0.,5.,0.1);
    }


}
