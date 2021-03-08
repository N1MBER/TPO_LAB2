package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private FileWriter fileWriter;
    private File file;
    private String fileName = "result-data.csv";

    CSVWriter()  {
        try{
            file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            this.fileWriter = new FileWriter(file, true);
        }catch (IOException e){
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public void finish(){
       try {
           fileWriter.flush();
           fileWriter.close();
       }catch (IOException e){

       }
    }

    private void writeValue(String str) throws IOException {
        fileWriter.write(str + "\n");
    }

    public void writeToFile(String str){
        try{
            writeValue(str);
        }catch (IOException e){
            System.err.println("Произошла ошибка записи: " + e.getMessage());
        }
    }
}
