package T2EmployeeRefactoring;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private double bonusRate;

    public SalariedEmployee(String name, double annualSalary, double bonusRate) {
        super(name);
        this.annualSalary = annualSalary;
        this.bonusRate = bonusRate;
    }

    @Override
    public Money calculatePay() {
        return calculateSalariedPay();
    }

    @Override
    public Money calculateBonus() {
        return calculateSalariedBonus();
    }

    private Money calculateSalariedPay() {
        // Assuming monthly pay for simplicity
        double monthlyPay = annualSalary / 12;
        return new Money((int) monthlyPay);
    }

    private Money calculateSalariedBonus() {
        double bonus = annualSalary * bonusRate;
        return new Money((int) bonus);
    }
}
