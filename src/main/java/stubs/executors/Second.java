package main.java.stubs.executors;

import main.java.logorithm.LogorithmException;
import main.java.logorithm.LogorithmFunction;
import main.java.trigonometric.TrigonometricException;
import main.java.trigonometric.TrigonometricFunction;

import java.util.ArrayList;
import java.util.Iterator;

public class Second {
    private ArrayList<String> arrayList;

    public Second(){
        arrayList = new ArrayList<>();
        arrayList.add("ln");
        arrayList.add("exp");
        arrayList.add("log3");
        arrayList.add("log5");
        arrayList.add("log10");
        arrayList.add("logexp");
        arrayList.add("sin");
        arrayList.add("cos");
        arrayList.add("cot");
        arrayList.add("trigexp");
        arrayList.add("trigexp");
    }

    public void execute(){
        getCommand();
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            try {
                String[] str_arr = new String[] {iterator.next(),new Double(Math.random() * 10).toString()};
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
                double value = analyzeValue(str_arr[0], new Double(str_arr[1]));
                System.out.println("Значение: " + value);
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

    private double analyzeValue(String type, double x) throws LogorithmException, TrigonometricException {
        double result = Double.NaN;
        switch (type){
            case "ln":{
                result = LogorithmFunction.lnx(x);
                break;
            }
            case "log3":{
                result = LogorithmFunction.log_3x(x);
                break;
            }
            case "log5":{
                result = LogorithmFunction.log_5x(x);
                break;
            }
            case "log10":{
                result = LogorithmFunction.log_10x(x);
                break;
            }
            case "logexp":{
                result = LogorithmFunction.calculateExpression(x);
                break;
            }
            case "sin":{
                result = TrigonometricFunction.sinx(x);
                break;
            }
            case "cos":{
                result = TrigonometricFunction.cosx(x);
                break;
            }
            case "cot":{
                result = TrigonometricFunction.cotx(x);
                break;
            }
            case "trigexp":{
                result = TrigonometricFunction.calculateExpression(x);
                break;
            }
            case "exp":{
                if (x <= 0)
                    result = TrigonometricFunction.calculateExpression(x);
                else
                    result = LogorithmFunction.calculateExpression(x);
                break;
            }
        }
        return result;
    }
}