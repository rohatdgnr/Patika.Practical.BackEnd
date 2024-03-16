import java.util.Comparator;

public abstract class PatikaStore {

    private String name;
    private String brandName;
    private String color;
    private int price;
    private int sales;
    private int stock;
    private int memory;
    private int inc;
    private int battery;
    private int ram;

    // Telefon için kurucu metot
    public PatikaStore(String name, String brandName, String color, int price, int sales, int stock, int memory, int inc, int battery, int ram) {
        this.name = name;
        this.brandName = brandName;
        this.color = color;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.memory = memory;
        this.inc = inc;
        this.battery = battery;
        this.ram = ram;
    }
    // Notebook için kurucu metot
    public PatikaStore(String name, String brandName, String color, int price, int sales, int stock, int memory, int inc,int ram) {
        this.name = name;
        this.brandName = brandName;
        this.color = color;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.memory = memory;
        this.inc = inc;
        this.ram = ram;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {

        return String.format("| %-10s | %-10s | %-7s | %-9d | %-7d | %-4d | %-6d | %-4d | %-7d | %-4d |",
                name, brandName, color, price, sales, stock, memory, inc, battery, ram);
    }
}