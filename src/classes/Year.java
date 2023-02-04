package classes;
//•	month — месяц. Целое число;
//        •	amount — сумма;
//        •	is_expense — одно из двух значений: true или false. Обозначает,
//        является ли запись тратой (true) или доходом (false).

public class Year {
    public int month;
    public int amount;
    public boolean is_expense;

    public Year(int month, int amount, boolean is_expense) {
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;
    }

    @Override
    public String toString() {
        return  "месяц                           : " + month +"\n"+
                "сумма                           : " + amount +"\n"+
                "тратa (TRUE) или доход (FALSE)  : " + is_expense +"\n";

    }
}
