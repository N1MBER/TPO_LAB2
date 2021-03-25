package functions;

import exceptions.FunctionsException;

public abstract class Function{

    public double accuracy;

    public Function(double accuracy){
        this.accuracy = accuracy;
    }

    public Function(){
        this.accuracy = 10e-5;
    }

    public abstract double calc(double theta) throws FunctionsException;
}