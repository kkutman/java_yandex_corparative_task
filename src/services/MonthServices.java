package services;

import classes.Mouth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class MonthServices {
    public MonthServices() {
    }

    public ArrayList<Mouth> mouths = new ArrayList<>();

    public MonthServices(String file) throws IOException {
        String files = file;
        String[] array = file.split("\n");
        for (int i = 1; i < array.length; i++) {
            String arr = array[i];
            String[] mas = arr.split(",");
            String item_name = mas[0];
            boolean is_expense = Boolean.parseBoolean(mas[1]);
            int quantity = Integer.parseInt(mas[2]);
            int sum_of_one = Integer.parseInt(mas[3]);
            Mouth mouth = new Mouth(item_name,is_expense,quantity,sum_of_one);
            mouths.add(mouth);
        }
    }

    public String fileRead(String...file) {
        for (String s : file) {
            try {
                return Files.readString(Path.of(s));
            } catch (IOException e) {
                System.out.println("file not !!!");
            }
        }

        return null;
    }
    public int [] num(){
        int [] num = new int[mouths.size()];
        int i = 0;
        for (Mouth mouth : mouths) {
            if(!mouth.is_expense){
                i++;
                num[i] = mouth.quantity * mouth.sum_of_one;
            }

        }
        Arrays.sort(num);
        return num;
    }
    public int [] nonNum(){
        int [] num = new int[mouths.size()];
        int i = 0;
        for (Mouth mouth : mouths) {
            if(mouth.is_expense){
                i++;
                num[i] = mouth.quantity * mouth.sum_of_one;
            }

        }
        Arrays.sort(num);
        return num;
    }
    public Mouth top(){


        for (Mouth mouth : mouths) {
            if(!mouth.is_expense){
                if((mouth.quantity*mouth.sum_of_one)==num()[num().length-1]){
                    return mouth;
                }
            }
        }
        return null;
    }
    public Mouth nonTop(){
        for (Mouth mouth : mouths) {
            if(mouth.is_expense){
                if((mouth.quantity*mouth.sum_of_one)==nonNum()[nonNum().length-1]){
                    return mouth;
                }
            }
        }
        return null;
    }
}
