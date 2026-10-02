package part41.employees;

/**
 * Менеджер - сотрудник, получающий дополнительные выплаты от продаж.
 */
public class Manager extends Employer {
    private double averageSum; // средняя сумма выплат за продажи в месяц

    public Manager(String firstName, String lastName, double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    @Override
    public double getIncome() {
        return super.getIncome() + averageSum * 12;
    }

    @Override
    public String toString() {
        return super.toString() + " (менеджер)";
    }
}
