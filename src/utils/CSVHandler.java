package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVHandler {
    public static ArrayList<String[]> readCSV(File csvFile) throws Exception{
        ArrayList<String[]> dataList = new ArrayList<String[]>();
        try{
            FileReader csvFileReader= new FileReader(csvFile);
            BufferedReader csvBufferedReader = new BufferedReader(csvFileReader);
            String row;
            int rowNumber = 0;
            while ((row = csvBufferedReader.readLine()) != null) {
                dataList.add(row.split(","));
            }
            csvBufferedReader.close();
        }catch(Exception e){
            throw e;
        }
        return dataList;
    }

    public static void writeToCSV(File csvFile, String[] data){
        try {
            if(!csvFile.exists()){
                csvFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(csvFile, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(String.join(",", data));
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}