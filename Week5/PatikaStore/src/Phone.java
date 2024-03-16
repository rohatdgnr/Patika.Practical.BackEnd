import java.util.Comparator;

public class Phone extends PatikaStore implements Comparator<Phone> {

    public Phone(String name, String brandName, String color,  int price, int sales, int stock, int memory, int inc, int battery, int ram) {
        super(name, brandName, color, price, sales, stock, memory, inc, battery, ram);
    }




    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getPrice() - o2.getPrice();
    }
}