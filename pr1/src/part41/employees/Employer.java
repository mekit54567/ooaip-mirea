package part41.employees;

/**
 * Сотрудник. income - месячная заработная плата.
 */
public class Employer {
    protected String firstName;
    protected String lastName;
    protected double income;

    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    /** Годовой доход: месячная зарплата умножается на 12. */
    public double getIncome() {
        return income * 12;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
