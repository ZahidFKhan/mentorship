package T2EmployeeRefactoring;

public record Money(int amount) {

    @Override
    public String toString() {
        return "$ " + amount;
    }
}
