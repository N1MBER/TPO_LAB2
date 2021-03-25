package executors;

import exceptions.FunctionsException;
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

import java.util.Scanner;

public class Executor {
    private Scanner scanner;
    private CSVWriter csvWriter;

    private double accuracy = 1e-8;

    LogarithmN logarithmN;
    Logarithm3 logarithm3;
    Logarithm5 logarithm5;
    Logarithm10 logarithm10;
    Sinus sinus;
    Cosinus cosinus;
    Cotangent cotangent;
    FirstFunction firstFunction;
    SecondFunction secondFunction;
    SystemFunctions systemFunctions;

    Executor(){
        scanner = new Scanner(System.in);
        this.csvWriter = new CSVWriter("manually.csv");
        logarithmN = new LogarithmN(accuracy);
        logarithm3 = new Logarithm3(accuracy);
        logarithm5 = new Logarithm5(accuracy);
        logarithm10 = new Logarithm10(accuracy);
        sinus = new Sinus(accuracy);
        cosinus = new Cosinus(accuracy);
        cotangent = new Cotangent(accuracy);
        firstFunction = new FirstFunction(accuracy);
        secondFunction = new SecondFunction(accuracy);
        systemFunctions = new SystemFunctions(accuracy);
    }

    public void execute(){
        getCommand();
        while (true){
            try {
                String str = scanner.nextLine();
                str.trim();
                String[] str_arr = str.split(" ");
                if (str_arr[0].equals("exit")){
                    System.out.println("Завершение работы.");
                    return;
                }
                if (str_arr[0].equals("help")){
                    getCommand();
                    continue;
                }
                if (str_arr.length > 2 || !checkAnswer(str_arr[0])){
                    System.out.println("Некорректный ввод, повторите снова.");
                    continue;
                }
                double value = new Double(str_arr[1]);
                double y = analyzeValue(str_arr[0], value);
                System.out.println("Значение: " + y);
                csvWriter.writeFunctionsValue(value, getFunction(str_arr[0]));
            }catch (Exception e){
                System.out.println("Некорректный ввод, повторите снова.");
                continue;
            }
        }
    }

    private String getMethod(String type, double x){
        String result = "";
        switch (type){
            case "ln":{
                result = "ln(" + x + ")";
                break;
            }
            case "log3":{
                result = "log_3(" + x + ")";
                break;
            }
            case "log5":{
                result = "log_5(" + x + ")";
                break;
            }
            case "log10":{
                result = "log_10(" + x + ")";
                break;
            }
            case "logexp":{
                result = "((((ln(" + x + ") * log_3(" + x + ")) * ln(" + x + "))" +
                        " + log_3(" + x + ")) * ((log_10(" + x + ") * log_5(" + x + "))" +
                        " - log_5(" + x + "))) * log_5(" + x + ")";
                break;
            }
            case "sin":{
                result = "sin(" + x + ")";
                break;
            }
            case "cos":{
                result = "cos(" + x + ")";
                break;
            }
            case "cot":{
                result = "cot(" + x + ")";
                break;
            }
            case "trigexp":{
                result = "cot(" + x + ") + sin(" + x + ") + sin(" + x + ")";
                break;
            }
            case "exp":{
                result = "\t|- cot(" + x + ") + sin(" + x + ") + sin(" + x + "), x <= 0\n" +
                        "\t|\n" +
                        "\t|- ((((ln(" + x + ") * log_3(" + x + ")) * ln(" + x + "))" +
                        " + log_3(" + x + ")) * ((log_10(" + x + ") * log_5(" + x + "))" +
                        " - log_5(" + x + "))) * log_5(" + x + ")\n" ;
                break;
            }
        }
        return result;
    }

    private boolean checkAnswer(String str){
        boolean flag = false;
        switch (str){
            case "ln":
            case "exp":
            case "log3":
            case "log5":
            case "log10":
            case "logexp":
            case "sin":
            case "cos":
            case "cot":
            case "trigexp": {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void getCommand(){
        System.out.println("Список команд:");
        System.out.println("\tНатуральный логарифм: ln x");
        System.out.println("\tЛогарифм от 3: log3 x");
        System.out.println("\tЛогарифм от 5: log5 x");
        System.out.println("\tЛогарифм от 10: log10 x");
        System.out.println("\tФункция для логарифма ((((ln(x) * log_3(x)) * ln(x)) + log_3(x)) * ((log_10(x) * log_5(x)) - log_5(x))) * log_5(x):\n" +
                "\tlogexp x");
        System.out.println("\tСинус: sin x");
        System.out.println("\tКосинус: cos x");
        System.out.println("\tКотангенс: cot x");
        System.out.println("\tТригонометрическая функция (cot(x) + sin(x)) + sin(x):\n" +
                "\ttrigexp x");
        System.out.println("\tСистема функций:\n" +
                "\t|- (cot(x) + sin(x)) + sin(x), x <= 0\n" +
                "\t|\n" +
                "\t|- ((((ln(x) * log_3(x)) * ln(x)) + log_3(x)) * ((log_10(x) * log_5(x)) - log_5(x))) * log_5(x), x > 0\n" +
                "\texp x");
        System.out.println("\thelp: список команд");
        System.out.println("\texit: завершение");
        System.out.println("Введите название команды и значение для рассчета:");
    }

    public Function getFunction(String type){
        switch (type){
            case "ln":{
                return logarithmN;
            }
            case "log3":{
                return logarithm3;
            }
            case "log5":{
                return logarithm5;
            }
            case "log10":{
                return logarithm10;
            }
            case "logexp":{
                return secondFunction;
            }
            case "sin":{
                return sinus;
            }
            case "cos":{
                return cosinus;
            }
            case "cot":{
                return cotangent;
            }
            case "trigexp":{
                return firstFunction;
            }
            default:
            case "exp":{
                return systemFunctions;
            }
        }
    }

    private double analyzeValue(String type, double x) throws FunctionsException {
        double result = Double.NaN;
        switch (type){
            case "ln":{
                result = logarithmN.calcLogN(x,accuracy);
                break;
            }
            case "log3":{
                result = logarithm3.calcLog3(x,accuracy);
                break;
            }
            case "log5":{
                result = logarithm5.calcLog5(x,accuracy);
                break;
            }
            case "log10":{
                result = logarithm10.calcLog10(x,accuracy);
                break;
            }
            case "logexp":{
                result = secondFunction.calc(x);
                break;
            }
            case "sin":{
                result = sinus.calcSin(x,accuracy);
                break;
            }
            case "cos":{
                result = cosinus.calcCos(x,accuracy);
                break;
            }
            case "cot":{
                result = cotangent.calcCtg(x,accuracy);
                break;
            }
            case "trigexp":{
                result = firstFunction.calc(x);
                break;
            }
            case "exp":{
                result = systemFunctions.calc(x);
                break;
            }
        }
        return result;
    }
}
