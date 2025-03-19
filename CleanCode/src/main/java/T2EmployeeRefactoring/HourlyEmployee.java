package T2EmployeeRefactoring;

public class HourlyEmployee extends  Employee{
    private double hourlyWage;
    private double hoursWorked;
    private double overtimeRate; // e.g., 1.5 for 50% more pay for overtime
    private double bonusRate; // e.g., 0.05 for 5%

    public HourlyEmployee(String name, double hourlyWage, double hoursWorked, double overtimeRate, double bonusRate) {
        super(name);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
        this.bonusRate = bonusRate;
    }

    @Override
    public Money calculatePay() {
        return calculateHourlyPay();
    }

    @Override
    public Money calculateBonus() {
        return calculateHourlyBonus();
    }

    private Money calculateHourlyPay() {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double totalPay = (regularHours * hourlyWage) + (overtimeHours * hourlyWage * overtimeRate);
        return new Money((int) totalPay);
    }

    private Money calculateHourlyBonus() {
        double totalEarnings = calculateHourlyPay().amount();
        double bonus = totalEarnings * bonusRate;
        return new Money((int) bonus);
    }
}
