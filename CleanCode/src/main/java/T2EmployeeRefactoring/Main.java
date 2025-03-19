package T2EmployeeRefactoring;

public class Main {

    public static void main(String[] args) {
        Employee commissionedEmployee = new CommissionedEmployee("John Doe", 50000, 200000, 0.10, 0.05);
        Employee hourlyEmployee = new HourlyEmployee("Jane Smith", 20, 45, 1.5, 0.05);
        Employee salariedEmployee = new SalariedEmployee("Jim Brown", 120000, 0.10);

        System.out.println("Commissioned Employee Pay: " + commissionedEmployee.calculatePay());
        System.out.println("Commissioned Employee Bonus: " + commissionedEmployee.calculateBonus());

        System.out.println("Hourly Employee Pay: " + hourlyEmployee.calculatePay());
        System.out.println("Hourly Employee Bonus: " + hourlyEmployee.calculateBonus());

        System.out.println("Salaried Employee Pay: " + salariedEmployee.calculatePay());
        System.out.println("Salaried Employee Bonus: " + salariedEmployee.calculateBonus());
    }
}