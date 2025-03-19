package T2EmployeeRefactoring;

public class CommissionedEmployee  extends  Employee{
    private double baseSalary;
    private double totalSales;
    private double commissionRate; // e.g., 0.10 for 10%
    private double bonusRate; // e.g., 0.05 for 5%

    public CommissionedEmployee(String name, double baseSalary, double totalSales, double commissionRate, double bonusRate) {
        super(name);
        this.baseSalary = baseSalary;
        this.totalSales = totalSales;
        this.commissionRate = commissionRate;
        this.bonusRate = bonusRate;
    }

    @Override
    public Money calculatePay() {
        return calculateCommissionedPay();
    }

    @Override
    public Money calculateBonus() {
        return calculateCommissionedBonus();
    }

    private Money calculateCommissionedPay() {
        double commission = totalSales * commissionRate;
        double totalPay = baseSalary + commission;
        return new Money((int) totalPay);
    }

    private Money calculateCommissionedBonus() {
        double bonus = totalSales * bonusRate;
        return new Money((int) bonus);
    }
}
