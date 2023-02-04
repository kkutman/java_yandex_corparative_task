import services.MonthServices;
import services.YearServices;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MonthServices saleManager = new MonthServices();
        String file = saleManager.fileRead("src/file/m.202101.csv");
        String file2 = saleManager.fileRead("src/file/m.202102.csv");
        String file3 = saleManager.fileRead("src/file/m.202103.csv");
        MonthServices saleManager1 = new MonthServices(file);
        MonthServices saleManager2 = new MonthServices(file2);
        MonthServices saleManager3 = new MonthServices(file3);
        YearServices yearServices = new YearServices();
        String yearFile1 = yearServices.fileRead("src/file/y.2021.csv");
        YearServices yearServices1 = new YearServices(yearFile1);


        while (true){
            System.out.println("""
                    Нажмите 1 чтобы получить всю информацию о всех месячных отчётах
                    Нажмите 2 чтобы получить всю информация о годовом отчёте
                    Нажмите 3 чтобы узнать самый прибыльный товар
                    Нажмите 4 чтобы узнать самый cамую большую трату
                    Нажмите 5 чтобы узнать прибыль по каждому месяцу
                    Нажмите 6 чтобы узнать средний расход за все месяцы в году;
                    Нажмите 7 чтобы узнать средний доход за все месяцы в году;
                    """);
            System.out.print("Нажмите : ");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("~~~~~~~  ЯНВАРЬ  ~~~~~~~");
                    System.out.println("                        ");
                    saleManager1.mouths.forEach(System.out::println);
                    System.out.println("~~~~~~~  ФЕВРАЛЬ  ~~~~~~~");
                    System.out.println("                        ");
                    saleManager2.mouths.forEach(System.out::println);
                    System.out.println("~~~~~~~~~  МАРТ  ~~~~~~~");
                    System.out.println("                        ");
                    saleManager3.mouths.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("~~~~~~~~~~ 2021 ~~~~~~~~~~");
                    yearServices1.years.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("~~~~~~~  ЯНВАРЬ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager1.top());
                    System.out.println("~~~~~~~  ФЕВРАЛЬ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager2.top());
                    System.out.println("~~~~~~~~~  МАРТ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager3.top());
                    break;
                case 4:
                    System.out.println("~~~~~~~  ЯНВАРЬ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager1.nonTop());
                    System.out.println("~~~~~~~  ФЕВРАЛЬ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager2.nonTop());
                    System.out.println("~~~~~~~~~  МАРТ  ~~~~~~~");
                    System.out.println("                        ");
                    System.out.println(saleManager3.nonTop());
                    break;
                case 5:
                    System.out.println(yearServices1.profit());
                    break;
                case 6:
                    System.out.println(yearServices1.consumption());
                    break;
                case 7:
                    System.out.println(yearServices1.income());
                    break;


            }



        }

    }
}