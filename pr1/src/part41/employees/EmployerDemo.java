package part41.employees;

public class EmployerDemo {
    public static void main(String[] args) {
        // б) переменная типа Employer ссылается на объект типа Manager
        Employer boss = new Manager("Олег", "Смирнов", 90000, 25000);
        System.out.printf("%s: годовой доход %.2f руб.%n", boss, boss.getIncome());
        System.out.println();

        // г) массив типа Employer содержит объекты обоих классов
        Employer[] staff = {
                new Employer("Анна", "Кузнецова", 60000),
                new Manager("Игорь", "Попов", 80000, 15000),
                new Employer("Павел", "Соколов", 55000),
                boss
        };
        double total = 0;
        for (Employer e : staff) {
            System.out.printf("%-26s %12.2f руб.%n", e, e.getIncome());
            total += e.getIncome();
        }
        System.out.printf("Фонд оплаты труда за год: %.2f руб.%n", total);
    }
}
