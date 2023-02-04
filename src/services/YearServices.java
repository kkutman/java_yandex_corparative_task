package services;

import classes.Mouth;
import classes.Year;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearServices {
    public ArrayList<Year>years = new ArrayList<>();

    public YearServices(String file){
        String files = file;
        String[] array = file.split("\n");
        for (int i = 1; i < array.length; i++) {
            String arr = array[i];
            String[] mas = arr.split(",");
            int month = Integer.parseInt(mas[0]);
            int amount = Integer.parseInt(mas[1]);
            boolean is_expense = Boolean.parseBoolean(mas[2]);
            Year year = new Year(month,amount,is_expense);
            years.add(year);
        }
    }
    public YearServices(){}






    public String fileRead(String file) {
        try {
            return Files.readString(Path.of(file));
        } catch (IOException e) {
            System.out.println("file not !!!");
        }
        return null;
    }

    public static Boolean method(){
        int[]num = {1,1,2,3,3,6};
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                for (int k = j+1; k < num.length; k++) {
                    if(num[i]==num[j]){
                        if(num[j]==num[k]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public HashMap<Integer,Integer> profit(){
        HashMap<Integer,Integer> profit = new HashMap<>();
        for (int i = 0; i < years.size(); i++) {
            for (int j = i+1; j < years.size() ; j++) {
                if(years.get(i).month==years.get(j).month){
                    if (years.get(i).is_expense!=years.get(j).is_expense){
                        profit.put(years.get(i).month,(years.get(i).amount-years.get(j).amount));
                    }
                }
            }
        }
        return profit;
    }
    public String consumption(){
        int count =  0;
        int num = 0;
        for (Year year : years) {
            if (year.is_expense){
                num+= year.amount;
                count++;
            }
        }
        return "consumption 2021 : "+(num/count);
    }

    public String income(){
        int count =  0;
        int num = 0;
        for (Year year : years) {
            if (!year.is_expense){
                num+= year.amount;
                count++;
            }
        }
        return "income 2021 : "+(num/count);
    }


}
