public class EmployeeTest {
    public static void main(String[] args) {
        // Örnek kullanım
        Employee employee = new Employee(" Kemal", 2000, 45, 1985);
        System.out.println(employee);
        System.out.println("Tax: " + employee.tax());
        System.out.println("Bonus: " + employee.bonus());
        employee.raiseSalary();
        System.out.println("After raise: " + employee);
    }
}