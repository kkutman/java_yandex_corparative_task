package classes;
//    ,,,sum_of_one
//    Воздушные шарики,TRUE,5000,5
//    Автоматы с мороженным,TRUE,12,15000
//    Продажа мороженного,FALSE,1000,120

public class Mouth {
    public String item_name;
    public boolean is_expense;
    public int quantity;
    public int sum_of_one;

    public Mouth(String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    @Override
    public String toString() {
        return  "название товара                               : " + item_name +"\n"+
                "тратa (TRUE) или доход (FALSE)                : " + is_expense +"\n"+
                "количество закупленного или проданного товара : " + quantity +"\n"+
                "стоимость одной единицы товара                : " + sum_of_one +"\n";

    }
}
