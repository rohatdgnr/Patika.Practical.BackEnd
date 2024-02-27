import java.time.Year;
 class Employee {
    // Nitelikler
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    // Kurucu Metot
    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Vergi Hesaplama Metodu
    public double tax() {
        if (salary <= 1000) {
            return 0;
        } else {
            return salary * 0.03; // %3 Vergi Uygulanacak
        }
    }

    // Bonus Hesaplama Metodu
    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30; // Her fazladan saat için 30 TL bonus
        } else {
            return 0; // Bonus uygulanmayacak
        }
    }

    // Maaş Artışı Hesaplama Metodu
    public void raiseSalary() {
        int yearsWorked = Year.now().getValue() - hireYear;
        if (yearsWorked < 10) {
            salary *= 1.05; // %5 zam
        } else if (yearsWorked < 20) {
            salary *= 1.10; // %10 zam
        } else {
            salary *= 1.15; // %15 zam
        }
    }

    // Bilgileri String olarak döndüren Metod

    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", workHours=" + workHours + ", hireYear=" + hireYear + '}';
    }
}